package com.example.demo.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.service.ICustomerManagementService;

@Component
public class MongoDBQueryRuner implements CommandLineRunner {
	
	@Autowired
	private ICustomerManagementService service;

	@Override
	public void run(String... args) throws Exception {
//		System.out.println(service.fetchCUstomerByRegCadd("d$"));
		System.out.println(service.fetchCustomerByBillAmountRange(100.0, 1000.0));
	}

}
