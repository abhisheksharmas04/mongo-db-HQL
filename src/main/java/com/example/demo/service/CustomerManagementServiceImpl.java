package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.document.Customer;
import com.example.demo.repo.ICustomerRepo;

@Service
public class CustomerManagementServiceImpl implements ICustomerManagementService {
	
	@Autowired
	private ICustomerRepo repo;

	@Override
	public List<Customer> fetchCUstomerByRegCadd(String cadd) {
		return repo.getCustomerByRegCadd(cadd);
	}
	
	@Override
	public int fetchCustomerByBillAmountRange(Double start, Double end) {
		return repo.getCustomersCountByBillAmountRange(start, end);
	}

}
