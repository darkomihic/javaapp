package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.BorderLayout;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.SpringLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> lista = new ArrayList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		
		JToggleButton crveno = new JToggleButton("Crvena");
		crveno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.add("Crveno");
			}
		});
		panel_2.add(crveno);
		
		JLabel lblNewLabel_2 = new JLabel("Crvena");
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		
		JToggleButton zuto = new JToggleButton("Zuto");
		zuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.add("Zuto");
			}
		});
		panel_1.add(zuto);
		
		JLabel lblNewLabel_1 = new JLabel("Zuto");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3);
		
		JToggleButton plavo = new JToggleButton("Plavo");
		plavo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lista.add("Plavo");
			}
		});
		panel_3.add(plavo);
		
		JLabel lblNewLabel = new JLabel("Plavo");
		panel_3.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.SOUTH);
		
		JToggleButton klik = new JToggleButton("Klikni me");
		klik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlg = new DlgTest();
				dlg.setVisible(true);
			}
			
		});
		panel_4.add(klik);
	}

}
