package com.example.taxservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taxservice.model.TaxRule;


@RequestMapping("/tax")
public interface TaxController {
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveTax(@RequestBody TaxRule request);
	
	@GetMapping(value = "{taxId}", produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> findRecord(@PathVariable("taxId") String taxId);
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> findAllRecords();

}
