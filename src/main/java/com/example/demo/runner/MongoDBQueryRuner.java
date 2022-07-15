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
		// invoke Methods:
		/*service.fetchCustomersDataByAddress("Jpr").forEach(doc ->{
			for(Object att:doc) {
				System.out.print(att);
			}
			System.out.println();
		});*/
		
		service.fetchCustomerByCadd("Jpr").forEach(System.out::println);
	}

}
