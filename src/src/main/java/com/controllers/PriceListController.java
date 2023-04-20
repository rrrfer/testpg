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
import com.repository.PriceListRepository;
import com.repository.PriceListVersionRepository;

@RestController
@RequestMapping("pricelist")
public class PriceListController {
	@Autowired
    private PriceListRepository priceListRepo;
	 
    @Autowired
    private PriceListVersionRepository priceListVersionRepo;
    
    @GetMapping("")
    ResponseEntity<?> getAllPriceLists() {
    	return new ResponseEntity<>(priceListRepo.findAll(), HttpStatus.OK);
	}
    
    @GetMapping("/search/findByDescription/{description}")
    ResponseEntity<?> findByDescription(@PathVariable(value = "description") String description) {
    	return new ResponseEntity<>(priceListRepo.findByDescription(description), HttpStatus.OK);
	}
    
    @GetMapping("/{id}")
    ResponseEntity<?> findById(@PathVariable(value = "id") String id) {
    	return new ResponseEntity<>(priceListRepo.findById(id), HttpStatus.OK);
	}
  
    @PostMapping("")
    /* //standard version: 
    public ResponseEntity<?> addPriceList(@RequestBody PriceList priceList){
    	PriceList priceListObj = priceListRepo.save(priceList);
    	return new ResponseEntity<>(priceListObj, HttpStatus.OK);
	}
	*/
    // custom version:
    public ResponseEntity<?> addPriceList(@RequestBody PriceList priceList) {
    	Boolean isActive = false;
    	Optional<PriceList> price = Optional.empty();
    	
    	if (priceListRepo.existsByCode(priceList.getCode())) {
    		if (priceListVersionRepo.findByPriceListCodeAndIsActive(priceList.getCode(), true).isEmpty() == false) {
    			isActive = true;
    		}
    		price = priceListRepo.findByCode(priceList.getCode());
    	}
    	else {
    		isActive = true;
    	}
    	
    	if (price.isEmpty() == false) {
            priceList.setId(price.get().getId());
        }
    	
    	priceList.setIsActive(isActive);
    	
    	PriceList priceListObj = priceListRepo.save(priceList);
    	return new ResponseEntity<>(priceListObj, HttpStatus.OK);
	}
    
    @DeleteMapping(value = "/{id}")
    ResponseEntity<?> deleteById(@PathVariable String id) {
    	//System.out.println("\n\nSaving PriceList information");
    	if (false == priceListRepo.existsById(id)) {
    		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    	}
    	
    	//!TODO: need to search for check foreign key problem
    	priceListRepo.deleteById(id);
    	return new ResponseEntity<>(id, HttpStatus.OK);
	}
}