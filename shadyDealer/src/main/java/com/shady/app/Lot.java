package com.shady.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;


/**
 * The Lot class is a representation of a car dealer lot.
 * It contains a static inventory of vehicles and methods to 
 * evaluate the inventory.
 * 
 * @author jdrohan
 * @version 1.0
 * @since June 6 2016
 */
public class Lot {
	static ArrayList<Vehicle> LOT_LIST = new ArrayList<Vehicle>();
	static int lotSize = 0;
	
	static {
		LOT_LIST.add(new Vehicle("Truck","1234","GMC","Red","Gas",24000,"2016"));
		LOT_LIST.add(new Vehicle("Car","1235","Toyota","Green","Hybrid",27000,"2015"));
		LOT_LIST.add(new Vehicle("Car","1236","Toyota","Red","Gas",19000,"2015"));
		LOT_LIST.add(new Vehicle("Car","1237","Toyota","Blue","Gas",21000,"2014"));
		LOT_LIST.add(new Vehicle("Motorcycle","1238","Honda","Blue","Hybrid",17000,"2016"));
		LOT_LIST.add(new Vehicle("Truck","1239","Honda","Blue","Hybrid",17000,"2016"));
		LOT_LIST.add(new Vehicle("Car","1240","Hyundai","Red","Gas",17000,"2014"));
		LOT_LIST.add(new Vehicle("Car","1241","Tesla","Blue","Electric",85000,"2016"));
		LOT_LIST.add(new Vehicle("Bicycle","1242","Cervelo","White","None",2000,"2015"));
		LOT_LIST.add(new Vehicle("Bicycle","1243","Huffy","White","None",150,"2014"));
		LOT_LIST.add(new Vehicle("Bicycle","1244","Trek","Orange","None",1200,"2016"));
		LOT_LIST.add(new Vehicle("Car","1245","Hyundai","White","Electric",25000,"2009"));
		LOT_LIST.add(new Vehicle("Car","1246","Ford Pinto","Light Blue","Gas",1000,"1984"));
		LOT_LIST.add(new Vehicle("Car","1247","Chevy Vega","Dark Blue","Gas",500,"1981"));
		LOT_LIST.add(new Vehicle("Car","1248","AMC Hornet","Tan","Gas",100,"1977"));
		LOT_LIST.add(new Vehicle("Car","1249","Yugo","Gray","Gas",10,"1985"));
		LOT_LIST.add(new Vehicle("Car","1250","Bugatti Veyron","Black/Red","Gas",2500000,"2016"));
		LOT_LIST.add(new Vehicle("Car","1251","Tesla model-S","Red","Electric",84000,"2016"));
		LOT_LIST.add(new Vehicle("Car","1252","Honda","Blue","Gas",5000,"2002"));
		LOT_LIST.add(new Vehicle("Car","1253","Honda","Silver","Gas",13000,"2015"));
		LOT_LIST.add(new Vehicle("Car","1254","Hyundai","Gold","Gas",13000,"2014"));
		LOT_LIST.add(new Vehicle("Car","1255","Subaru","Blue","Gas",13000,"2014"));
		lotSize = Lot.LOT_LIST.size();
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle type.
	 * @return Set<String> returns a Set of vehicle types
	 */
	public static Set<String> getVehicleTypes() {
		HashMap<String,Integer> optionMap = new HashMap<String,Integer>();
		for (int i = 0; i < lotSize; ++i) {
			optionMap.put(LOT_LIST.get(i).getType(),0);
		}
		return optionMap.keySet();
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle brand.
	 * @return Set<String> returns a Set of vehicle brands
	 */
	public static Set<String> getVehicleBrands() {
		HashMap<String,Integer> optionMap = new HashMap<String,Integer>();
		for (int i = 0; i < lotSize; ++i) {
			optionMap.put(LOT_LIST.get(i).getBrand(),0);
		}
		return optionMap.keySet();
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle color.
	 * @return Set<String> returns a Set of vehicle color
	 */
	public static Set<String> getVehicleColors() {
		HashMap<String,Integer> optionMap = new HashMap<String,Integer>();
		for (int i = 0; i < lotSize; ++i) {
			optionMap.put(LOT_LIST.get(i).getColor(),0);
		}
		return optionMap.keySet();
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle engine type.
	 * @return Set<String> returns a Set of vehicle engine types
	 */
	public static Set<String> getVehicleEngineTypes() {
		HashMap<String,Integer> optionMap = new HashMap<String,Integer>();
		for (int i = 0; i < lotSize; ++i) {
			optionMap.put(LOT_LIST.get(i).getEngineType(),0);
		}
		return optionMap.keySet();
	}
	
	/**
	 * Returns a Set<String> where each string in the set is a current vehicle year.
	 * @return Set<String> returns a Set of vehicle years
	 */
	public static Set<String> getVehicleYears() {
		HashMap<String,Integer> optionMap = new HashMap<String,Integer>();
		for (int i = 0; i < lotSize; ++i) {
			optionMap.put(LOT_LIST.get(i).getYear(),0);
		}
		return optionMap.keySet();
	}
	
	public static ArrayList<Vehicle> getAveragePriceByType() {
		ArrayList<Vehicle> vehiclesAvg = new ArrayList<Vehicle>();
		Set<String> keys = getVehicleTypes();
		for (String key : keys) {
			int sumPrice = 0;
			int numOfVehicles = 0;
			int avgPrice = 0;
			for (int i = 0; i < lotSize; ++i) {
				Vehicle vehicle = Lot.LOT_LIST.get(i);
				if (vehicle.getType().equals(key)) {
					sumPrice += vehicle.getPrice();
					++numOfVehicles;
				}
			}
			if(numOfVehicles > 0) {
				avgPrice = sumPrice / numOfVehicles;
			}
			vehiclesAvg.add(new Vehicle(key,avgPrice));
		}
		return vehiclesAvg;
	}
	
	public static ArrayList<Vehicle> getAveragePriceByBrand() {
		ArrayList<Vehicle> vehiclesAvg = new ArrayList<Vehicle>();
		Set<String> keys = getVehicleBrands();
		for (String key : keys) {
			int sumPrice = 0;
			int numOfVehicles = 0;
			int avgPrice = 0;
			for (int i = 0; i < lotSize; ++i) {
				Vehicle vehicle = Lot.LOT_LIST.get(i);
				if (vehicle.getBrand().equals(key)) {
					sumPrice += vehicle.getPrice();
					++numOfVehicles;
				}
			}
			if(numOfVehicles > 0) {
				avgPrice = sumPrice / numOfVehicles;
			}
			vehiclesAvg.add(new Vehicle(key,avgPrice));
		}
		return vehiclesAvg;
	}
	
	public static ArrayList<Vehicle> getAveragePriceByColor() {
		ArrayList<Vehicle> vehiclesAvg = new ArrayList<Vehicle>();
		Set<String> keys = getVehicleColors();
		for (String key : keys) {
			int sumPrice = 0;
			int numOfVehicles = 0;
			int avgPrice = 0;
			for (int i = 0; i < lotSize; ++i) {
				Vehicle vehicle = Lot.LOT_LIST.get(i);
				if (vehicle.getColor().equals(key)) {
					sumPrice += vehicle.getPrice();
					++numOfVehicles;
				}
			}
			if(numOfVehicles > 0) {
				avgPrice = sumPrice / numOfVehicles;
			}
			vehiclesAvg.add(new Vehicle(key,avgPrice));
		}
		return vehiclesAvg;
	}
	
	public static ArrayList<Vehicle> getAveragePriceByEngineType() {
		ArrayList<Vehicle> vehiclesAvg = new ArrayList<Vehicle>();
		Set<String> keys = getVehicleEngineTypes();
		for (String key : keys) {
			int sumPrice = 0;
			int numOfVehicles = 0;
			int avgPrice = 0;
			for (int i = 0; i < lotSize; ++i) {
				Vehicle vehicle = Lot.LOT_LIST.get(i);
				if (vehicle.getEngineType().equals(key)) {
					sumPrice += vehicle.getPrice();
					++numOfVehicles;
				}
			}
			if(numOfVehicles > 0) {
				avgPrice = sumPrice / numOfVehicles;
			}
			vehiclesAvg.add(new Vehicle(key,avgPrice));
		}
		return vehiclesAvg;
	}
	
	public static ArrayList<Vehicle> getAveragePriceByYear() {
		ArrayList<Vehicle> vehiclesAvg = new ArrayList<Vehicle>();
		Set<String> keys = getVehicleYears();
		for (String key : keys) {
			int sumPrice = 0;
			int numOfVehicles = 0;
			int avgPrice = 0;
			for (int i = 0; i < lotSize; ++i) {
				Vehicle vehicle = Lot.LOT_LIST.get(i);
				if (vehicle.getYear().equals(key)) {
					sumPrice += vehicle.getPrice();
					++numOfVehicles;
				}
			}
			if(numOfVehicles > 0) {
				avgPrice = sumPrice / numOfVehicles;
			}
			vehiclesAvg.add(new Vehicle(key,avgPrice));
		}
		return vehiclesAvg;
	}
	
	public static void main(String args[]) {
		System.out.println("Vehicles " + lotSize);
		for (int i = 0; i < lotSize; ++i) {
			System.out.println("Vehicle " + Lot.LOT_LIST.get(i).getPrice());
		}
		Collections.sort(Lot.LOT_LIST);
		for (int i = 0; i < lotSize; ++i) {
			System.out.println("Vehicle " + Lot.LOT_LIST.get(i).getPrice());
		}
	}
	
}
