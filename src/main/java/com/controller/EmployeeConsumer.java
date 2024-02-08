package com.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name="employees.com")
public interface EmployeeConsumer {
	
	@GetMapping("/hello")
	String getData();

}
