package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Bus")
public class Bus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long busId;
	
	@Column
	private String busType;
	
	@Column
	private String busNumber;
	
	@Column
	private int capacity;
	
	public Bus() {
		
	}
	
	public Bus(String busType, String busNumber, int capacity) {
		super();
		this.busType = busType;
		this.busNumber = busNumber;
		this.capacity = capacity;
	}

	public long getBusId() {
		return busId;
	}

	public void setBusId(long busId) {
		this.busId = busId;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public String getBusNumber() {
		return busNumber;
	}

	public void setBusNumber(String busNumber) {
		this.busNumber = busNumber;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	
	
	

}
