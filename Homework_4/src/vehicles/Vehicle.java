package vehicles;

public abstract class Vehicle {
	protected String brand;
	protected String make;
    protected long modelYear;
    protected double price;
    protected VehicleColor color;
    protected FuelType fuelType;
    protected double mileage;
    protected double mass;
    protected int cylinders;
    protected double gasTankCapacity;
    protected StartMechanism startType;
    
    public abstract double calculateMaintenanceCost(double distance); // calculates maintenance cost for a specific vehicle
    public abstract double calculateFuelEfficiency(double distance, double fuelPrice); //calculates the engine efficiency
    public abstract void startEngine(); // prints how the vehicle starts
    public abstract String toString(); // prints information of vehicle.
    
}
