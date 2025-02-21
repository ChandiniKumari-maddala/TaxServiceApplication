package com.example.taxservice.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.taxservice.model.TaxRecord;
import com.example.taxservice.model.TaxRule;
import com.example.taxservice.model.Transaction;

@Service
public class TaxService {

	//Temporarly handled in In-Memory -> Future  purpose to be done in Table
	
	private final Map<String,Transaction>transactions = new HashMap<String,Transaction>();
	private final List<TaxRule>taxRules = new ArrayList<>();
	private final Map<String,TaxRecord>taxRecords = new HashMap<String,TaxRecord>();

	
	public Transaction createTransaction(Transaction transaction)
	{
		transaction = new Transaction(transaction.getAmount());
		
		//transactions.add(transaction);
		//modified the code with map
		transactions.put(transaction.getId(),transaction);
		
		if(!taxRules.isEmpty())
		{
			TaxRule latestRule= taxRules.get(taxRules.size() -1);
			BigDecimal taxAmount = transaction.getAmount()
			.multiply(latestRule.getPercentage().
					divide(BigDecimal.valueOf(100)));
			
			TaxRecord taxRecord = new TaxRecord(transaction.getId(),taxAmount,latestRule);
			taxRecords.put(transaction.getId(), taxRecord);
		}
		return transaction;
	}
	/**provide all Transactions **/
	
	public Map<String,Transaction> getAllTransaction()
	{
		return transactions;
	}
	
	public Transaction getTransaction(String transactionId)
	{
		return transactions.get(transactionId);
	}
	
	/** find Transaction based on transactionId if it is not null **/
	public Optional<Transaction> getTransactionById(Transaction transactionId)
	{
		return Optional.ofNullable(transactions.get(transactionId));
	};
	
	public Optional<Transaction> getTransactionUniqueId(String transactionId)
	{
		return Optional.ofNullable(transactions.get(transactionId));
	};
	
	/** define tax rules based on percentage provided**/
	public TaxRule createTaxRule(TaxRule taxRule)
	{
		taxRule = new TaxRule(taxRule.getPercentage());
		taxRules.add(taxRule);
		return taxRule;
	}
	
	
	/** provide all tax records**/
	
	public Map<String,TaxRecord> getAllRecords()
	{
		return taxRecords;
	}
	
 	
	/**  find specific tax id based on taxrecordId **/
	
	public Optional<TaxRecord> getTaxRecordById(String taxRecordId)
	{
		return Optional.ofNullable(taxRecords.get(taxRecordId));
		
	};
	
	
}


