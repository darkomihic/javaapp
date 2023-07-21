package geometry;

import java.awt.Color;
import java.awt.Graphics;



public class Circle extends SurfaceShape {
	protected Point center;
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
	
	public Circle(Point center, int radius, boolean selected, Color color) {
		this(center,radius,selected);
		this.setColor(color);
	}
	
	public Circle(Point center, int radius, boolean selected, Color color, Color innerColor) {
		this(center, radius, selected, color);
		this.setInnerColor(innerColor);
	}
	
	public double area () {
		return radius*radius*Math.PI;
	}
	
	public double circumference () {
		return 2*radius*Math.PI;
	}
	
	public void moveBy(int x, int y) {
		this.center.moveBy(x,y);
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
	
	public boolean contains(Point point) {
    	return this.center.distance(point.getX(), point.getY())<=this.radius;
    }

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return this.center.distance(x, y) <= this.radius;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawOval(this.center.getX()-this.radius, this.center.getY()-this.radius, this.radius*2, this.radius*2 );
		this.fill(g);
		
		if (selected) {
			g.setColor(Color.BLUE);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.setColor(Color.BLACK);
		}
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillOval(this.center.getX()-this.radius+1, this.center.getY()-this.radius+1, this.radius*2-2, this.radius*2-2);
	}
	
	
	
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point centar) {
		this.center = centar;
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public void moveTo(int x, int y) {
		this.center.setX(x);
		this.center.setY(y);
		
		
	}
	
	
}
