package ex04;

import java.util.ArrayList;
import java.util.List;



public class Program {

	public static void main(String[] args) {
		List<Vehicle> vehicles = new ArrayList<>();
		
		vehicles.add(new Car());
		vehicles.add(new Train());
		vehicles.add(new Bicycle());
		
		for(Vehicle vehicle : vehicles) {
			try {
				vehicle.accelerate();
			} catch (IllegalStateException e) {
				System.out.println(e.getMessage());
			}
		}

	}

}
