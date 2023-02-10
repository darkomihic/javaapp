package geometry;



public class Donut extends Circle {
	
	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int innerRadius, int radius) {
		super(center,radius);
		this.innerRadius=innerRadius;
	}
	
	public Donut(Point centar,int radius, int innerRadius,boolean selected) {
		this(centar,radius,innerRadius);
		setSelected(selected);
	}
	
	public double area() {
		return super.area()-innerRadius*innerRadius*Math.PI;
	}
	
	public boolean equals(Object obj) {
		
		if(obj instanceof Donut) {
			Donut help = (Donut) obj;
			return (this.innerRadius == help.innerRadius &&
					this.getCenter().equals(help.getCenter()) &&
					this.getRadius() == help.getRadius());
		} else return false;
	}
	
	public boolean contains(int x,int y ) {
		double distanceFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && distanceFromCenter > innerRadius;
	}
	
	public boolean contains(Point point) {
		double distanceFromCenter = this.getCenter().distance(point.getX(), point.getY());
		return super.contains(point.getX(), point.getY()) && distanceFromCenter > innerRadius;
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}
	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public String toString() {
		return super.toString() + ", inner radius" + innerRadius;
	}
}
