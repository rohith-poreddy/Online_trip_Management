package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Customer;


public interface ICustomerRepository extends JpaRepository<Customer,Long> {
	 //Customer findByCustomerName(String customerName);
}
