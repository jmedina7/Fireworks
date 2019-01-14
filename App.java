import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class App<ComboBox> extends JComponent implements ActionListener, ItemListener {
	
	JPanel panel = new JPanel();
	Color NAVY = new Color(0, 25, 175);
	protected Graphics g;
	protected int y2, x2, x3, y3;
	protected JButton launch;
	protected JTextField speedInput, angleInput, timeInput;
	protected double speed, angle, time;
	protected JLabel speedLabel, angleLabel, timeLabel, shapeLabel, colorLabel;
	protected int h = getHeight();
	protected int w = getWidth();
	protected String color = "black";
	protected String shape = "circle";
	
	//Empty spaces are used as a placeholder for selection purposes
	String[] shapeArray = { "Square", "Spread", "Spritz of Perfume", "Star", " " };
	String[] colorArray = { "Red", "Orange", "Yellow", "Green", "Blue", "Cyan", " " };
	
	JComboBox shapeList = new JComboBox(shapeArray);
	JComboBox colorList = new JComboBox(colorArray);
	
	public App() {
		
		setLayout(new FlowLayout(FlowLayout.LEFT));

			// Add and intialize everything
			speedLabel = new JLabel("Enter speed (m/s): ");
			add(speedLabel);
			speedInput = new JTextField(3);
			add(speedInput);
			angleLabel = new JLabel("Enter angle (degrees): ");
			add(angleLabel);
			angleInput = new JTextField(3);
			add(angleInput);
			timeLabel = new JLabel("Enter time (seconds): ");
			add(timeLabel);
			timeInput = new JTextField(3);
			add(timeInput);
			shapeLabel = new JLabel("Shapes");
			add(shapeLabel);
			add(shapeList);
			colorLabel = new JLabel("Colors");
			add(colorLabel);
			add(colorList);
			 

			// Set the index and labels
			shapeList.setSelectedIndex(4);
			colorList.setSelectedIndex(6);

			// Add the item listener
			shapeList.addItemListener(this);
			colorList.addItemListener(this);
			
			// Create new buttons for user input
			launch = new JButton("Launch!");
			launch.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics g = getGraphics();
				speed = Double.parseDouble(speedInput.getText());
				angle = Double.parseDouble(angleInput.getText());
				time = Double.parseDouble(timeInput.getText());
				drawPath(g);
				drawFirework(g);
			}
			});
				add(launch);
			}
	
	@Override
	public void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, width, height);
		drawPath(g);
		drawFirework(g);
	}
	
	public void drawPath(Graphics g) {
		g.setColor(Color.BLACK);
		for (int i = 0; i < time; i++) { // 0.1
			int x2 = (int) (speed * ((Math.cos(Math.toRadians(angle))) * i));
			int y2 = (int) (700 - (speed * ((Math.sin(Math.toRadians(angle)))) * i - (0.5 * (9.8)) * i * i));
			g.fillOval(x2, y2, 7, 7);
			System.out.println("x: " + x2 + ", y: " + y2);
		}

		System.out.println("x " + x2);
		System.out.println("y " + y2);

	}
	
	public void drawFirework(Graphics g) {
		System.out.println("angle: " + angle + ", speed: " + speed + ", time: " + time);
		int x3 = (int) ((speed) * (Math.cos(Math.toRadians(angle))) * time);
		int y3 = (int) (((speed * (Math.sin(Math.toRadians(angle)))) * time - (0.5 * (9.8)) * time * time));
		System.out.println(x3);
		System.out.println(y3);

		if (shape == "Square") {
			if (color.equals("Red")) {
				g.setColor(Color.RED);
			} else if (color.equals("Orange")) {
				g.setColor(Color.ORANGE);
			} else if (color.equals("Yellow")) {
				g.setColor(Color.YELLOW);
			} else if (color.equals("Green")) {
				g.setColor(Color.GREEN);
			} else if (color.equals("Blue")) {
				g.setColor(Color.BLUE);
			} else if (color.equals("Cyan")) {
				g.setColor(Color.CYAN);
			}
			// Draw square
			g.drawRect(x3, 690 - y3, 50, 50 );
			
		}
		Random r = new Random();
		if (shape == "Spread") {
			if (color.equals("Red")) {
				g.setColor(Color.RED);
			} else if (color.equals("Orange")) {
				g.setColor(Color.ORANGE);
			} else if (color.equals("Yellow")) {
				g.setColor(Color.YELLOW);
			} else if (color.equals("Green")) {
				g.setColor(Color.GREEN);
			} else if (color.equals("Blue")) {
				g.setColor(Color.BLUE);
			} else if (color.equals("Cyan")) {
				g.setColor(Color.CYAN);
			}

			// Draw random dots
			for (int i = 0; i <= 100; i++) {
				int pointX = r.nextInt(100) + (x3 - 50);
				int pointY = r.nextInt(100) + (690 - y3 - 50);
				g.drawOval(pointX, pointY, 2, 2);
			}
		}
		if (shape == "Spritz of Perfume") {
			if (color.equals("Red")) {
				g.setColor(Color.RED);
			} else if (color.equals("Orange")) {
				g.setColor(Color.ORANGE);
			} else if (color.equals("Yellow")) {
				g.setColor(Color.YELLOW);
			} else if (color.equals("Green")) {
				g.setColor(Color.GREEN);
			} else if (color.equals("Blue")) {
				g.setColor(Color.BLUE);
			} else if (color.equals("Cyan")) {
				g.setColor(Color.CYAN);
			}

			// 100 lines of the same radius to appear around the same point
			for (int i = 0; i <= 100; i++) {
				g.drawLine(x3, 690 - y3, (int) (x3 + 50 * Math.cos(i)), (int) (690 - y3 + 50 * Math.sin(i)));
			}
		}

		if (shape == "Star") {
			if (color.equals("Red")) {
				g.setColor(Color.RED);
			} else if (color.equals("Orange")) {
				g.setColor(Color.ORANGE);
			} else if (color.equals("Yellow")) {
				g.setColor(Color.YELLOW);
			} else if (color.equals("Green")) {
				g.setColor(Color.GREEN);
			} else if (color.equals("Blue")) {
				g.setColor(Color.BLUE);
			} else if (color.equals("Cyan")) {
				g.setColor(Color.CYAN);
			}
			for (int i = 0; i <= 6; i++) {
				g.drawLine(x3, 690 - y3, (int) (x3 + 50 * Math.cos(i)), (int) (690 - y3 + 50 * Math.sin(i)));
			}
			for (int i = 0; i <= 6; i++) {
				g.drawLine(x3 + 10, 670 - y3, (int) (x3 + 50 * Math.cos(i)), (int) (690 - y3 + 50 * Math.sin(i)));
			}
			for (int i = 0; i <= 6; i++) {
				g.drawLine(x3 - 10, 670 - y3, (int) (x3 + 50 * Math.cos(i)), (int) (690 - y3 + 50 * Math.sin(i)));
			}
		}
	}


		@Override
		public void actionPerformed(ActionEvent e) {

		}

		// Listener for the combo box
		@Override
		public void itemStateChanged(ItemEvent e) {
			if ((e.getSource()).equals(colorList)) {
				color = (String) colorList.getSelectedItem();
				System.out.println("color" + color);
			}
			if ((e.getSource()).equals(shapeList)) {
				shape = (String) shapeList.getSelectedItem();

			}
		}

	}
	






