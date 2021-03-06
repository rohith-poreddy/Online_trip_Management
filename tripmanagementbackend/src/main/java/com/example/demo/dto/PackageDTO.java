package com.example.demo.dto;



public class PackageDTO {

	
	private String packageName;
	

    private String packageDescription;
	

	private String packageType;
	

	private double packageCost;
	
    public PackageDTO() {
		
	}
	

	//long packageId,
	public PackageDTO( String packageName, String packageDescription, String packageType, double packageCost) {
		//super();
		//this.packageId = packageId;
		this.packageName = packageName;
		this.packageDescription = packageDescription;
		this.packageType = packageType;
		this.packageCost = packageCost;
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
	

	
}
