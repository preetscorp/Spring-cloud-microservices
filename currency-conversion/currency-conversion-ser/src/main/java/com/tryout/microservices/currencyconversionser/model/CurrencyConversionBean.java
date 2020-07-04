package com.tryout.microservices.currencyconversionser.model;

import java.math.BigDecimal;

public class CurrencyConversionBean {

	private Long id;
	String from;
	String to;
	BigDecimal convMultiple;
	int quantity;
	BigDecimal total;
	int port;
	
	public CurrencyConversionBean() {
		
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal convMul, int quantity, BigDecimal total) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.convMultiple = convMul;
		this.quantity = quantity;
		this.total = total;
	}
	
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public BigDecimal getConvMultiple() {
		return convMultiple;
	}
	public void setConvMultiple(BigDecimal convMultiple) {
		this.convMultiple = convMultiple;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	
}
