package com.tryout.microservices.currencyconversionser.resource;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tryout.microservices.currencyconversionser.model.CurrencyConversionBean;
import com.tryout.microservices.currencyconversionser.service.CurrencyExchangeProxy;

@RestController
public class CurrencyConvertorController {
	
	@Autowired
	private CurrencyExchangeProxy proxy;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{q}")
	public CurrencyConversionBean convert(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal q) {
		Map<String, String> uriVar = new HashMap<String, String>();
		uriVar.put("from", from);
		uriVar.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> res = new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class, uriVar);
		CurrencyConversionBean obj =res.getBody();
		BigDecimal tot = q.multiply(obj.getConvMultiple()) ;
		obj.setTotal(tot);
		return obj;
		//return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, q, new BigDecimal(100));
	}
	
	

	@GetMapping("/currency-converter/feign/from/{from}/to/{to}/quantity/{q}")
	public CurrencyConversionBean convertFeign(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal q) {
		
		CurrencyConversionBean obj = proxy.retriveInfo(from, to);
		BigDecimal tot = q.multiply(obj.getConvMultiple()) ;
		obj.setTotal(tot);
		return obj;
		//return new CurrencyConversionBean(1L, from, to, BigDecimal.ONE, q, new BigDecimal(100));
	}
}
