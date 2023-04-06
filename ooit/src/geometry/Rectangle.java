package geometry;

import java.awt.Color;
import java.awt.Graphics;



public class Rectangle extends SurfaceShape {
	
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
	
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected, Color color) {
	
		this(upperLeftPoint,width,height,selected);
		this.setColor(color);
	}
	
	public Rectangle (Point upperLeftPoint,int width, int height, boolean selected,Color color,Color innerColor) {
		this(upperLeftPoint,width,height,selected,color);
		this.setInnerColor(innerColor);
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
		this.upperLeftPoint.moveBy(x, y);
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
    	return (this.upperLeftPoint.getX() <=point.getX() &&
				this.upperLeftPoint.getY() <=point.getY() &&
				point.getX()<= this.upperLeftPoint.getX() + this.width &&
				point.getY()<= this.upperLeftPoint.getY() + this.height);
    }

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		if (this.upperLeftPoint.getX() <=x &&
				this.upperLeftPoint.getY() <=y &&
				x<= this.upperLeftPoint.getX() + this.width &&
				y<= this.upperLeftPoint.getY() + this.height) {
			return true;
		}else return false;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getColor());
		g.drawRect(this.upperLeftPoint.getX(), this.upperLeftPoint.getY(), width, height);
		this.fill(g);
		
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() - 2, upperLeftPoint.getY() + height - 2, 4, 4);
			g.drawRect(upperLeftPoint.getX() + width - 2, upperLeftPoint.getY() + height - 2, 4, 4);
		}
	}
	
	public void fill(Graphics g) {
		g.setColor(getInnerColor());
		g.fillRect(this.upperLeftPoint.getX()+1, this.upperLeftPoint.getY()+1, width-1, height-1);
	}

	@Override
	public void moveTo(int x, int y) {
		Point help = new Point(x,y);
		this.setUpperLeftPoint(help);
		
	}
	
	
	
	
}