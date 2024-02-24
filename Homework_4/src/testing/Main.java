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
		 // Display all vehicle information.
		 // TODO
		 // Display all car information.
		 // TODO
		 // Display all motorbike information.
		 // TODO

		
		

	}

}
