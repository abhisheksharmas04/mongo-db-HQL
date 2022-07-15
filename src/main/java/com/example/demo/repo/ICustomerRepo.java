package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
	//
	@Query(value = "{cadd:{$regex:?0}}")
	public List<Customer> getCustomerByRegCadd(String add);
	
	@Query(value = "{billAmt:{$gte:?0,$lte:?1}}",count = true)
	public int getCustomersCountByBillAmountRange(Double start, Double end);
	
	@Query(value = "{}",sort = "{billAmt:-1}")
	public List<Customer>getCustomersByBillAmountSorted();
	
	@Query(value = "{billAmt:null}",delete = true)
	public int deleteCustomerWithNoBillAmt();
	
	@Query(value = "{billAmt:{$gte:?0,$lte:?1}}",exists = true)
	public boolean areThereCustomersWithBillAmountRange(Double start, Double end);

}


/*
 	Starting with given data: ^data
 	Ending with given data: data$
 	Having data: data or ^input$(it is not working in some version of Mongo DB
 	
 	Mongo DB Documentation: https://docs.mongodb.com/manual/tutorial/query-documents/
 * */