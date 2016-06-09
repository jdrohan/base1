package com.shady.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Set;

public class VehicleAverageManager {
	
	ArrayList<Vehicle> vehicles;
	int listSize;
	private VehicleAttributeManager vehicleAttributeManager;
	
	public VehicleAverageManager(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
		listSize = vehicles.size();
		vehicleAttributeManager = new VehicleAttributeManager(vehicles);
	}
	
	public ArrayList<Vehicle> getAveragePriceByType() {
		return getAveragePriceByAttributeOption("Type",vehicleAttributeManager.getVehicleTypes());
	}
	
	public ArrayList<Vehicle> getAveragePriceByBrand() {
		return getAveragePriceByAttributeOption("Brand",vehicleAttributeManager.getVehicleBrands());
	}
	
	public ArrayList<Vehicle> getAveragePriceByColor() {
		return getAveragePriceByAttributeOption("Color",vehicleAttributeManager.getVehicleColors());
	}
	
	public ArrayList<Vehicle> getAveragePriceByEngineType() {
		return getAveragePriceByAttributeOption("EngineType",vehicleAttributeManager.getVehicleEngineTypes());
	}
	
	public ArrayList<Vehicle> getAveragePriceByYear() {
		return getAveragePriceByAttributeOption("Year",vehicleAttributeManager.getVehicleYears());
	}
	
	/**
	 * Using Reflection
	 * Returns a Set<String> where each string in the set is a current vehicle type.
	 * @return Set<String> returns a Set of vehicle types
	 */
	private ArrayList<Vehicle> getAveragePriceByAttributeOption(String attributeName,Set<String> options) {
		ArrayList<Vehicle> vehiclesAvg = new ArrayList<Vehicle>();
		Class<Vehicle> vehicle = Vehicle.class;
		try {
			Method method = vehicle.getMethod(attributeName, Vehicle.class); 
			for (String option : options) {
				int sumPrice = 0;
				int numOfVehicles = 0;
				int avgPrice = 0;
				for (int i = 0; i < this.listSize; ++i) {
					Vehicle aVehicle = this.vehicles.get(i);
					String anOption = (String) method.invoke(this.vehicles.get(i), new Object[] {});
					if (anOption.equals(option)) {
						sumPrice += aVehicle.getPrice();
						++numOfVehicles;
					}
			}
			if(numOfVehicles > 0) {
				avgPrice = sumPrice / numOfVehicles;
			}
			vehiclesAvg.add(new Vehicle(option,avgPrice));
		}
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vehiclesAvg;
	}

}
