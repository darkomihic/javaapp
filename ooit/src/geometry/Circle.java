package geometry;

public class Circle {
	private Point centar;
	private int radius;
	
	
	public Circle() {
		
	}
	
	public Circle(Point centar, int radius) {
		this.centar=centar;
		this.radius=radius;
	}
	
	public Circle(Point centar, int radius, boolean selected) {
		this(centar, radius);
		
	}
	
	public double area () {
		return radius*radius*Math.PI;
	}
	
	public double circumference () {
		return 2*radius*Math.PI;
	}
}
