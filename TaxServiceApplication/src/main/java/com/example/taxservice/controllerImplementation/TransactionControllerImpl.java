package com.example.taxservice.controllerImplementation;

import java.math.BigDecimal;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxservice.controller.TransactionController;
import com.example.taxservice.model.Transaction;
import com.example.taxservice.service.TaxService;

@RestController
public class TransactionControllerImpl  implements TransactionController{
	
	@Autowired
	TaxService taxService;

	@Override
	public ResponseEntity<?> saveTransaction(@RequestBody Transaction request) {
		if(BigDecimal.ZERO.compareTo(request.getAmount()) == 0)
		return ResponseEntity.badRequest().body("Amount can not be null");
		
		Transaction transaction = taxService.createTransaction(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(transaction);
	}

	@Override
	public ResponseEntity<?> findTransaction(@PathVariable("id") String request) {
		
		Transaction transaction = taxService.getTransaction(request);
		
		if(transaction !=null) 
			return ResponseEntity.ok(transaction);
		else
			return ResponseEntity.badRequest().body("Transaction details can not be find");
	}

	@Override
	public ResponseEntity<?> findAllTransactions() {
		Map<String,Transaction> transactions= taxService.getAllTransaction();
		return ResponseEntity.ok(transactions);
	}

}
