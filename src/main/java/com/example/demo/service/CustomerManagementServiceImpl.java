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
	public List<Object[]> fetchCustomersDataByAddress(String address) {
		return repo.getCustomerData(address);
	}

	@Override
	public List<Customer> fetchCustomerByCadd(String address) {
		return repo.getCustomerByCadd(address);
	}

}
