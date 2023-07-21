package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable {

	protected boolean selected;
	private Color color;
	
	public Shape() {
		
	}
	
	public Shape(Color color) {
		this.color=color;
	}
	
	public Shape(Color color, boolean selected) {
		this.color=color;
		this.selected=selected;
		
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color=color;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw (Graphics g);
	
	//ovde sam dodao nesto za graphics u module da resi problem valjda je to trebalo
	
	
}
