package vehicleManagement;
import java.util.ArrayList;

import vehicles.*;

public class VehicleManager {

	
	private static VehicleManager instance = null;
	
	private static final String vehicleFilePath = "files/vehicleList.csv";
	
	private ArrayList<Vehicle> vehicles;
	
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
	
	public boolean initializeStock() {
		return true;
		
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
