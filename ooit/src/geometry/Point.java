package geometry;

public class Point {
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
}
