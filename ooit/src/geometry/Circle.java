package geometry;

public class Circle {
	private Point center;
	private int radius;
	
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center=center;
		this.radius=radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		
	}
	
	public double area () {
		return radius*radius*Math.PI;
	}
	
	public double circumference () {
		return 2*radius*Math.PI;
	}
	
	public void moveBy(int x, int y) {
		this.center.setX(this.center.getX()+x);
		this.center.setY(this.center.getY()+y);
	}
	
	public String toString() {
    	return "Center=" + center + ", radius=" + radius;
    }
	
	public boolean equals(Object obj) {
		Circle help = (Circle) obj;
		if(obj instanceof Circle) {
			if (help.center.equals(this.center) && help.radius==this.radius)
				return true;
			else
				return false;
			
		} else {
			return false;
		}
	}
}
