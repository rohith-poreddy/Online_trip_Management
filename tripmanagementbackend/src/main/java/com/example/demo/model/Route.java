package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Route")
public class Route {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long routeId;
	
	@Column
	private String routeFrom;
	
	@Column
	private String routeTo;
	
	@Column
	private LocalDateTime departureTime;
	
	@Column
	private LocalDateTime arrivalTime;
	
	@Column
	private LocalDate doj;
	
	@Column
	private String pickupPoint ;
	
	@Column
	private double fare;
	
	public Route() {
		
	}
    
    public Route( String routeFrom, String routeTo, LocalDateTime departureTime,LocalDateTime arrivalTime,LocalDate doj,String pickupPoint,double fare) {
		super();
		this.routeFrom=routeFrom;
		this.routeTo=routeTo;
		this.departureTime = departureTime;
		this.arrivalTime= arrivalTime;
		this.doj = doj;
		this.pickupPoint = pickupPoint;
		this.fare = fare;
	}
	public long getRouteId() {
		return routeId;
	}
	public void setRouteId(long routeId) {
		this.routeId = routeId;
	}
	public String getRouteFrom() {
		return routeFrom;
	}
	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}
	public String getRouteTo() {
		return routeTo;
	}
	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}
	public LocalDateTime getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(LocalDateTime departureTime) {
		this.departureTime = departureTime;
	}
	public LocalDateTime getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(LocalDateTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public LocalDate getDoj() {
		return doj;
	}
	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}
	public String getPickupPoint() {
		return pickupPoint;
	}
	public void setPickupPoint(String pickupPoint) {
		this.pickupPoint = pickupPoint;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
    
}