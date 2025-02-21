package com.example.taxservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Transaction {
	private String id;
	private BigDecimal amount;
	private LocalDateTime createdAt;
	
	public Transaction()
	{
	
	}
	
	public Transaction(BigDecimal amount)
	{
		this.id=UUID.randomUUID().toString();
		this.amount=amount;
		this.createdAt=LocalDateTime.now();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}	

	
}
