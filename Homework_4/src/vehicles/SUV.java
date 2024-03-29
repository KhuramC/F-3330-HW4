package vehicles;

public class SUV extends Vehicle {
	// Constructor to initialize a SUV object with given parameters
	public SUV(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
		 double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
	super( brand,  make,  modelYear,  price, color,  fuelType,
			  mileage,  mass,  cylinders,  gasTankCapacity,  startType);

	}
	
	//Copy Constructor//
	public SUV(SUV suv) {
		super(suv.getBrand(), suv.getMake(), suv.getModelYear(), suv.getPrice(), suv.getColor(), suv.getFuelType(),
				suv.getMileage(), suv.getMass(), suv.getCylinders(), suv.getGasTankCapacity(), suv.getStartType() );
	}
	
	/* Abstract functions that calculates maintenance cost and fuel efficiency */
	public double calculateMaintenanceCost(double distance) {
		double cost = distance * mass * (Vehicle.currentYear-modelYear) * cylinders * 0.001; // given equation
		return cost;
	}
	public double calculateFuelEfficiency(double distance, double fuelPrice) {
		double fuelEfficiency = cylinders * gasTankCapacity * fuelPrice / distance * 0.05; // given equation
		return fuelEfficiency;
	}
	public void startEngine() {
		System.out.println("The car has been started by " + startType);
	}
	// toString specific to subclass.
	public String toString() {
		return "The type of this vehicle is SUV and has brand=" + brand + ", make=" + make + ", modelYear=" + modelYear + ", price=" + price + ", color="
				+ color + ", fuelType=" + fuelType + ", mileage=" + mileage + ", mass=" + mass + ", cylinders="
				+ cylinders + ", gasTankCapacity=" + gasTankCapacity + ", and startType=" + startType;
	}
}
