package geometry;

public class Line {
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

}
