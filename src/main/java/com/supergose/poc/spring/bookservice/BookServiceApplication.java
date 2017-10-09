package com.supergose.poc.spring.bookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@EnableEurekaClient
@EnableCircuitBreaker
@SpringBootApplication
public class BookServiceApplication {

	@LoadBalanced
    @Bean
    RestTemplate restTemplate(){
      return new RestTemplate();
    }
	
	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}
}
