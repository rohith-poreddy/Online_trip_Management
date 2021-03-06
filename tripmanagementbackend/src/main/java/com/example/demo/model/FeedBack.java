package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;




@Entity
@Table(name="Feedback")
public class FeedBack {
	

	
//	@Id
//	@GeneratedValue(generator = "uuid")
//	@GenericGenerator(name = "uuid", strategy = "uuid2")
//	@Column
//	private String feedbackId;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long feedbackId;
	
	@NotBlank(message = "feedback is mandatory")
	@Column
    private String feedbackDetails;
	
	@Min(value = 0 , message = "rating should be greater then then equal to 0")
    @Max(value = 10 , message = "rating should be less then then equal to 10")
	@Column
	private int rating;
	
	@Column
	private LocalDate submitDate;
	
	@ManyToOne(cascade =  CascadeType.ALL)
	@JoinColumn(name="customerId")
	private Customer customer;
	
	public FeedBack() {
		
	}
	
	public FeedBack(String feedbackDetails, int rating, LocalDate submitDate, Customer customer) {
		super();
		this.feedbackDetails = feedbackDetails;
		this.rating = rating;
		this.submitDate = submitDate;
		this.customer = customer;
	}
	
	public Customer getCustomer() {
		return customer;
	}

	

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public long getFeedbackid() {
		return feedbackId;
	}

	public void setFeedbackid(long feedbackid) {
		this.feedbackId = feedbackid;
	}

//	public String getFeedbackid() {
//		return feedbackId;
//	}
//
//	public void setFeedbackid(String feedbackid) {
//		this.feedbackId = feedbackid;
//	}

	public String getFeedback() {
		return feedbackDetails;
	}

	public void setFeedback(String feedbackDetails) {
		this.feedbackDetails = feedbackDetails;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public LocalDate getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(LocalDate submitDate) {
		this.submitDate = submitDate;
	}

	

}
