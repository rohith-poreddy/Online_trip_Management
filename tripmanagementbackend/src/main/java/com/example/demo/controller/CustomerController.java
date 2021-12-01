package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;

import com.example.demo.service.ICustomerService;


@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	ICustomerService cutomerService;
	
	@PostMapping(value="/addCustomer")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer) throws ResourceNotFoundException {
		return new ResponseEntity<>(cutomerService.save(customer),HttpStatus.CREATED);
	}
	
	@PutMapping(value="/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws ResourceNotFoundException {
		return new ResponseEntity<>(cutomerService.updateCustomer(customer),HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteCustomer")
	public ResponseEntity<String> deleteCustomer(@RequestBody Customer customer) throws ResourceNotFoundException {
		return new ResponseEntity<>(cutomerService.deleteCustomer(customer),HttpStatus.OK);
	}
	
	@GetMapping(value="/viewCustomer/{customerId}")
	public ResponseEntity<Customer> viewCustomer(@PathVariable(value="customerId")long customerId) throws ResourceNotFoundException {
		return new ResponseEntity<>(cutomerService.get(customerId),HttpStatus.OK);
	}
	
	@GetMapping(value="/viewAllCustomers")
	public ResponseEntity<List<Customer>> viewAllCustomers() throws ResourceNotFoundException {
		return new ResponseEntity<>(cutomerService.listAll(),HttpStatus.OK);
	}
	
	
	
}
