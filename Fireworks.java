/* Leah Goodwin
	 * Jayda Medina

		lgoodwi3
		jmedina7
		Project 3
		TR 12:30-1:45

		We did not copy code from anyone on this assignment.

		This project simulates a catapult game. THe user is 
		provided with a height and distance and then prompted a speed and an angle.
		The program returns whether or not they went over the wall and calculates the score.
		For extra credit, the responses are randomized but still appropriate.
	*/


	import java.awt.Graphics;
	import java.awt.Color;
	import javax.swing.JComponent;

public class Fireworks extends JComponent {
	private Graphics g;
	protected static double speed;
	protected static double angle;
	protected static double time;
	protected int x = 0;
	protected int y = 1000;
	protected int h = getHeight();
	protected int w = getWidth();	
	
	static fireworkMath projectile = new fireworkMath(speed, angle, time);
	
	public Fireworks (double speed, double angle, double time) {
		super();
		this.speed = speed;
		this.angle = angle;
		this.time = time;
	}
	
	public void paintComponent(Graphics c) {
		
		drawPath(g);
		drawFirework(g);
	}
	
	public void drawPath(Graphics c) {
		
		g.setColor(Color.BLACK);
		for (int i = 0; i < time; i += 0.1) {
			int x2 = (int)((speed) * (Math.cos(Math.toRadians(angle)))*i);
			int y2 = (int)((speed * (Math.sin(Math.toRadians(angle)))*i));
			g.fillOval(x2, y2, 7, 7);
		}
	}
	
	public void drawFirework(Graphics d) {
		
		int x3 = (int)((speed) * (Math.cos(Math.toRadians(angle)))* time);
		int y3 = (int)((9.8 * ((speed * (Math.sin(Math.toRadians(angle))))*time - 0.5 * (9.8) * time * time)));
		// Draw circles that have an increasing radius
		for( int i = 120; i >= 10; i = i - 10) {
		g.drawOval(x - i,(( h - y) - i), 2 * i, 2 * i);
		}
	}
	
	
		public static void main(String[] args) 
		{	
			Canvas.window();	
		}
}		
					