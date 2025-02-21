package com.example.taxservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TaxRecord {
	
	private String transactionId;
	private String id;
	private BigDecimal taxAmount;
	private TaxRule taxRule;
	private LocalDateTime createdAt;
	public TaxRecord(String transactionId,BigDecimal taxAmount, TaxRule taxRule) {
		super();
		this.transactionId = transactionId;
		this.id = UUID.randomUUID().toString();
		this.taxAmount = taxAmount;
		this.taxRule = taxRule;
		this.createdAt = LocalDateTime.now();
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getTaxAmount() {
		return taxAmount;
	}
	public void setTaxAmount(BigDecimal taxAmount) {
		this.taxAmount = taxAmount;
	}
	public TaxRule getTaxRule() {
		return taxRule;
	}
	public void setTaxRule(TaxRule taxRule) {
		this.taxRule = taxRule;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	
	
}
