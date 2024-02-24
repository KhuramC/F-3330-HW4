package vehicleManagement;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Random;

import vehicles.*;

public class VehicleManager {
	
	private final static double distance = 300;

	private final static double fuelPrice = 3.25;
	
	private static VehicleManager instance = null;
	
	private static final String vehicleFilePath = "files/vehicleList.csv";
	
	private ArrayList<Vehicle> vehicleStock;
	
	/**
	 * Private constructor for single instance to be created.
	 */
	private VehicleManager() {
		
	}
	
	/**
	 * Creates a single instance of VehicleManager if not previously created.
	 * @return instance of VehicleManager.
	 */
	public static VehicleManager getInstance() {
		if(instance == null) {
			instance = new VehicleManager();
		}
		return instance;
	}
	
	/*
	 * Reads the data from a CSV file located at vehicleFilePath. Initializes each of the Vehicle
	 * objects.
	 * Return true if the read file and initialization are successful.
	 * Return false if cannot read/find the file.
	 */
	
	public boolean initializeStock() {
	    try (FileInputStream input = new FileInputStream(vehicleFilePath);
	         Scanner sc = new Scanner(input)) {

	        ArrayList<Vehicle> vehicleList = new ArrayList<>();

	        // Skip first line (header)
	        sc.nextLine();

	        while (sc.hasNextLine()) {
	            String line = sc.nextLine();
	            String[] data = line.split(",");
	            if (data.length != 12) {
	                throw new IllegalArgumentException("Invalid line format: " + line);
	            }

	            // Parse data using a helper method
	            Vehicle vehicle = parseVehicleData(data);
	            vehicleList.add(vehicle);
	        }

	        this.vehicleStock = vehicleList;
	        return true;

	    } catch (IOException e) {
	        System.out.println("Error reading file: " + e.getMessage());
	        return false;
	    } catch (IllegalArgumentException e) {
	        System.out.println(e.getMessage());
	        return false;
	    }
	}

	private Vehicle parseVehicleData(String[] data) {
		// Extract fields based on ordering of header
		String type = data[0];
		String model = data[1];
		String make = data[2];
		long modelYear = Long.parseLong(data[3]);
		double price = Double.parseDouble(data[4]);
		VehicleColor color = VehicleColor.valueOf(data[5]);
		FuelType fuelType = FuelType.valueOf(data[6]);
		double mileage = Double.parseDouble(data[7]);
		double mass = Double.parseDouble(data[8]);
		int cylinders = Integer.parseInt(data[9]);
		double gasTankCapacity = Double.parseDouble(data[10]);
		StartMechanism startMechanism = StartMechanism.valueOf(data[11]);

	    switch (type) {
	        case "Car":
				return new Car(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
			case "Truck":
				return new Truck(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
			case "Motorbike":
				return new MotorBike(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
			case "SUV":
				return new SUV(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
	        default:
	            throw new IllegalArgumentException("Invalid vehicle type: " + type);
	    }
	}
	
	/*
	 * Helper method for displayAll(Class)Information methods.
	 * Prints all elements from vehicleStock of a given class.
	 */
	private void displayAllVehicleClassInformation(Class<?> vehicleType) {
		String vehicleTypeName = vehicleType.getSimpleName().toLowerCase(); // Get the type name for messages
		boolean foundVehicle = false;
		for (Vehicle vehicle : vehicleStock) {
			if (isVehicleType(vehicle, vehicleType)) {
				foundVehicle = true;
				System.out.println(vehicle +
						"Fuel Efficiency: " + vehicle.calculateFuelEfficiency(VehicleManager.distance, VehicleManager.fuelPrice) +
						"Maintenance Cost: " + vehicle.calculateMaintenanceCost(VehicleManager.distance) + 
						"Start: " + vehicle.getStartType().toString());
			}
		}
		if (!foundVehicle) {
			System.out.println(vehicleTypeName + " not found in vehicleList");
		}
	}
	
	
	/*
	 * This will display the information, including maintenance cost, fuel efficiency, and how the vehicle starts, of all the cars present in the vehicleList
	 * Prints an error message if there is no car found.
	 */
	public void displayAllCarInformation() {
		displayAllVehicleClassInformation(Car.class);
	}
	
	public void displayAllTruckInformation() {
		displayAllVehicleClassInformation(Truck.class);
	}
	
	public void displayAllSUVInformation() {
		displayAllVehicleClassInformation(SUV.class);
	}
	
	public void displayAllMotorBikeInformation() {
		displayAllVehicleClassInformation(MotorBike.class);
	}
	
	/**
	 * Displays Vehicles's Fuel Efficiency, maintenance cost, and how it starts.
	 * @param v Vehicle possibly being managed
	 */
	public void displayVehicleInformation(Vehicle v) {
		if(vehicleStock.contains(v)) {
			System.out.println(v +
					"Fuel Efficiency: " + v.calculateFuelEfficiency(VehicleManager.distance, VehicleManager.fuelPrice) +
					"Maintenance Cost: " + v.calculateMaintenanceCost(VehicleManager.distance) + 
					"Start: " + v.getStartType().toString());
		}else {
			System.out.println("The vehicle " + v + " was not found and is presumed to not be managed by us.");
		}
		
		
	}
	
	public void displayAllVehicleInformation() {
		displayAllVehicleClassInformation(Vehicle.class);
	}
	
	
	/**
	 * Attempts to removed given vehicle. Returns false if unsuccessful.
	 * @param vehicle to be removed
	 * @return boolean of whether successful
	 */
	public boolean removeVehicle(Vehicle vehicle) {
		Iterator<Vehicle> it = vehicleStock.iterator();
		while(it.hasNext()) {
			Vehicle currentv = it.next();
			if(currentv.equals(vehicle)) {
				it.remove();
				return true;
			}
			
		}
		return false;
	}
	
	/*
	 * Adds the given vehicle into the vehicleList. 
	 * Returns true if the addition is successful, false otherwise.
	 */
	public boolean addVehicle(Vehicle vehicle) {
		if (vehicle instanceof Vehicle) {
				vehicleStock.add(vehicle);
				return true;
			
		}
		return false;
	}
	
	
	/**
	 * Saves VehicleStock into csv file based on file path with a given order(shown in header line). 
	 * Returns false if an exception occurs.
	 * @return boolean for if successful.
	 */
	public boolean saveVehicleList() {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(vehicleFilePath));
			
			//header line//
			bw.write("Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType");
			bw.newLine();
			
			for(Vehicle v: vehicleStock) {
				String type = "";	
				
				if(v instanceof Car) {
					type = Car.class.getSimpleName();
				}
				if(v instanceof SUV) {
					type = SUV.class.getSimpleName();
				}
				if(v instanceof MotorBike) {
					type = MotorBike.class.getSimpleName();
				}
				if(v instanceof Truck) {
					type = Truck.class.getSimpleName();
				}
				
				String model = v.getBrand();
				String make = v.getMake();
				long modelYear = v.getModelYear();
				double price = v.getPrice();
				FuelType ftype = v.getFuelType();
				double mileage = v.getMileage();
				double mass = v.getMass();
				int cylinders = v.getCylinders();
				double gasCapacity = v.getGasTankCapacity();
				StartMechanism stype = v.getStartType();
				bw.write(type + "," + model + "," + make + "," + modelYear + "," + price + "," +
				ftype + "," + mileage + "," + mass + "," + cylinders + "," + gasCapacity + "," + stype);
				bw.newLine();
			}
			bw.close();
			
			return true;
		}catch(IOException e) {
			e.printStackTrace();
	        // False if failed
	        return false;
		}
		
		
	}
	
	private boolean isVehicleType(Vehicle v, Class clazz) {
		return clazz.isInstance(v);
	}
	
	/*
	 * Returns the number of objects in the vehicle list based on the object vehicle type
	 */
	public int getNumberOfVehiclesByType(Class clazz) {
		int count = 0;
		for (Vehicle vehicle : vehicleStock) {
			if (isVehicleType(vehicle, clazz)) {
				count++;
			}
		}
		return count;
	}
	
	
	/**
	 * Returns a random vehicle with the highest maintenance cost. Returns null if there is none.
	 * @param distance distance used to calculate maintenance cost
	 * @return Vehicle to be returned
	 */
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		if(vehicleStock.isEmpty()) {
			return null;
		}
		ArrayList<Vehicle> highCostVehicles = new ArrayList<Vehicle>();
		double maxCost = 0;
		
		for(Vehicle v : vehicleStock) {
			Double currentCost = v.calculateMaintenanceCost(distance);
			if(currentCost > maxCost) {
				maxCost = currentCost;
				highCostVehicles.clear();
				highCostVehicles.add(v);
				continue;
			}
			if(currentCost == maxCost) {
				highCostVehicles.add(v);
			}
		}

		return highCostVehicles.get(new Random().nextInt(0, highCostVehicles.size()-1));	

		
		
	}
	
	/*
	 *  Calculate the maintenance cost for each vehicle in the vehicle list and return a random
	 *  vehicle with the lowest maintenance cost.
	 */
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
		ArrayList<Vehicle> lowestCostVehicles = new ArrayList<>();
		double minCost = Double.MAX_VALUE;
		
		for (Vehicle vehicle : vehicleStock) {
			double cost = vehicle.calculateMaintenanceCost(distance);
			if (cost < minCost) {
				minCost = cost;
				lowestCostVehicles.clear();
				lowestCostVehicles.add(vehicle);
			} else if (cost == minCost) {
				lowestCostVehicles.add(vehicle);
			}
		}
		
		// return null if empty return random vehicle if not.
		return lowestCostVehicles.isEmpty() ? null : lowestCostVehicles.get(new Random().nextInt(lowestCostVehicles.size()));
	}
	
	/*
	 * Gets list of the highest fuel efficiency per vehicle using the given distances and fuel prices.
	 * returns the list of vehicles with highest fuel efficiency.
	 */
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
		double maxFuelEfficiency = Double.MIN_VALUE;
	    ArrayList<Vehicle> maxEfficiencyVehicles = new ArrayList<>();
	    // Go through all vehicles
	    for (Vehicle vehicle : vehicleStock) {
	        // Calculations for fuel efficiency
	    	double efficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
	        if (efficiency > maxFuelEfficiency) {
	            maxFuelEfficiency = efficiency; // Update fuel efficiency
	            maxEfficiencyVehicles.clear(); // Clear
	            maxEfficiencyVehicles.add(vehicle);
	        } else if (efficiency == maxFuelEfficiency) {
	        	// if efficiency is the same as the max, add the vehicle
	            maxEfficiencyVehicles.add(vehicle);
	        }
	    }
	    return maxEfficiencyVehicles;

	}
	
	/*
	 * Gets list of the lowest fuel efficiency per vehicle using the given distances and fuel prices.
	 * Using same comments as before. Same code just slightly different for the low.
	 * returns the list of vehicles with lowest fuel efficiency.
	 */
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
		double minFuelEfficiency = Double.MAX_VALUE;
	    ArrayList<Vehicle> minEfficiencyVehicles = new ArrayList<>();
	 // Go through all vehicles
	    for (Vehicle vehicle : vehicleStock) {
	    	// Calculations for fuel efficiency
	        double efficiency = vehicle.calculateFuelEfficiency(distance, fuelPrice);
	        if (efficiency < minFuelEfficiency) {
	            minFuelEfficiency = efficiency; // Update fuel efficiency
	            minEfficiencyVehicles.clear(); // Clear
	            minEfficiencyVehicles.add(vehicle);
	        } else if (efficiency == minFuelEfficiency) {
	            // if efficiency is the same as the min, add the vehicle
	        	minEfficiencyVehicles.add(vehicle);
	        }
	    }

	    return minEfficiencyVehicles;
	}
	
	// Calculate the mean fuel efficiency for SUVs. If there are no SUVs, returns -1.0
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		if (vehicleStock.isEmpty()) {
			return -1.0;
		}
		
		double totalFuelEfficiency = 0.0;
		int suvCount = 0;
		for (Vehicle vehicle : vehicleStock) {
			if (isVehicleType(vehicle, SUV.class)) {
				totalFuelEfficiency += vehicle.calculateFuelEfficiency(distance, fuelPrice);
				suvCount++;
			}
		}
		
		if (suvCount == 0) {
			return -1.0;
		}
		
		return totalFuelEfficiency / suvCount;
	}
	
	
}
