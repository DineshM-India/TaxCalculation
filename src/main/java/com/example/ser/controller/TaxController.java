package com.example.ser.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ser.model.Tax;
import com.example.ser.service.TaxService;



@RestController
@RequestMapping("/hiber")
public class TaxController {
	@Autowired(required=true)
	private TaxService taxService;
	
	public TaxController(TaxService taxService) {
		super();
		this.taxService = taxService;
	}
	
	
	@PostMapping()
	public   ResponseEntity<Tax> saveTax(@RequestBody Tax tax) {
	 return new ResponseEntity<Tax>(taxService.saveTax(tax),HttpStatus.CREATED);
	}
	
	@PutMapping()
	public void updateTax(@RequestBody Tax tax) {
		 taxService.saveTax(tax);
	}
	
	@GetMapping("/serv")
	public List<Tax> getAllTax(){
		return TaxService.getAllTax();
	}
	
	@GetMapping("/serv/{id}")
	public Tax getTaxById(@PathVariable("id")int id) {
		Tax tax = taxService.getTaxById(id);
		if (tax == null) {
			throw new RuntimeException("service id not found - " + id);
		}
		else {
		return tax;
		}
	}
	@DeleteMapping("/serv/{id}")
	public String removeTax(@PathVariable("id")int id) {
		Tax emp = taxService.getTaxById(id);
		if (emp == null) {
			throw new RuntimeException("Employee id not found - " + id);
		}
		
		taxService.deleteTax(id);
		
		return "Deleted employee id - " + id;
	}	
	}


