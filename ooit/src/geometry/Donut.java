package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {
	
	private int innerRadius;
	// nesto
	
	public Donut() {
		
	}
	
	public Donut(Point center, int innerRadius, int radius) {
		super(center,radius);
		this.innerRadius=innerRadius;
	}
	
	public Donut(Point center,int radius, int innerRadius,boolean selected) {
		this(center,radius,innerRadius);
		setSelected(selected);
	}
	
	public Donut(Point center,int radius, int innerRadius,boolean selected,Color color) {
		this(center,radius,innerRadius,selected);
		this.setColor(color);
	}
	
	public Donut(Point center,int radius, int innerRadius,boolean selected,Color color,Color innerColor) {
		this(center,radius,innerRadius,selected,color);
		this.setInnerColor(innerColor);
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
	
	public void draw(Graphics g) {
		g.setColor(getInnerColor());
		g.drawOval(this.getCenter().getX()-this.innerRadius,this.getCenter().getY()-this.innerRadius,
				this.innerRadius*2, this.innerRadius*2);
		this.fill(g);
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		super.fill(g);
		g.setColor(Color.white); //da oboji unutrasnjost valjda
		g.fillOval(this.getCenter().getX()-innerRadius+1,this.getCenter().getY()-innerRadius+1,
				this.innerRadius*2-2,this.innerRadius*2-2);
	}
}
