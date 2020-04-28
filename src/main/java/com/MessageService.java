package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageService {
	
	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}
	
	
	@GetMapping("/Bootcamp")
	public String sayBootcamp() {
		return "Bootcamp";
	}
	
	@GetMapping("/Addition")
	public int sayAddition(int a,int b) {
		return a+b;
	}
	
	@GetMapping("/Subtraction")
	public int saySubtraction(int a,int b) {
		return a-b;
	}
	
	@GetMapping("/Multiplication")
	public long sayMultiplication(int a,int b) {
		return a*b;
	}
	
}