package com.supergose.poc.spring.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class BookServiceController {

    @Value("${message:Default message!}")
    private String message;
    
    @Autowired
    private SimpleCalculatorService simpleCalculatorService;
    
    @RequestMapping(value = "/statusmessage")
    public String getStatusMessage(){
    	return this.message;
    }
    
	@RequestMapping(path="/rating", method=RequestMethod.GET)
	public @ResponseBody String getBookRating() {
		return simpleCalculatorService.getRating();
	}
    
}
