package geometry;


public class Rectangle {
	
	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height){
		this.upperLeftPoint=upperLeftPoint;
		this.width=width;
		this.height=height;
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected){
		this.upperLeftPoint=upperLeftPoint;
		this.width=width;
		this.height=height;
		this.selected=selected;
	}
	
	public int area() {
		return height*width;
	}
	
	public int circumference() {
		return 2*height+2*width;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	public String toString() {
		return "Upper left point: " + upperLeftPoint.toString() + ", width: " + width + ", height: " + height; 
	}
	
	public void moveBy(int x, int y) {
		this.upperLeftPoint.setX(this.upperLeftPoint.getX()+x);
		this.upperLeftPoint.setY(this.upperLeftPoint.getY()+y);
	}
	
	public boolean equals(Object obj) {
		Rectangle help = (Rectangle) obj;
		if(obj instanceof Rectangle) {
			if (help.upperLeftPoint.equals(this.upperLeftPoint) && help.width==this.width && help.height==help.height)
				return true;
			else
				return false;
			
		} else {
			return false;
		}
	}
	
	public boolean contains(Point point) {
    	return (this.upperLeftPoint.getX() <= point.getX() 
    			&& this.upperLeftPoint.getY() >= point.getY() 
    			&& point.getX() <= this.upperLeftPoint.getX() + this.width 
    			&& point.getY() >= this.upperLeftPoint.getY() - this.height);
    }
	
	
}