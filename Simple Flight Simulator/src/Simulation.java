

import assignment.gui.GUI;
import assignment.simulator.Flight;
import assignment.simulator.Plane;
import assignment.simulator.Runway;
/**
 * This class is the driver class of the program, all objects are created within this class.
 * @author ASUS
 *
 */
public class Simulation {

	/**
	 * reset button doesnt work.
	 * @param args
	 */
	public static void main(String[] args) {
		GUI gui = new GUI();
		
		//public Plane(int maxSpeed, int elevationSpeed, int timeAtElevation,int elevationNeeded, int currentSpeed, int currentElevation)
		Plane plane = new Plane(10,10,5,5,0,0);
		
		Runway runway = new Runway(10, 1000);
		Flight flight = new Flight(plane, runway, gui);
		
		gui.makeGUI(plane, runway, flight);
		
		flight.run();
		
		
		
		
	}
}
