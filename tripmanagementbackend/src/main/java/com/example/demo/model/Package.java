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
import javax.validation.constraints.PositiveOrZero;

//import org.hibernate.validator.constraints.UniqueElements;



@Entity
//@UniqueElements
@Table(name="Package")
public class Package {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long packageId;

    @NotBlank(message = "PackageName is mandatory")
	@Column(name="packageName" , unique=true)
	private String packageName;
	
    @NotBlank(message = "PackageDescription is mandatory")
	@Column(name="packageDescription")
    private String packageDescription;
	
    @NotBlank(message = "PackageType is mandatory")
	@Column(name="packageType")
	private String packageType;
	

    @PositiveOrZero(message = "Only postive values allowed")
	@Column(name="packageCost")
	private double packageCost;
	
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="package_id")
    private List <Booking> bookings=new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="package_id")
    private List <@NotBlank(message="Hotel must not be blank")Hotel> hotels=new ArrayList<>();

	

	public Package() {
		
	}
	

	//long packageId,
	public Package( String packageName, String packageDescription, String packageType, double packageCost) {
		//super();
		//this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}


	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}



	public long getPackageId() {
		return packageId;
	}

	public void setPackageId(long packageId) {
		this.packageId = packageId;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public String getPackageDescription() {
		return packageDescription;
	}

	public void setPackageDescription(String packageDescription) {
		this.packageDescription = packageDescription;
	}

	public String getPackageType() {
		return packageType;
	}

	public void setPackageType(String packageType) {
		this.packageType = packageType;
	}

	public double getPackageCost() {
		return packageCost;
	}

	public void setPackageCost(double packageCost) {
		this.packageCost = packageCost;
	}
	
	public List<Booking> getBookings() {
		return bookings;
	}



	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}


}
