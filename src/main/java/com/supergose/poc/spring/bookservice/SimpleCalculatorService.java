package com.supergose.poc.spring.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class SimpleCalculatorService {

    @Autowired
	RestTemplate restTemplate;
    
    protected final String serviceUrl = "http://supergose-simple-calculator";
    
    @HystrixCommand(fallbackMethod = "reliable")
	public String getRating() {
		return this.restTemplate.getForObject(serviceUrl + "/simplecalculator/rating", String.class);
	}

	public String reliable() {
		return "Simple Calculator not available --> this is a gracefull degradation of the service!";
	}
	
}
