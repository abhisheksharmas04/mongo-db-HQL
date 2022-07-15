package com.example.demo.service;

import java.util.List;

import com.example.demo.document.Customer;

public interface ICustomerManagementService {
	public List<Customer>fetchCUstomerByRegCadd(String cadd);
	public int fetchCustomerByBillAmountRange(Double start, Double end);
}
