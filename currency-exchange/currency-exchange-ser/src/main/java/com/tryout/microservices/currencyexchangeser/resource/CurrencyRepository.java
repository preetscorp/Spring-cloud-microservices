package com.tryout.microservices.currencyexchangeser.resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tryout.microservices.currencyexchangeser.model.ExchangeValue;

@Repository
public interface CurrencyRepository extends JpaRepository<ExchangeValue, Integer>{
	
	public ExchangeValue findByFromAndTo(String from, String to);
	
}
