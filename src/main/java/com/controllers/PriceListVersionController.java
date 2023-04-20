package com.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.PriceList;
import com.model.PriceListVersion;
import com.repository.PriceListRepository;
import com.repository.PriceListVersionRepository;

@RestController
@RequestMapping("/pricelistversion")
public class PriceListVersionController {
	@Autowired
    private PriceListRepository priceListRepo;
	 
    @Autowired
    private PriceListVersionRepository priceListVersionRepo;
    
    @GetMapping("/")
    ResponseEntity<?> getAllPriceListVersions() {
    	return new ResponseEntity<>(priceListVersionRepo.findAll(), HttpStatus.OK);
	}

    @GetMapping("/search/findByIsActive/{isActive}")
    ResponseEntity<?> findByDescription(@PathVariable(value = "isActive") Boolean isActive) {
    	return new ResponseEntity<>(priceListVersionRepo.findByIsActive(isActive), HttpStatus.OK);
	}
  
    @PostMapping("/{priceListId}")
	public String savePriceListVersion(@PathVariable String priceListId, @RequestBody PriceListVersion priceListVersion) {
    	System.out.println("\n\nadd " + priceListId + "\n" 
    			+ priceListVersion.getVersion() + "\n" 
    			+ priceListVersion.getActiveFrom() + "\n" 
    			+ priceListVersion.getActiveTo() + "\n" 
    			+ priceListVersion.getIsActive() + "\n" );
    	
		Optional<PriceList> priceList = priceListRepo.findById(priceListId);
		if (priceList.isEmpty()) {
			return "no such priceList id";
		}
		
		System.out.println("\n\npriceList is ok\n");
		
		priceListVersion.setPriceList(priceList.get());
		priceListVersionRepo.save(priceListVersion);
    	return "ok";	// link to new object
    }
    
    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteById(@PathVariable(value = "id") String id) {
    	if (priceListVersionRepo.findById(id).isEmpty()) {
    		return new ResponseEntity<>("no such id", HttpStatus.OK);
    	}
    	priceListVersionRepo.deleteById(id);
    	return new ResponseEntity<>("ok", HttpStatus.OK);
    }
}