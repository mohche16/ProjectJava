package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringController {

	@RequestMapping(method= RequestMethod.GET, path="/add")
	public int add(int num1, int num2) {
		return num1 + num2;
		
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/multiply")
	public int multiply(int num1, int num2) {
		return num1 * num2;
		
	}
	
	@RequestMapping(method= RequestMethod.GET, path="/subtract")
	public int subtract(int num1, int num2) {
		return num1 - num2;
		
	}
}
