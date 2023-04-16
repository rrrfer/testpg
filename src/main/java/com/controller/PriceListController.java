package com.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.PriceList;

@RestController
@RequestMapping("service")
public class PriceListController {
	
	@GetMapping("/")
	String home() {
		//TODO: ...
		return "Hello World!";
	}
  
	@GetMapping("pricelist")
	public List<PriceList> getAllPriceLists(){
		//TODO: Returns hardcoded data, a real world application would return from the database
		List<PriceList> personList = new ArrayList<PriceList>();
		personList.add(new PriceList("1","Mickey Mouse", "", true));
		personList.add(new PriceList("2","Donald Duck", "", false));
		return personList;
	} 
	  
	@GetMapping("pricelist/{id}")
	public PriceList getPriceListWithId(@PathVariable Integer personId){
		//TODO: Returns hardcoded data, a real world application would return from the database
		return new PriceList("1","Mickey Mouse", "", true);
	} 
	  
	  
	@PostMapping("pricelist")
	public void addPerson(@RequestBody PriceList person){
		//TODO: Just has a Sysout stmt, a real world application would save this record to the database
		System.out.println("Saving PriceList information");
	}
}
