package com.tryout.microservices.currencyexchangeser.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tryout.microservices.currencyexchangeser.model.ExchangeValue;

@RestController
public class CurrencyController {

	@Autowired
	private Environment env;
	
	@Autowired
	private CurrencyRepository repo;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue convert(@PathVariable String from, @PathVariable String to) {
		ExchangeValue e = repo.findByFromAndTo(from, to);
		e.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return e;
	}
}
