package com.example.taxservice.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.taxservice.model.Transaction;


@RequestMapping("/transaction")
public interface TransactionController {
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE, produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> saveTransaction(@RequestBody Transaction request);
	
	@GetMapping(path = "/transactionId/{id}", produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> findTransaction(@PathVariable("id") String transactionid);
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> findAllTransactions();

}
