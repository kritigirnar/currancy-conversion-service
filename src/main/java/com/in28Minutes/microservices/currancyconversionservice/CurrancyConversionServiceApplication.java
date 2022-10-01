package com.in28Minutes.microservices.currancyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CurrancyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrancyConversionServiceApplication.class, args);
	}

}
