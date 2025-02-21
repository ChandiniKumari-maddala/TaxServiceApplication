package com.example.taxservice.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class TaxRule {
	
	private String id;
	private BigDecimal percentage;
	private LocalDateTime createdAt;
	public String getId() {
		return id;
	}
	
	public TaxRule() {
		
	}
	
	public TaxRule(BigDecimal percentage) {
		super();
		this.id = UUID.randomUUID().toString();
		this.percentage = percentage;
		this.createdAt = LocalDateTime.now();
	}

	public void setId(String id) {
		this.id = id;
	}
	public BigDecimal getPercentage() {
		return percentage;
	}
	public void setPercentage(BigDecimal percentage) {
		this.percentage = percentage;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
	

}
