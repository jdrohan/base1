package com.shady.app;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class VehicleAttributeManager {
	
	ArrayList<Vehicle> vehicles;
	int listSize;
	
	public VehicleAttributeManager(ArrayList<Vehicle> vehicles) {
		this.vehicles = vehicles;
		listSize = vehicles.size();
	}
		
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle type.
	 * @return Set<String> returns a Set of vehicle types
	 */
	public Set<String> getVehicleTypes() {
		return getVehicleAttributeOptions("Type");
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle brand.
	 * @return Set<String> returns a Set of vehicle brands
	 */
	public Set<String> getVehicleBrands() {
		return getVehicleAttributeOptions("Brand");
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle color.
	 * @return Set<String> returns a Set of vehicle color
	 */
	public Set<String> getVehicleColors() {
		return getVehicleAttributeOptions("Color");
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle engine type.
	 * @return Set<String> returns a Set of vehicle engine types
	 */
	public Set<String> getVehicleEngineTypes() {
		return getVehicleAttributeOptions("EngineType");
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle year.
	 * @return Set<String> returns a Set of vehicle years
	 */
	public Set<String> getVehicleYears() {
		return getVehicleAttributeOptions("Year");
	}
	
	/**
	 * Using Reflection
	 * Returns a Set<String> where each string in the set is a current vehicle type.
	 * @return Set<String> returns a Set of vehicle types
	 */
	private Set<String> getVehicleAttributeOptions(String attributeName) {
		HashMap<String,Integer> optionMap = new HashMap<String,Integer>();
		Class<Vehicle> vehicle = Vehicle.class;
		try {
			Method method = vehicle.getMethod(attributeName, Vehicle.class); 
			for (int i = 0; i < this.listSize; ++i) {
				optionMap.put((String) method.invoke(this.vehicles.get(i), new Object[] {}),0);
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
		return optionMap.keySet();
	}
	
	
}
