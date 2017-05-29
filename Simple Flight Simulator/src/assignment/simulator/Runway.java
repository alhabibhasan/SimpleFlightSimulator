package assignment.simulator;
/**
 * This class is used to model a run-way - it contains fields which hold the size of the run-way in terms of length and width.
 * @author ASUS
 *
 */
public class Runway {
	private int width;
	private int length;

	public Runway(int width, int length) {
		this.width = width;
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
