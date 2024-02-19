package vehicleManagement;
import java.util.ArrayList;

import vehicles.*;

public class VehicleManager {

	
	public boolean readFromFile(String fileName) {
		return true;
	}
	
	public void VehicleManager(String fileName) {
		
	}
	
	public static VehicleManager getInstance() {
		return null;
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
		return -1;
	}
	
	
}
