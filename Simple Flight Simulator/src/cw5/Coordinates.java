package cw5;
/**
 * This method has been imported from CW4 to model the location of a plane.
 * @author Martin Chapman
 *
 */
public class Coordinates {

	private int x;
	private int y;

	/**
	 * This constructor is used to assign values to the fields at instantiation.
	 * @param x The x value to assign to the x coordinate value.
	 * @param y The y value to assign to the y coordinate value.
	 */
	public Coordinates(int x, int y) {

		this.x = x;
		this.y = y;

	}

	/**
	 * Returns the x coordinate.
	 * @return The x value stored in the x field
	 */
	public int getX() {

		return x;

	}

	/**
	 * Returns the y coordinate.
	 * @return The y value stored in the y field
	 */
	public int getY() {

		return y;

	}

	/**
	 * Used to assign a new value to the x coordinate field.
	 * @param x The new value to be used as the x coordinate.
	 */
	public void setX(int x) {

		this.x = x;

	}

	/**
	 * Used to assign a new value to the y coordinate field.
	 * @param y The new value to be used as the y coordinate.
	 */
	public void setY(int y) {

		this.y = y;

	}

}
