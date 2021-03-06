package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;



@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long customerId;
	
	@NotBlank(message = "customerName is mandatory")
	@Column
    private String customerName;
	
	@Column
	private String customerPassword;
	
	@NotBlank(message = "address is mandatory")
	@Column
	private String address;
	
	@Pattern(regexp="(^$|[0-9]{10})",message="length must be 10 and valid")
	@Column
	private String mobileNo;
	
	@Email(message = "Enter valid email address")
	@Column
	private String email;
	
//	@OneToMany(cascade=CascadeType.ALL)
//    @JoinColumn(name="customer_id")
//    private List <FeedBack> feedbacks=new ArrayList<>();
//	
	public Customer() {
		
	}
	public Customer(String customerName, String customerPassword, String address, String mobileNo, String email
			) {
		super();
		this.customerName = customerName;
		this.customerPassword = customerPassword;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		//this.feedbacks = feedbacks;
	}

	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

	
	

}
