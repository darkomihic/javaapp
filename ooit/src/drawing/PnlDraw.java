package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PnlDraw extends JPanel {

	
	private FrmDraw frame;
	private ArrayList<Shape>shapes=new ArrayList<Shape>();
	private boolean clickedFirst;
	private Point firstPoint;
	private Point secondPoint;
	private int index = -1;
	
	/**
	 * Create the panel.
	 */
	public PnlDraw(FrmDraw frame) {
		setBackground(Color.white);
		this.frame = frame;
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 firstPoint = new Point(e.getX(),e.getY());
		
				if(frame.getBtnSelect().isSelected()){
					for(int i = 0; i < shapes.size();i++) {						
							shapes.get(i).setSelected(false);	
							index =  -1;
					}
					
					for(int i = shapes.size()-1; 0 <= i; i--) {
						if(shapes.get(i).contains(firstPoint.getX(), firstPoint.getY())) {
							shapes.get(i).setSelected(true);
							index = i;
							break;
						}		 
						
					}

				}
				else if(frame.getBtnPoint().isSelected()){
					firstPoint.setColor(Color.BLACK);
					shapes.add(firstPoint);
				}
				else if(frame.getBtnLine().isSelected()) {
					
					Point secondClick;
					
					if(clickedFirst == true) {
						secondClick = new Point(e.getX(),e.getY());
						Line line = new Line(secondPoint,secondClick);
						clickedFirst = false;
						line.setColor(Color.BLACK);
						shapes.add(line);
						
					}
					else {
						secondPoint = new Point(e.getX(),e.getY());
						clickedFirst=true;
					}
				}
				else if(frame.getBtnRectangle().isSelected()) {
					Rectangle rectangle = new Rectangle();
					rectangle.setUpperLeftPoint(new Point(e.getX(),e.getY()));
					
					DlgRectangle dlgRectangle = new DlgRectangle();
					dlgRectangle.gettxtX().setText(e.getX() + "");
					dlgRectangle.gettxtY().setText(e.getY() + "");
					dlgRectangle.setVisible(true);
					
					try {
						if(dlgRectangle.isOk) {
							rectangle.setHeight(Integer.parseInt(dlgRectangle.gettxtHeight().getText()));
							rectangle.setWidth(Integer.parseInt(dlgRectangle.gettxtWidth().getText()));
							rectangle.setColor(dlgRectangle.getBtnOuterColor().getBackground());
							rectangle.setInnerColor(dlgRectangle.getBtnInnerColor().getBackground());
							shapes.add(rectangle);
						}
						else
						{
							System.out.println("ovde ispada jebemu mu majku u picku");
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "please enter valid value", "message", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}
				else if(frame.getBtnCircle().isSelected()) {
					Circle circle = new Circle();
					circle.setCenter(new Point(e.getX(),e.getY()));
					
					DlgCircle dlgCircle = new DlgCircle();
					dlgCircle.gettxtX().setText(e.getX() + "");
					dlgCircle.gettxtY().setText(e.getY() + "");
					dlgCircle.setVisible(true);
					
					try {
						if(dlgCircle.isOk==true) {
							circle.setRadius(Integer.parseInt(dlgCircle.gettxtRadius().getText()));
							circle.setColor(dlgCircle.getBtnOuterColor().getBackground());
							circle.setInnerColor(dlgCircle.getBtnInnerColor().getBackground());
							shapes.add(circle);
						}
						else
						{
							System.out.println("ovde ispao");
						}
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						//e1.printStackTrace();
						JOptionPane.showMessageDialog(null, "please enter valid value", "message", JOptionPane.INFORMATION_MESSAGE);
					}
					
					
				}else if(frame.getBtnDonut().isSelected()) {
					
				}
				repaint();
			}
			
		});
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext())
			it.next().draw(g); 
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
}