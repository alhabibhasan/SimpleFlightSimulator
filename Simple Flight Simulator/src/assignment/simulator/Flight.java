package assignment.simulator;

import assignment.gui.GUI;

/**
 * This class handles all behaviour relating to the flight of a given aircraft
 * on a given run-way.
 * 
 * @author k1631313
 *
 */
public class Flight {

	private Plane plane;
	private Runway runway;
	private GUI gui;

	private int timeMoving;
	private boolean reset;

	/**
	 * The values to assign to the fields are passed in via this constructor.
	 * 
	 * @param plane
	 *            The plane which is to fly is passed in here.
	 * @param runway
	 *            The run-way on which the given plane should fly on is passed
	 *            in here.
	 * @param gui
	 *            The GUI to which we should output flight details is passed in
	 *            here.
	 */
	public Flight(Plane plane, Runway runway, GUI gui) {
		this.plane = plane;
		this.runway = runway;
		this.gui = gui;
		this.timeMoving = 0;
	}

	public void reset() {
		this.reset = true;
		// run();
	}

	public void setGUI(GUI gui) {
		this.gui = gui;
	}

	private boolean getReset() {
		return this.reset;
	}

	/**
	 * The run runs the flight. It contains the loop which is used to control
	 * the passage of time.
	 */
	public void run() {

		/**
		 * the YCoord variable is used only for calculations, the value stored
		 * in this variable is the assigned to the y coordinate of the plane
		 * field within this class. the timeSpendAtSpeed variable holds the
		 * amount of time the plane has spend at the speed required for
		 * elevation. Its value is determined within the for loop. the elevation
		 * loop temporarily holds the elevation of the plane before it is stored
		 * in the currentElevation field within the plane object.
		 */

		reset = false;
		int YCoord = 0;
		int timeSpentAtSpeed = 0;
		int elevation = 0;

			for (int time = 0; time <= 10000; time ++) {
				/*
				 * Checking whether the plane is moving or not, if it is then we
				 * are starting a timer to measure for how long the plane has
				 * been moving.
				 */
				if (plane.getCurrentSpeed() > 0) {
					timeMoving++;
				}

				// fix YCoord
				YCoord = plane.getYCoord() + plane.getCurrentSpeed();
				plane.setYCoord(YCoord);

				/*
				 * The below statement checks that the speed of the plane is at
				 * the correct level, if it is at the correct level, the the
				 * time for which it is at the correct level is incremented by
				 * one. if the plane drops below the required speed, the the
				 * timer restarts and the plane must spend 5 further seconds (or
				 * any other amount of time) at the required speed in order to
				 * start elevating.
				 */
				if (plane.getCurrentSpeed() == 10) {
					timeSpentAtSpeed++;
				} else if (plane.getCurrentSpeed() < 10) {
					timeSpentAtSpeed--;
					if (timeSpentAtSpeed < 0)
						timeSpentAtSpeed = 0;
				}

				/*
				 * If we have spent the required time at the speed needed for
				 * elevation, the elevation of the plane will increment by 1.
				 */
				if (timeSpentAtSpeed >= plane.getTimeForElevation()) {
					if (plane.getCurrentSpeed() == 10) {
						elevation++;
						plane.setCurrentElevation(elevation);
					}
				}

				/*
				 * The code block below watches for the scenario that the plane
				 * is elevating or elevated, but the user drops the speed. In
				 * such case, the elevation decreases by one for as long as the
				 * speed is belong the required speed for elevation
				 */

				if (plane.getCurrentSpeed() < plane.getElevationSpeed() && plane.getCurrentElevation() >= 1) {
					elevation--;
					plane.setCurrentElevation(elevation);
					outputToGui(gui.getDisplayText() + System.lineSeparator() + "## Maintain Speed at "
							+ plane.getElevationSpeed() + " ##" + System.lineSeparator() + System.lineSeparator());
				}

				// outputting the planes information.
				outputToGui(gui.getDisplayText() + "Seconds: " + time + System.lineSeparator() + plane.toString()
						+ System.lineSeparator());

				/*
				 * The code block below makes the checks to see if the plane is
				 * at the required elevation - outputting the correct messages
				 * etc. if the planes current status meets the planes
				 * requirements.
				 */
				if (plane.getCurrentElevation() >= plane.getElevationNeeded() + 1
						&& plane.getYCoord() <= runway.getLength() && plane.getXCoord() == (runway.getWidth() / 2)) {
					outputToGui(gui.getDisplayText() + System.lineSeparator() + "Plane in air");
					break;
				} else if (plane.getYCoord() >= runway.getLength()) {
					outputToGui(gui.getDisplayText() + System.lineSeparator() + "Take off failed.");
					break;
				} else if (plane.getCurrentElevation() >= plane.getElevationNeeded() + 1
						&& plane.getYCoord() <= runway.getLength() && plane.getXCoord() != (runway.getWidth() / 2)) {
					outputToGui(gui.getDisplayText() + System.lineSeparator() + "Take off failed.");
					break;
				}
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}


		System.out.println("Exited");	
		}

	

	/**
	 * The following method is used to allow an output to the text area with
	 * error handling.
	 * 
	 * @param text
	 *            The text to pass into the text area.
	 */
	public void outputToGui(String text) {
		try {
			gui.setDisplayText(text);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			System.out.println("GUI set to null");
		}

	}

	/**
	 * returns the variable which holds the amount of time for which the plane
	 * has been moving and not stationary.
	 * 
	 * @return The value stored in the timeMoving field is returned.
	 */
	public int getTimeMoving() {
		return timeMoving;
	}

}
