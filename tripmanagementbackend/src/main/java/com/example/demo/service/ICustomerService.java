package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;

import com.example.demo.repository.ICustomerRepository;

@Service
@Transactional
public class ICustomerService {
	
	@Autowired
	private ICustomerRepository repo;
	
	public  List<Customer> listAll() {
	    List<Customer> temp= repo.findAll();
	    if(temp.isEmpty())
	    	throw new EmptyListException("No Customers!!!");
		return temp;
	}
	     
	public Customer save(Customer customer) {
		return repo.save(customer);
	}
	
	public Customer get(Long customerId) {
        return repo.findById(customerId).orElseThrow(()->
                                           new ResourceNotFoundException("customer not found with id :" + customerId));
    	
    }
     
    public void delete(Long customerId) {
        repo.findById(customerId).orElseThrow(()->
        new ResourceNotFoundException("Package not found with id :" + customerId));
        repo.deleteById(customerId);
    }
    
    public Customer updateCustomer(Customer customer)  throws ResourceNotFoundException {
    	Customer existingCustomer = repo.findById(customer.getCustomerId()).orElseThrow(()->
        new ResourceNotFoundException("customer not found with email id :" + customer.getCustomerId()));
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerPassword(customer.getCustomerPassword());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setMobileNo(customer.getMobileNo());
        existingCustomer.setEmail(customer.getEmail());
        return repo.save(existingCustomer);
    }
	

}

