package com.in28Minutes.microservices.currancyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currancy-exchange", url="localhost:8000")
public interface CurrencyExchangeProxy {

	@GetMapping("/currancy-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeService(@PathVariable String from,@PathVariable String to);
}
