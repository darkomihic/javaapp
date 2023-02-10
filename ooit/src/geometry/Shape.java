package geometry;

import java.awt.Graphics;

public abstract class Shape {

	private boolean selected;
	
	public Shape() {
		
	}
	
	public boolean isSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean contains(int x, int y);
	public abstract void draw (Graphics g);
	
	//ovde sam dodao nesto za graphics u module da resi problem valjda je to trebalo
	
	
}
