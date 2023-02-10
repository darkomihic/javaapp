package geometry;

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
	
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public String toString() {
		return "(" + startPoint.getX() + "," + startPoint.getY() + "),(" + endPoint.getX() + " , " + endPoint.getY() + ")"  ;
	}
	
	public void moveBy(int x, int y) {
		this.startPoint.setX(this.startPoint.getX()+x);
		this.startPoint.setY(this.startPoint.getY()+y);
		this.endPoint.setX(this.startPoint.getX()+x);
		this.endPoint.setY(this.startPoint.getY()+y);
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
		
	}

}
