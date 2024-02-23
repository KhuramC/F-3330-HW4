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
			
			ArrayList<Vehicle> p = new ArrayList<Vehicle>();

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
				
				type = 
						//,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType
				String type = data[0];
				String title = parts[1];
				double price = Double.parseDouble(parts[2]);
				int year = Integer.parseInt(parts[3]);
				
				switch(type) { //creates product based on their type and adds to ArrayList//
				case "CD":
					CDRecordProduct cd = new CDRecordProduct(title,price,year,genre);
					p.add(cd);
					break;
				case "Vinyl":
					VinylRecordProduct vinyl = new VinylRecordProduct(title,price,year,genre);
					p.add(vinyl);
					break;
				case "Tape":
					TapeRecordProduct tape = new TapeRecordProduct(title,price,year,genre);
					p.add(tape);
					break;
				}
			}
			if(p.size() == 0) { //Check for if something went wrong
				System.out.println("File is either empty or has been formatted incorrectly.");
				System.out.println("Make sure the file is in Type,Model,Make,ModelYear,Price,Color,FuelType,Mileage,Mass,Cylinders,GasTankCapacity,StartType format");
				sc.close();
				input.close();
				return false;
			}
			
			this.products = p;
			sc.close();
			input.close();
			return true;
		}
		catch(FileNotFoundException e) { //Excepts if it doesn't work
			System.out.println("File not found: " + e.getMessage());
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
