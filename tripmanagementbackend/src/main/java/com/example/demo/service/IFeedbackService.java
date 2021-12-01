package com.example.demo.service;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.EmptyListException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.Customer;
import com.example.demo.model.FeedBack;
import com.example.demo.repository.ICustomerRepository;
import com.example.demo.repository.IFeedbackRepository;


@Service
@Transactional
public class IFeedbackService {
	@Autowired
	IFeedbackRepository feedbackRepo;
	@Autowired
	ICustomerRepository customerRepo;
	
	public FeedBack addfeedback(long customerId,FeedBack feedback) throws ResourceNotFoundException{
		feedback.setSubmitDate(LocalDate.now());
		Customer c = customerRepo.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer ID: "+customerId+" not found!!"));
		feedback.setCustomer(c);
		return feedbackRepo.save(feedback);
	}
	
	
	public FeedBack findByfeedbackId(long feedbackId) throws ResourceNotFoundException {
		return feedbackRepo.findById(feedbackId).orElseThrow(()->new ResourceNotFoundException("Feedback ID: "+feedbackId+" not found!!"));
	}
		
	
	public List<FeedBack> findByCustomerId(long customerId) throws ResourceNotFoundException{
		if(!customerRepo.existsById(customerId))
			throw new ResourceNotFoundException("Customer ID: "+customerId+" not found!!");
		return feedbackRepo.getByCustomerId(customerId);
	}
	
	public List<FeedBack> viewAllFeedbacks(){
		List<FeedBack> temp=feedbackRepo.findAll();
	    if(temp.isEmpty())
	    	throw new EmptyListException("No Feedbacks!!!");
		return temp;
		
	}
	

}