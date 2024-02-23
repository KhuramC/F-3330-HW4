package vehicleManagement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
	private void displayVehicleClassInformation(Class<?> vehicleType) {
		String vehicleTypeName = vehicleType.getSimpleName().toLowerCase(); // Get the type name for messages
		boolean foundVehicle = false;
		for (Vehicle vehicle : vehicleStock) {
			if (isVehicleType(vehicle, vehicleType)) {
				foundVehicle = true;
				System.out.println(vehicle +
						"Fuel Efficiency: " + vehicle.calculateFuelEfficiency(VehicleManager.distance, VehicleManager.fuelPrice) +
						"Maintenance Cost: " + vehicle.calculateMaintenanceCost(VehicleManager.distance));
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
		displayVehicleClassInformation(Car.class);
	}
	
	public void displayAllTruckInformation() {
		displayVehicleClassInformation(Truck.class);
	}
	
	public void displayAllSUVInformation() {
		displayVehicleClassInformation(SUV.class);
	}
	
	public void displayAllMotorBikeInformation() {
		displayVehicleClassInformation(MotorBike.class);
	}
	
	public void displayVehicleInformation(Vehicle v) {
		
	}
	
	public void displayAllVehicleInformation() {
		displayVehicleClassInformation(Vehicle.class);
	}
	
	public boolean removeVehicle(Vehicle vehicle) {
		return true;
	}
	
	public boolean addVehicle(Vehicle vehicle) {
		return true;
	}
	
	public boolean saveVehicleList() {
		return true;
	}
	
	private boolean isVehicleType(Vehicle v, Class clazz) {
		return true;
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
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		return null;
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
	
	public ArrayList<Vehicle> getVehicleWithHighestFuelEfficiency(double distance, double fuelPrice){
		return null;
	}
	
	public ArrayList<Vehicle> getVehicleWithLowestFuelEfficiency(double distance, double fuelPrice){
		return null;
	}
	
	public double getAverageFuelEfficiencyOfSUVs(double distance, double fuelPrice) {
		if (vehicles.isEmpty()) {
			return -1;
		}
		double totalFuelEfficiency = 0.0;
		int suvCount = 0;
		
		for (Vehicle vehicle : vehicles) {
			if ()
		}
		
		double average = totalFuelEfficiency/suvCount; 
		return average;
	}
	
	
}
