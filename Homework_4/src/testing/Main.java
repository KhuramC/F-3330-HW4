package testing;
import vehicleManagement.*;
import vehicles.*;
public class Main {

	public static void main(String[] args) {
		 // Instantiate vehicleManager, perform operations based on the requirements.
		 VehicleManager vManager = VehicleManager.getInstance();
		 
		 // Read vehicle data from the vehcileList.csv file and initialize objects.
		 if(vManager.initializeStock()) {
			 System.out.println("Successfully initialized stock.");
		 }
		 // Display all vehicle information(different versions)
		  vManager.displayAllVehicleInformation();
		 
		 //vManager.displayAllCarInformation();
		 //vManager.displayAllMotorBikeInformation();
		 //vManager.displayAllSUVInformation();
		 //vManager.displayAllTruckInformation();
		 
		 //Adding Vehicles//
		 Car v = new Car("Hyundai", "Elantra", 2010, 4000, VehicleColor.BLACK, FuelType.GASOLINE,
				 210000, 0.29, 8, 14, StartMechanism.KEYSTART);
		 vManager.displayVehicleInformation(v);
		 
		 vManager.addVehicle(v);
		 vManager.displayVehicleInformation(v);
		 
		 
		 
		 //Miscellaneous//
		 Class c = Truck.class;
		 System.out.println("There are " + vManager.getNumberOfVehiclesByType(c) + " vehicles of Type: " + c.getSimpleName());
		 vManager.getNumberOfVehiclesByType(Car.class);
		 
		

	}

}
