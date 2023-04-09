package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	public Line(){
		
	}
	
	public Line(Point startPoint, Point endPoint){
		this.startPoint=startPoint;
		this.endPoint=endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected){
		this.startPoint=startPoint;
		this.endPoint=endPoint;
		this.selected=selected;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected, Color color){
		this(startPoint, endPoint, selected);
		this.setColor(color);
	}
	
	
	
	
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public String toString() {
		return "(" + startPoint.getX() + "," + startPoint.getY() + "),(" + endPoint.getX() + " , " + endPoint.getY() + ")"  ;
	}
	
	public void moveBy(int x, int y) {
		this.startPoint.moveBy(x, y);
		this.endPoint.moveBy(x, y);
	}
	
	public boolean equals(Object obj) {
		Line help = (Line) obj;
		if(obj instanceof Line) {
			if (this.startPoint.equals(help.startPoint) && this.endPoint.equals(help.endPoint))
				return true;
			else
				return false;
			
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
    	if((startPoint.distance(x, y) + endPoint.distance(x, y)) - length() <=0.05 ) {
    		return true;}
    	else {
    		return false;}
    }

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawLine(this.startPoint.getX(), this.startPoint.getY(), this.endPoint.getX(), this.endPoint.getY());
	}

	@Override
	public void moveTo(int x, int y) {
		
		int helpx;
		int helpy;
		
		helpx=x-this.startPoint.getX();
		helpy=y-this.startPoint.getY();
		
		
		this.startPoint.setX(x);
		this.startPoint.setY(y);
		
		this.endPoint.setY(this.endPoint.getY()+helpy);
		this.endPoint.setX(this.endPoint.getX()+helpx);
			
	}
	
	public int compareTo(Object o) {
		if(o instanceof Line) {
			return (int) (this.length()-((Line)o).length());
		}
		return 0;
	}

	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

	

}
