package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.FeedBack;
import com.example.demo.service.IFeedbackService;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {
	
	@Autowired
	IFeedbackService feedbackService;
	
	@PostMapping(value="/addfeedback/{customerId}")
	public ResponseEntity<FeedBack> addfeedback(@PathVariable(value="customerId")long customerId,@RequestBody FeedBack feedback) throws ResourceNotFoundException {
		return new ResponseEntity<>(feedbackService.addfeedback(customerId, feedback),HttpStatus.CREATED);
	}
	
	@GetMapping("/viewfeedback/{feedbackId}")
	public ResponseEntity<FeedBack> findByfeedbackId(@PathVariable(value="feedbackId")long id) throws ResourceNotFoundException{
		return new ResponseEntity<>(feedbackService.findByfeedbackId(id),HttpStatus.OK);
	}
	
	@GetMapping("/viewfeedbacks/{customerId}")
	public ResponseEntity<List<FeedBack>> findByCustomerId(@PathVariable(value="customerId")long id) throws ResourceNotFoundException{
		return new ResponseEntity<>(feedbackService.findByCustomerId(id),HttpStatus.OK);
	}
	@GetMapping("/")
	public ResponseEntity<List<FeedBack>> viewAllFeedbacks(){
		return new ResponseEntity<>(feedbackService.viewAllFeedbacks(),HttpStatus.OK);
	}

}
