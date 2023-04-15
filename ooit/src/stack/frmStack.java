package stack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;

import geometry.Circle;
import geometry.Point;

public class frmStack extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultListModel<Circle> circlelist = new DefaultListModel<Circle>();
	private JPanel contentPane;
	Circle c = new Circle();
	boolean isEmpty = false;
	dlgStack dlg = new dlgStack();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmStack frame = new frmStack();
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
	public frmStack() {
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
		
		JButton btnRemove = new JButton("Remove circle");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(circlelist.isEmpty()) {
						throw new IllegalArgumentException();
					}
				} catch(Exception listEmpty) {
					isEmpty=true;
					JOptionPane.showMessageDialog(null, "The list is empty.");

				}
				
				if(!isEmpty) {
					dlg.txtcpX.setText(String.valueOf(circlelist.elementAt(0).getCenter().getX()));
					dlg.txtcpY.setText(String.valueOf(circlelist.elementAt(0).getCenter().getY()));
					dlg.txtcpX.setText(String.valueOf(circlelist.elementAt(0).getRadius()));
					dlg.setVisible(true);
					
					if (dlg.isOk) {
						
						circlelist.remove(0);
						
					}
					
					dlg.isOk = false;
				}
				
				isEmpty=false;
			}
		});
		panel_1.add(btnRemove);
	}

}
