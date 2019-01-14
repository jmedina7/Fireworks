
public class fireworkMath extends Fireworks {

	protected double speed, angle;
	protected double time = 10;
	
	public fireworkMath (double speed, double angle, double time) {
		
		super(speed, angle, time);
		this.speed = speed;
		this.angle = angle;
		this.time = time;
	}
	
	public double trajX(double speed, double angle, double time) {
		double trajX = Math.abs((speed) * (Math.cos(angle)) * (time));
		return trajX;
	}
	
	public double trajY(double speed, double angle, double time) {
		double trajY = Math.abs((speed) * (Math.sin(angle)) * (time) - (1/2) * (-9.8) * Math.pow(time, 2) - 1000);
		return trajY;
	}
}
