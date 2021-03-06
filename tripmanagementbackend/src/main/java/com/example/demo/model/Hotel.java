package com.example.demo.model;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; 
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name="Hotel")
public class Hotel {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long hotelId;
	
	@NotBlank(message = "Hotel Name is mandatory")
	@Column()
	private String hotelName;
	
	@NotBlank(message = "Hotel Type is mandatory")
	@Column
	private String hotelType;
	
	@Column
	private String hotelDescription;
	
	@NotBlank(message = "Address is mandatory")
	@Column(unique=true)
	private String address;
	
	@PositiveOrZero(message = "Only postive values allowed")
	@Column
	private double rent;
	
	@NotBlank(message = "status is mandatory")
	@Column
	private String status ;
	
	
	public Hotel()
	{
		
	}

	public Hotel( String hotelName, String hotelType, String hotelDescription, String address, double rent,
			String status) {
		super();
		//this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelType = hotelType;
		this.hotelDescription = hotelDescription;
		this.address = address;
		this.rent = rent;
		this.status = status;
	}

	
	
	public long getHotelId() {
		return hotelId;
	}

	public void setHotelId(long hotelId) {
		this.hotelId = hotelId;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getHotelType() {
		return hotelType;
	}

	public void setHotelType(String hotelType) {
		this.hotelType = hotelType;
	}

	public String getHotelDescription() {
		return hotelDescription;
	}

	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getRent() {
		return rent;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
