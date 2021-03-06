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
@Table(name="Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private long adminId;
	
	@NotBlank(message="Admin Name is mandatory")
	@Column
	private String adminName;
	
	@Column
	private String password;
	
	@Email(message = "Enter valid email address")
	@Column
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{10})",message="length must be 10 and valid")
	@Column
	private String mobile;
	
	public Admin() {
		
	}
	
	public Admin(String adminName, String password, String email, String mobile) {
		this.adminName = adminName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
	}
	public long getAdminId() {
		return adminId;
	}
	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
}

