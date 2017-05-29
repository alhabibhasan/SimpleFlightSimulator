package assignment.gui;

import java.awt.BorderLayout;

import assignment.simulator.*;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

/**
 * This class is used to create the GUI and to create the event handlers for the
 * GUI components such as the sliders and and any buttons (the reset button)
 * 
 * @author k1631313
 *
 */

public class GUI {

	private JFrame frame;
	private JSlider sliderVert, sliderHori;
	private JTextArea output;
	private JScrollPane outputScroll;
	private JLabel throttle;

	public void makeGUI(Plane plane, Runway runway, Flight flight) {
		throttle = new JLabel("Throttle Position: 0        Steering Position: 5" );
		frame = new JFrame();
		frame.setLayout(new BorderLayout());

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel north = new JPanel();
		JPanel center = new JPanel();
		JPanel south = new JPanel();

		north.setLayout(new BorderLayout());
		center.setLayout(new BorderLayout());
		south.setLayout(new BorderLayout());

		Font font = new Font("", 0, 16); // setting the font size

		output = new JTextArea(20, 28);
		outputScroll = new JScrollPane(output);

		output.setEditable(false);
		outputScroll.setPreferredSize(new Dimension(28, 400));
		outputScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		DefaultCaret caret = (DefaultCaret) output.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		output.setFont(font);

		setSliders(plane, runway, flight);

		JButton reset = new JButton("Reset");
		reset.addActionListener(e -> {
			// first reset the planes systems.
			plane.setXCoord(runway.getWidth() / 2);
			plane.setYCoord(0);
			plane.setCurrentElevation(0);
			plane.setCurrentSpeed(0);

			// next reset the GUI components
			sliderVert.setValue(0);
			sliderHori.setValue(5);
			output.setText("");

			// recall the take off method

		});

		frame.getContentPane().add(north, BorderLayout.NORTH);
		frame.getContentPane().add(center, BorderLayout.CENTER);
		frame.getContentPane().add(south, BorderLayout.SOUTH);

		north.add(outputScroll, BorderLayout.CENTER);

		
		center.add(throttle, BorderLayout.NORTH);
		center.add(sliderHori, BorderLayout.CENTER);
		south.add(sliderVert, BorderLayout.CENTER);
		south.add(reset, BorderLayout.SOUTH);

		frame.setSize(new Dimension(400, 820));
		frame.setResizable(false);
		frame.setVisible(true);
	}

	/**
	 * 
	 */
	private void setSliders(Plane plane, Runway runway, Flight flight) {
		sliderHori = new JSlider();
		sliderVert = new JSlider();
		sliderVert.setOrientation(SwingConstants.VERTICAL);
		sliderVert.setPreferredSize(new Dimension(30, 300));
		sliderVert.setBorder(new EmptyBorder(10, 10, 10, 10));

		sliderVert.setMaximum(plane.getMaxSpeed()); // set the max value of the
													// scroller to the max speed

		sliderHori.setMaximum(runway.getWidth());
		sliderHori.setMinimum(0);

		

		sliderVert.setValue(0);
		sliderHori.setValue(5);

		sliderVert.addChangeListener(e -> {
			plane.setCurrentSpeed(sliderVert.getValue());
			throttle.setText("Throttle Position: " + String.valueOf(plane.getCurrentSpeed() + "        Steering Position: " + sliderHori.getValue()));
		});

		sliderHori.addChangeListener(e -> {
			plane.setXCoord(sliderHori.getValue());
			throttle.setText("Throttle Position: " + String.valueOf(plane.getCurrentSpeed() + "        Steering Position: " + sliderHori.getValue()));
		});
		
	}

	/**
	 * The setDisplayText method is used to set the text of the text area to the
	 * value passed in as a parameter.
	 * 
	 * @param text
	 *            The text to give to the text area is passed in through this
	 *            string
	 */
	public void setDisplayText(String text) {
		this.output.setText(text);
	}

	/**
	 * This method returns the text within the text area in this class.
	 * 
	 * @return A string value is returned, the string holds the text within the
	 *         text area.
	 */
	public String getDisplayText() {
		return this.output.getText();
	}

}
