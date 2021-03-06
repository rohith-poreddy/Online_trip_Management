package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Travels")
public class Travels {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long travelId;
	
	@Column
	private String travelName;
	
	@Column
	private String agentName;
	
	@Column
	private String address;
	
	@Column
	private String contact;
	
	public Travels() {
		
	}
	
	public Travels(String travelName, String agentName, String address, String contact) {
		super();
		this.travelName = travelName;
		this.agentName = agentName;
		this.address = address;
		this.contact = contact;
	}

	public long getTravelId() {
		return travelId;
	}

	public void setTravelId(long travelId) {
		this.travelId = travelId;
	}

	public String getTravelName() {
		return travelName;
	}

	public void setTravelName(String travelName) {
		this.travelName = travelName;
	}

	public String getAgentName() {
		return agentName;
	}

	public void setAgentName(String agentName) {
		this.agentName = agentName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
	
	

}
