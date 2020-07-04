package com.tryout.microservices.currencyconversionser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.tryout.microservices.currencyconversionser")
@EnableDiscoveryClient
public class CurrencyConversionSerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionSerApplication.class, args);
	}

}
