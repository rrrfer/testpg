package com.controllers;

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

@RestController
@RequestMapping("pricelist")
public class PriceListController {
	@Autowired
    private PriceListRepository priceListRepo;
	 
    //@Autowired
    //private PriceListVersionRepository priceListVersionRepo;
    
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
    public ResponseEntity<?> addPriceList(@RequestBody PriceList priceList){
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
    	
/*#include <string>
using namespace std;

struct priceList;

PriceList addPriceList(stding pCode, string pDescription) {
    bool isActive = false;

    PriceList priceList;

    if (prices.existPrice(pCode) == true) {
        if (priceVersions.find(pCode, isActive = true) == true) {
            isActive = true;
        }

        priceList = prices.get(pCode);
    }
    else {
        isActive = true;
    }

    if (priceList.notCreated()) {
        priceList = new PriceList();
    }

    priceList.code = pCode;
    priceList.description = pDescription;
    priceList.isActive = isActive;

    prices.save(priceList);

    return priceList.id();
}*/