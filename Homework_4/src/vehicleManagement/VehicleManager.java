package vehicleManagement;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import vehicles.*;

public class VehicleManager {

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
		
		try { //Tries to read into file//
			FileInputStream input = new FileInputStream(vehicleFilePath);
			Scanner sc = new Scanner(input);
			
			ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

			// Skip first line (header)
			sc.nextLine();
			
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				String[] data = line.split(","); //Split by comma
				if(data.length != 12) { //Faulty line
					System.out.println("An invalid line has been found. Please check to see if the file has been formatted correctly.");
					sc.close();
					input.close();
					return false;
				}

				//based on ordering of header
				
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
						
						
				//,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType

				switch(type) { //creates product based on their type and adds to ArrayList
				case "Car":
					Car car = new Car(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
					vehicleList.add(car);
					break;
				case "Truck":
					Truck truck = new Truck(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
					vehicleList.add(truck);
					break;
				case "Motorbike":
					MotorBike motorbike = new MotorBike(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
					vehicleList.add(motorbike);
					break;
				case "SUV":
					SUV suv = new SUV(model,make,modelYear,price,color,fuelType,mileage,mass,cylinders,gasTankCapacity,startMechanism);
					vehicleList.add(suv);
					break;
				}
				
				
				
				
			}
			
			// This should be unnecessary.
//			if(vehicleList.size() == 0) { //Check for if something went wrong
//				System.out.println("File is either empty or has been formatted incorrectly.");
//				System.out.println("Make sure the file is in Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType format");
//				sc.close();
//				input.close();
//				return false;
//			}
			
			this.vehicleStock = vehicleList;
			sc.close();
			input.close();
			return true;
		}
		catch(Exception e) { //Excepts if it doesn't work
			e.printStackTrace();
			System.out.println("Error reading file. Make sure it is formatted correctly.");
			return false;
		}
	}

	

	
	
	public void displayAllCarInformation() {
		
	}
	
	public void displayAllTruckInformation() {
		
	}
	
	public void displayAllSUVInformation() {
		
	}
	
	public void displayAllMotorBikeInformation() {
		
	}
	
	public void displayVehicleInformation(Vehicle v) {
		
	}
	
	public void displayAllVehicleInformation() {
		
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
	
	public int getNumberOfVehichlesByType(Class clazz) {
		return -1;
	}
	
	public Vehicle getVehicleWithHighestMaintenanceCost(double distance) {
		return null;
	}
	
	public Vehicle getVehicleWithLowestMaintenanceCost(double distance) {
		return null;
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
