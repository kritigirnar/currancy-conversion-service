package com.in28Minutes.microservices.currancyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrancyConversionController {
	
	@Autowired
	CurrencyExchangeProxy proxy;

	@GetMapping("/currancy-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(@PathVariable String from ,@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		HashMap<String, String> uriVariables=new HashMap();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversion> responseEntity=new RestTemplate().getForEntity("http://localhost:8000/currancy-exchange/from/{from}/to/{to}", CurrencyConversion.class,
				uriVariables);
		
		CurrencyConversion currencyConversion=responseEntity.getBody();
		return new CurrencyConversion(10000L,currencyConversion.getFrom(), currencyConversion.getTo(),
				quantity, currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment()+"from Rest Template");
	}

	@GetMapping("/currancy-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String from ,@PathVariable String to,
			@PathVariable BigDecimal quantity)
	{
		
		CurrencyConversion currencyConversion=proxy.retrieveExchangeService(from, to);
		return new CurrencyConversion(10000L,currencyConversion.getFrom(), currencyConversion.getTo(),
				quantity, currencyConversion.getConversionMultiple(),
				quantity.multiply(currencyConversion.getConversionMultiple()),currencyConversion.getEnvironment()+"from feign");
	}

	
}

