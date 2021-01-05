package com.in45minutes.microservices;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}") 
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		//ExchangeValue exchangeValue	= new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		//exchangeValue.setPort(8000);
		exchangeValue.setPort(Integer.parseInt(environment.getRequiredProperty("local.server.port")));
		return exchangeValue;
	}
	
	
	
	
	
	
	
	
	
	
	

}
