package com.in28Minutes.microservices.currancyconversionservice;

import java.math.BigDecimal;


public class CurrencyConversion {

	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String Environment;
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmmount;
	
	
	public CurrencyConversion()
	{
		
	}
	public CurrencyConversion(long id, String from, String to,BigDecimal quantity, BigDecimal conversionMultiple, 
			 BigDecimal totalCalculatedAmmount,String environment) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		Environment = environment;
		this.quantity = quantity;
		this.totalCalculatedAmmount = totalCalculatedAmmount;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public String getEnvironment() {
		return Environment;
	}
	public void setEnvironment(String environment) {
		Environment = environment;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmmount() {
		return totalCalculatedAmmount;
	}
	public void setTotalCalculatedAmmount(BigDecimal totalCalculatedAmmount) {
		this.totalCalculatedAmmount = totalCalculatedAmmount;
	}
	
}
