package com.example.demo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="feed_back")
public class FeedBack {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long feedbackId;
	
	@Column
    private String feedbackdetails;
	
	@Column
	private int rating;
	
	@Column
	private LocalDate submitDate;
	
	public long getFeedbackid() {
		return feedbackId;
	}

	public void setFeedbackid(long feedbackid) {
		this.feedbackId = feedbackid;
	}

	public String getFeedback() {
		return feedbackdetails;
	}

	public void setFeedback(String feedbackdetails) {
		this.feedbackdetails = feedbackdetails;
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