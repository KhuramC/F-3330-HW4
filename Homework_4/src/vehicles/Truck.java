package vehicles;

public class Truck extends Vehicle {
	// Constructor to initialize a Truck object with given parameters
	public Truck(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			 double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
		super( brand,  make,  modelYear,  price, color,  fuelType,
				  mileage,  mass,  cylinders,  gasTankCapacity,  startType);
	}
	
	//Copy Constructor//
	public Truck(Truck truck) {
		super(truck.getBrand(), truck.getMake(), truck.getModelYear(), truck.getPrice(), truck.getColor(), truck.getFuelType(),
				truck.getMileage(), truck.getMass(), truck.getCylinders(), truck.getGasTankCapacity(), truck.getStartType() );
	}
	/* Abstract functions that calculates maintenance cost and fuel efficiency */ 
	public double calculateMaintenanceCost(double distance) {
		double cost = distance * mass * (Vehicle.currentYear-modelYear) * cylinders * 0.002; // given equation
		return cost;
	}
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.1; // given equation
		return fuelEfficiency;
	}
	public void startEngine() {
		System.out.println("The car has been started by " + startType);
	}
	// toString specific to subclass.
	public String toString() {
		return "The type of this vehicle is Truck and has brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price + ", color="
				+ color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders="
				+ cylinders + ", gasTankCapacity=" + gasTankCapacity + ", and startType=" + startType;
	} 

}
