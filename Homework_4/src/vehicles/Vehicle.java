package vehicles;

// Abstract class representing a vehicle with common properties and methods
public abstract class Vehicle {
	// Protected fields to store vehicle attributes
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
  
    // Constructor to initialize a Vehicle object with given parameters
    public Vehicle(String brand, String make, long modelYear, double price, VehicleColor color, FuelType fuelType,
			double mileage, double mass, int cylinders, double gasTankCapacity, StartMechanism startType) {
    	super();
		this.brand = brand;
		this.make = make;
		this.modelYear = modelYear;
		this.price = price;
		this.color = color;
		this.fuelType = fuelType;
		this.mileage = mileage;
		this.mass = mass;
		this.cylinders = cylinders;
		this.gasTankCapacity = gasTankCapacity;
		this.startType = startType;
	}
    
    // copy constructor
    public Vehicle(Vehicle v) {
    	this.brand = v.getBrand();
		this.make = v.getMake();
		this.modelYear = v.getModelYear();
		this.price = v.getPrice();
		this.color = v.getColor();
		this.fuelType = v.getFuelType();
		this.mileage = v.getMileage();
		this.mass = v.getMass();
		this.cylinders = v.getCylinders();
		this.gasTankCapacity = v.getGasTankCapacity();
		this.startType = v.getStartType();
    }
    
    // Abstract methods to be implemented by concrete subclasses
    public abstract double calculateMaintenanceCost(double distance); // calculates maintenance cost for a specific vehicle
    public abstract double calculateFuelEfficiency(double distance, double fuelPrice); //calculates the engine efficiency
    public abstract void startEngine(); // prints how the vehicle starts
    public abstract String toString(); // prints information of vehicle.
    
    // Static constant for the current year
    public static final int currentYear = 2024;
  
    // Getters and setters for all fields
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public long getModelYear() {
		return modelYear;
	}
	public void setModelYear(long modelYear) {
		this.modelYear = modelYear;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public VehicleColor getColor() {
		return color;
	}
	public void setColor(VehicleColor color) {
		this.color = color;
	}
	public FuelType getFuelType() {
		return fuelType;
	}
	public void setFuelType(FuelType fuelType) {
		this.fuelType = fuelType;
	}
	public double getMileage() {
		return mileage;
	}
	public void setMileage(double mileage) {
		this.mileage = mileage;
	}
	public double getMass() {
		return mass;
	}
	public void setMass(double mass) {
		this.mass = mass;
	}	
	public int getCylinders() {
		return cylinders;
	}
	public void setCylinders(int cylinders) {
		this.cylinders = cylinders;
	}
	public double getGasTankCapacity() {
		return gasTankCapacity;
	}
	public void setGasTankCapacity(double gasTankCapacity) {
		this.gasTankCapacity = gasTankCapacity;
	}
	public StartMechanism getStartType() {
		return startType;
	}
	public void setStartType(StartMechanism startType) {
		this.startType = startType;
	}
	
	// Overridden equals method to compare two vehicle objects based on their properties
	@Override
	public boolean equals(Object obj) {
		Vehicle v = ((Vehicle)obj);
		if(this.brand.equals(v.getBrand()) &&
		this.make.equals(v.getMake()) &&
		this.modelYear == v.getModelYear() &&
		this.price == v.getPrice() &&
		this.color == v.getColor() &&
		this.fuelType == v.getFuelType() &&
		this.mileage == v.getMileage() &&
		this.mass == v.getMass() &&
		this.cylinders == v.getCylinders() &&
		this.gasTankCapacity == v.getGasTankCapacity() &&
		this.startType == v.getStartType()) {
			return true;
		}
		return false;
	}
}

