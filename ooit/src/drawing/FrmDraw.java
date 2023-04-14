package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import drawing.DlgCircle;
import drawing.DlgDonut;
import drawing.DlgLine;
import drawing.DlgPoint;
import drawing.DlgRectangle;
import geometry.Donut;
import geometry.Circle;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JToggleButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class FrmDraw extends JFrame {

	private PnlDraw contentPane;
	private static JToggleButton btnPoint;
	private static JToggleButton btnLine;
	private static JToggleButton btnRectangle;
	private static JToggleButton btnCircle;
	private static JToggleButton btnDonut;
	private JButton btnDelete;
	private static JToggleButton btnSelect;
	private JButton btnEdit;
	private static ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDraw frame = new FrmDraw();
					buttonGroup.add(btnDonut);
					buttonGroup.add(btnRectangle);
					buttonGroup.add(btnPoint);
					buttonGroup.add(btnLine);
					buttonGroup.add(btnCircle);
					buttonGroup.add(btnSelect);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDraw() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 850, 500);
		contentPane = new PnlDraw(this);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.CYAN);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		btnPoint = new JToggleButton("Point");
		panel.add(btnPoint);
		
		btnLine = new JToggleButton("Line");
		panel.add(btnLine);
		
		btnRectangle = new JToggleButton("Rectangle");
		panel.add(btnRectangle);
		
		btnCircle = new JToggleButton("Circle");
		panel.add(btnCircle);
		
		btnDonut = new JToggleButton("Donut");
		panel.add(btnDonut);
		
		btnSelect = new JToggleButton("Select");
		panel.add(btnSelect);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select shape you want to edit", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					Shape selectedShape = contentPane.getShapes().get(contentPane.getIndex());
					
					if(selectedShape instanceof Point) {						
						DlgPoint editPoint = new DlgPoint();
						 
						editPoint.getTxtX().setText(((Point) selectedShape).getX()+"");
						editPoint.getTxtY().setText(((Point) selectedShape).getY()+"");
						editPoint.getColor().setBackground(((Point) selectedShape).getColor());
						editPoint.setVisible(true);
						
							if(editPoint.isOk) {
								Point pEdited = new Point(Integer.parseInt(editPoint.getTxtX().getText()), Integer.parseInt(editPoint.getTxtY().getText()));
							
								
								
								pEdited.setColor(editPoint.getColor().getBackground());
								
							
								pEdited.setSelected(false);
								contentPane.getShapes().remove(contentPane.getIndex());
								contentPane.getShapes().add(contentPane.getIndex(), pEdited);
								
							}
					}
					else if(selectedShape instanceof Line) {
						DlgLine editLine = new DlgLine();
						
						editLine.getTxtStartX().setText(((Line) selectedShape).getStartPoint().getX()+"");
						editLine.getTxtStartY().setText(((Line) selectedShape).getStartPoint().getY()+"");
						editLine.getTxtEndX().setText(((Line) selectedShape).getEndPoint().getX()+"");
						editLine.getTxtEndY().setText(((Line) selectedShape).getEndPoint().getY()+"");
						editLine.getBtnColor().setBackground(((Line) selectedShape).getColor());
						editLine.setVisible(true);
						
						
						
						if(editLine.isOk) {
							Point p1 = new Point(Integer.parseInt(editLine.getTxtStartX().getText()), Integer.parseInt(editLine.getTxtStartY().getText()));
							Point p2 = new Point(Integer.parseInt(editLine.getTxtEndX().getText()), Integer.parseInt(editLine.getTxtEndY().getText()));
							Line lEdited = new Line(p1, p2);
							lEdited.setColor(editLine.getBtnColor().getBackground());
						
							
							lEdited.setSelected(false);
							contentPane.getShapes().remove(contentPane.getIndex());
							contentPane.getShapes().add(contentPane.getIndex(), lEdited);
							
						}
					}
					else if(selectedShape instanceof Donut) {
						
						DlgDonut editDonut = new DlgDonut();
						
						editDonut.gettxtX().setText(((Donut) selectedShape).getCenter().getX()+"");
						editDonut.gettxtY().setText(((Donut) selectedShape).getCenter().getY()+"");
						editDonut.gettxtRadius().setText(((Donut) selectedShape).getRadius()+"");
						editDonut.gettxtInnerRadius().setText(((Donut) selectedShape).getInnerRadius()+"");
						editDonut.getBtnBorderColor().setBackground(((Donut) selectedShape).getColor());
						editDonut.getBtnInnerColor().setBackground(((Donut) selectedShape).getInnerColor());
						editDonut.getbtnOk().setText("Edit");
						editDonut.setVisible(true);
						
						if(editDonut.isOk) {
							Donut dEdited = new Donut();
							
							Point center = new Point(Integer.parseInt(editDonut.gettxtX().getText()), Integer.parseInt(editDonut.gettxtY().getText()));
							
							try {
								dEdited.setCenter(center);
								dEdited.setRadius(Integer.parseInt(editDonut.gettxtRadius().getText()));
								dEdited.setInnerRadius(Integer.parseInt(editDonut.gettxtInnerRadius().getText()));
								dEdited.setColor(editDonut.getBtnBorderColor().getBackground());
								dEdited.setInnerColor(editDonut.getBtnInnerColor().getBackground());

							} catch (Exception e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
							}
							dEdited.setSelected(false);
							contentPane.getShapes().remove(contentPane.getIndex());
							contentPane.getShapes().add(contentPane.getIndex(), dEdited);
						}
	
					}
					else if(selectedShape instanceof Circle) {
						DlgCircle editCircle = new DlgCircle();
						
						editCircle.gettxtX().setText(((Circle) selectedShape).getCenter().getX()+"");
						editCircle.gettxtY().setText(((Circle) selectedShape).getCenter().getY()+"");
						editCircle.gettxtRadius().setText(((Circle) selectedShape).getRadius()+"");
						editCircle.getBtnOuterColor().setBackground(((Circle) selectedShape).getColor());
						editCircle.getBtnInnerColor().setBackground(((Circle) selectedShape).getInnerColor());
						editCircle.getbtnOk().setText("Edit");
						editCircle.setVisible(true);
						
						if(editCircle.isOk) {
							Circle cEdited = new Circle();
							
							try {
								Point center = new Point(Integer.parseInt(editCircle.gettxtX().getText()), Integer.parseInt(editCircle.gettxtY().getText()));
								
								cEdited.setCenter(center);
								cEdited.setRadius(Integer.parseInt(editCircle.gettxtRadius().getText()));
								cEdited.setColor(editCircle.getBtnOuterColor().getBackground());
								cEdited.setInnerColor(editCircle.getBtnInnerColor().getBackground());

							} catch (Exception e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
							}
							cEdited.setSelected(false);
							contentPane.getShapes().remove(contentPane.getIndex());
							contentPane.getShapes().add(contentPane.getIndex(), cEdited);
						}
					
						
					}
					else if(selectedShape instanceof Rectangle) {
						DlgRectangle editRectangle = new DlgRectangle();
						
						editRectangle.gettxtX().setText(((Rectangle) selectedShape).getUpperLeftPoint().getX()+"");
						editRectangle.gettxtY().setText(((Rectangle) selectedShape).getUpperLeftPoint().getY()+"");
						editRectangle.gettxtHeight().setText(((Rectangle) selectedShape).getHeight()+"");
						editRectangle.gettxtWidth().setText(((Rectangle) selectedShape).getWidth()+"");
						editRectangle.getBtnOuterColor().setBackground(((Rectangle) selectedShape).getColor());
						editRectangle.getBtnInnerColor().setBackground(((Rectangle) selectedShape).getInnerColor());
						editRectangle.getOkButton().setText("Edit");
						editRectangle.setVisible(true);
						if(editRectangle.isOk) {
							Rectangle rEdited = new Rectangle();
							
							try {
								Point uppLeft = new Point(Integer.parseInt(editRectangle.gettxtX().getText()), Integer.parseInt(editRectangle.gettxtY().getText()));
								
								rEdited.setUpperLeftPoint(uppLeft);
								rEdited.setHeight(Integer.parseInt(editRectangle.gettxtHeight().getText()));
								rEdited.setWidth(Integer.parseInt(editRectangle.gettxtWidth().getText()));
								rEdited.setColor(editRectangle.getBtnOuterColor().getBackground());
								rEdited.setInnerColor(editRectangle.getBtnInnerColor().getBackground());
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								//e1.printStackTrace();
							}
							
							rEdited.setSelected(false);
							
							contentPane.getShapes().remove(contentPane.getIndex());
							contentPane.getShapes().add(contentPane.getIndex(), rEdited);		
						}
					}
					contentPane.setIndex(-1);
					contentPane.repaint();
				}
			}
		});
		panel.add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(contentPane.getIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select shape you want to delete", "Error", JOptionPane.ERROR_MESSAGE);				
				}
				else {
					int a=JOptionPane.showConfirmDialog(null,"Are you sure?");  
					if(a==JOptionPane.YES_OPTION){  
						contentPane.getShapes().remove(contentPane.getIndex());
						contentPane.setIndex(-1);
						contentPane.repaint();
					}
				}
			}
		
				
			
		});
	
		panel.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	}
	
	public JToggleButton getBtnPoint() {
		return btnPoint;
	}
	public JToggleButton getBtnCircle() {
		return btnCircle;
	}
	public JToggleButton getBtnDonut() {
		return btnDonut;
	}
	public JToggleButton getBtnRectangle() {
		return btnRectangle;
	}
	public JToggleButton getBtnLine() {
		return btnLine;
	}
	public JToggleButton getBtnSelect() {
		return btnSelect;
	}
	public JButton getBtnDelete() {
		return btnDelete;
	}
	public JButton getBtnEdit() {
		return btnEdit;
	}
	

}
