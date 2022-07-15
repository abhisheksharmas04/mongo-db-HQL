package com.example.demo.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.document.Customer;

public interface ICustomerRepo extends MongoRepository<Customer, String> {
	
	@Query(fields = "{cno:1,cname:1,cadd:1}", value = "{cadd:?0}")
	public List<Object[]>getCustomerData(String cadd);
	
	@Query(fields = "{}", value = "{cadd:?0}") // Empty flower bracks is suffficent to get all the fields
	public List<Customer>getCustomerByCadd(String add);
	
	@Query(fields = "{id:1, cno:1, cname:1, cadd:1}", value = "{$or:[{cadd:?0},{cname:?1}]}")
	public List<Object[]>getCustomerByCaddOrName(String add, String name);
	
	@Query(fields = "{id:1, cno:1, cname:1, cadd:1}", value = "{billAmt:{$gt:?0},billAmt:{$lt:?1}}")
	public List<Object[]>getCustomerByBillAmounthRange(Double start, Double end);

}


