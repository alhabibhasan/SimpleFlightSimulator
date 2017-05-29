package assignment.simulator;

import cw5.Coordinates;
/**
 * The plane class is used to model a plane. It contains fields which holds the values for the planes speed location etc.
 * @author ASUS
 *
 */
public class Plane {

	private int maxSpeed;
	private int elevationSpeed;
	private int timeForElevation;
	private int elevationNeeded;
	private int currentSpeed;
	private int currentElevation;
	private Coordinates location;

	public Plane(int maxSpeed, int elevationSpeed, int timeForElevation,
			int elevationNeeded, int currentSpeed, int currentElevation) {
		this.maxSpeed = maxSpeed;
		this.elevationSpeed = elevationSpeed;
		this.timeForElevation = timeForElevation;
		this.elevationNeeded = elevationNeeded;
		this.currentSpeed = currentSpeed;
		this.currentElevation = currentElevation;

		this.location = new Coordinates(5, 0);
	}

	public int getXCoord() {
		return this.location.getX();
	}

	public int getYCoord() {
		return this.location.getY();
	}

	public void setXCoord(int x) {
		this.location.setX(x);
	}

	public void setYCoord(int y) {
		this.location.setY(y);
	}

	public int getCurrentSpeed() {
		return currentSpeed;
	}

	public void setCurrentSpeed(int currentSpeed) {
		this.currentSpeed = currentSpeed;
	}

	public int getCurrentElevation() {
		return currentElevation;
	}

	public void setCurrentElevation(int currentElevation) {
		this.currentElevation = currentElevation;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public int getElevationSpeed() {
		return elevationSpeed;
	}

	public int getTimeForElevation() {
		return timeForElevation;
	}

	public int getElevationNeeded() {
		return elevationNeeded;
	}

	@Override
	public String toString() {
		return "X: " + this.getXCoord() + " Y: " + this.getYCoord() + " Speed:"
				+ this.getCurrentSpeed() + " Elevation: "
				+ this.getCurrentElevation();
	}

}
