package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private JToggleButton btnDelete;
	private static JToggleButton btnSelect;
	private JToggleButton btnEdit;
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
		
		btnEdit = new JToggleButton("Edit");
		panel.add(btnEdit);
		
		btnDelete = new JToggleButton("Delete");
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
	public JToggleButton getBtnDelete() {
		return btnDelete;
	}
	public JToggleButton getBtnEdit() {
		return btnEdit;
	}
	

}
