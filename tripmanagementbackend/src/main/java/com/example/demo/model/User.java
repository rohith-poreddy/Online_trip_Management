package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long userId;
	
	@NotBlank(message = "customerName is mandatory")
	@Column(name="userType")
	private String userType;
	
	@Column(name="password")
	private String password;
	
	

	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List <Booking> bookings=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List <Customer> customers=new ArrayList<>();

	

	public User() {
		
	}
	
	public User(long id,String userType,String password)
	{
		this.userId=id;
		this.userType=userType;
		this.password=password;
	}
	public List<Booking> getBookings() {
		return bookings;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
