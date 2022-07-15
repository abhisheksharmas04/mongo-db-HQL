package com.example.demo.service;

import java.util.List;

import com.example.demo.document.Customer;

public interface ICustomerManagementService {
	public List<Object[]> fetchCustomersDataByAddress(String address);
	public List<Customer>fetchCustomerByCadd(String address);
}
