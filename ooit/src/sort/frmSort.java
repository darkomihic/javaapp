package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;

public class frmSort extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultListModel<Circle> circlelist = new DefaultListModel<Circle>();
	Circle c = new Circle();
	boolean isEmpty = false;
	dlgSort dlg = new dlgSort();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmSort frame = new frmSort();
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
	public frmSort() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JList list = new JList();
		list.setModel(circlelist);
		panel.add(list);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 2, 0, 0));
		
		JButton btnAdd = new JButton("Add circle");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlg.txtcpX.setText("");
				dlg.txtcpY.setText("");
				dlg.txtRadius.setText("");
				dlg.setVisible(true);
				
				if(dlg.isOk) {
					c = new Circle(new Point(Integer.valueOf(dlg.txtcpX.getText()),Integer.valueOf(dlg.txtcpY.getText())), Integer.valueOf(dlg.txtRadius.getText()));
					circlelist.add(0, c);
				}
				
				dlg.isOk=false;
			}
		});
		panel_1.add(btnAdd);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JButton btnRemove = new JButton("Sort");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(circlelist.size() > 1) {
					
					for (int i = 0; i < circlelist.size(); i++) {
						for (int j = 0; j < circlelist.size() - 1; j++) {
							
							if (circlelist.getElementAt(i).area() < circlelist.getElementAt(j).area()) {
								
								Circle help = circlelist.getElementAt(i);
								circlelist.setElementAt(circlelist.getElementAt(j), i);
								circlelist.setElementAt(help, j);
										
							}
							
						}
					}
					}
					
					else {
						JOptionPane.showMessageDialog(null, "The list is not big enough!");
					}
			}
		});
		panel_1.add(btnRemove);
	}

}
