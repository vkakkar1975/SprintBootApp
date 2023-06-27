package com.assignment.vicky.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 
import java.util.Locale; 

@RestController
public class Controller {

	@GetMapping("/getMessage")
	public String getMessage() {
		return "My final assignment #3";
	}
	@GetMapping("/getDate")
	public String getDate() {
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
   		LocalDateTime now = LocalDateTime.now();  
   		return dtf.format(now);
	
	}
	@GetMapping("/getLocale")
	public String getLocale() {
		Locale locale = Locale.getDefault();
        String lang = locale.getDisplayLanguage();
        String country = locale.getDisplayCountry();     
   		return lang +" " +country;
	
	}

}
