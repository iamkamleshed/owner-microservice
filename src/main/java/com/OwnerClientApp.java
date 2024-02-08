package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.controller.EmployeeConsumer;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@RequestMapping("/v1")
public class OwnerClientApp {
	
	@Autowired
	//private RestTemplate restTemplate;
	private EmployeeConsumer employeeConsumer;
	
	
	@GetMapping("/employee")
	String foo() {
		
//		String foo(@RequestParam String name ) {
//		System.out.println(restTemplate.hashCode());
//		
//		//EmployeeVO employeeVO = //GET
//				//this.restTemplate.getForObject("http://banking-api-emp/v2/employees/900",EmployeeVO.class);
//		
//		//String gotItFromOtherApp=this.restTemplate.getForObject("http://localhost:8080/hello",String.class);
//		String gotItFromOtherApp=this.restTemplate.getForObject("http://employees.com/hello",String.class);
//		
//		//http://localhost:8080/hello
//		System.out.println(gotItFromOtherApp+"7777777777777777777777777777");	
//		
//		return gotItFromOtherApp;		
		
		return employeeConsumer.getData();
	}
	
	@Bean
	@LoadBalanced //necessary to use to avoid hardcoded port no
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	public static void main(String[] args) {		
		
		 SpringApplication.run(OwnerClientApp.class, args);			

	}
}
