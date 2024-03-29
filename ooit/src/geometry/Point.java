package geometry;

import java.awt.Color;
import java.awt.Graphics;



public class Point extends Shape {
	private int x;
	private int y;
	
	private boolean selected;
	
	public Point() {
		
	}
	
	public Point(int x, int y) {
		this.x=x;
		this.y=y;
	}
	
	public Point(int x, int y, boolean selected) {
		this.x=x;
		this.y=y;
		this.selected=selected;
	}
	
	public double distance(int x,int y) {
		double dx=this.x-x;
		double dy=this.y-y;
		double d= Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	public int getX(){
		return this.x;
	}
	
	public void setX(int x) {
		this.x=x;
	}
	
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y=y;
	}
	
	public String toString() {
		return "(" + x + "," + y + ")" ;
	}
	
	public void moveBy(int x, int y) {
		this.x=this.x+x;
		this.y=this.y+y;
	}
	
	public boolean equals(Object obj) {
		Point help = (Point) obj;
		if(obj instanceof Point) {
			if (this.x == help.x && this.y == help.y)
				return true;
			else
				return false;
			
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		return this.distance(x, y) <= 2;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawLine(this.x-2, this.y, this.x+2, this.y);
		g.drawLine(this.x,  this.y-2,  this.x, this.y+2);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(x-2, y-2, 4, 4);
			g.setColor(Color.BLACK);

		}
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		this.x=x;
		this.y=y;
		
	}
	
	public int compareTo(Object o) {
		if(o instanceof Point) {
			Point help = new Point(0 , 0);
			return (int) (this.distance(help.getX(), help.getY())-((Point)o).distance(help.getX(),help.getY() ) );
		}
		return 0;
	}
	
	
}
