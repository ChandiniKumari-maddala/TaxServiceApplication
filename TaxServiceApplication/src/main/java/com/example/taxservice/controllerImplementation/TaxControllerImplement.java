package com.example.taxservice.controllerImplementation;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.taxservice.controller.TaxController;
import com.example.taxservice.model.TaxRecord;
import com.example.taxservice.model.TaxRule;
import com.example.taxservice.service.TaxService;

@RestController
public class TaxControllerImplement implements TaxController{

	@Autowired
	TaxService taxService;
	
	
	@Override
	public ResponseEntity<?> saveTax(@RequestBody TaxRule request) {
	
		if(BigDecimal.ZERO.compareTo(request.getPercentage()) == 0)
			return ResponseEntity.badRequest().body("Amount can not be null");
			
			TaxRule taxRecord = taxService.createTaxRule(request);
			return ResponseEntity.status(HttpStatus.CREATED).body(taxRecord);
	}

	@Override
	public ResponseEntity<?> findRecord(@PathVariable("taxId") String taxId) {
	
		
		Optional<TaxRecord> taxRecord = taxService.getTaxRecordById(taxId);
				
		
		if(taxRecord.isPresent())
			return ResponseEntity.ok(taxRecord);
		else
			return ResponseEntity.badRequest().body("TaxREcord details can not be find");
	}

	@Override
	public ResponseEntity<?> findAllRecords(){
		Map<String,TaxRecord> taxRecords= taxService.getAllRecords();
		return ResponseEntity.ok(taxRecords);
		
	}

}
