package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;

import com.example.demo.repository.ICustomerRepository;
import com.example.demo.repository.IFeedbackRepository;

@Service
@Transactional
public class ICustomerService {
	
	@Autowired
	private ICustomerRepository repo;
	
	@Autowired
	IFeedbackRepository feedbackRepo;
	
	public Customer save(Customer customer) {
		String mobileno=customer.getMobileNo();
		String email=customer.getEmail();
		Customer temp1=repo.findByEmail(email);
		Customer temp2=repo.findByMobileNo(mobileno);
		if(temp1!=null && temp2==null)
			throw  new ResourceNotFoundException("A customer already exists with same email please try another with email");
		else if(temp2!=null && temp1==null)
			throw  new ResourceNotFoundException("A customer already exists with same Mobile Number please try another with Mobile Number");
		else if (temp1!=null && temp2!=null)
			throw  new ResourceNotFoundException("A customer already exists with same email and Mobile number. please try another with email and Mobile Number");
		else
			return repo.save(customer);
		
	}
	     
   
    public Customer updateCustomer(Customer customer)  throws ResourceNotFoundException {
    	Customer existingCustomer = repo.findById(customer.getCustomerId()).orElseThrow(()->
        new ResourceNotFoundException("customer not found with email id : " + customer.getCustomerId()));
        existingCustomer.setCustomerName(customer.getCustomerName());
        existingCustomer.setCustomerPassword(customer.getCustomerPassword());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setMobileNo(customer.getMobileNo());
        existingCustomer.setEmail(customer.getEmail());
        return repo.save(existingCustomer);
    }
    
    public String deleteCustomer(Customer customer) {
        repo.findById(customer.getCustomerId()).orElseThrow(()->
        new ResourceNotFoundException("Customer not found with id : " + customer.getCustomerId()));
        long k=customer.getCustomerId();
        long t=feedbackRepo.DeleteByCustomer(customer);
        repo.deleteById(customer.getCustomerId());
        return "Customer with id "+k+"deleted.";
        
    }
    
    public Customer get(Long customerId) {
        return repo.findById(customerId).orElseThrow(()->
                                           new ResourceNotFoundException("customer not found with id : " + customerId));
    	
    }
    
    public  List<Customer> listAll() {
	    List<Customer> temp= repo.findAll();
	    if(temp.isEmpty())
	    	throw new EmptyListException("No Customers!!!");
		return temp;
	}
	

}

