package com.shady.app;

public class Vehicle implements Comparable<Vehicle> {

	String type;
	String vin;
	String brand;
	String color;
	String engineType;
	Integer price;
	String year;
	
	String averageProperty;
	
	public Vehicle(String type, String vin, String brand, String color, String engineType, Integer price, String year) {
		super();
		this.type = type;
		this.vin = vin;
		this.brand = brand;
		this.color = color;
		this.engineType = engineType;
		this.price = price;
		this.year = year;
	}
	
	public Vehicle(String averageProperty, Integer price) {
		super();
		this.averageProperty = averageProperty;
		this.price = price;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getVin() {
		return vin;
	}
	public void setVin(String vin) {
		this.vin = vin;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getAverageProperty() {
		return averageProperty;
	}

	public void setAverageProperty(String averageProperty) {
		this.averageProperty = averageProperty;
	}

	public int compareTo(Vehicle vehicle) {
		// Descending Order
		if(this.getPrice() == vehicle.getPrice()) {
			return 0;
		}
		else {
			return this.getPrice() > vehicle.getPrice() ? 1 : -1;
		}

	}
}

