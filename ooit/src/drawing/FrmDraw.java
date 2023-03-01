package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.BoxLayout;


public class FrmDraw extends JFrame {

	private JPanel contentPane;
	private ButtonGroup btnGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDraw frame = new FrmDraw();
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
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton btnPoint = new JRadioButton("Point");
		panel.add(btnPoint);
		btnGroup.add(btnPoint);
		
		JRadioButton btnLine = new JRadioButton("Line");
		panel.add(btnLine);
		btnGroup.add(btnLine);
		
		JRadioButton btnRectangle = new JRadioButton("Rectangle");
		panel.add(btnRectangle);
		btnGroup.add(btnRectangle);
		
		JRadioButton btnCircle = new JRadioButton("Circle");
		panel.add(btnCircle);
		btnGroup.add(btnCircle);
		
		JRadioButton btnDonut = new JRadioButton("Donut");
		panel.add(btnDonut);
		btnGroup.add(btnDonut);
		
		JButton btnSelect = new JButton("Select");
		panel.add(btnSelect);
		
		JButton btnEdit = new JButton("Edit");
		panel.add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		panel.add(btnDelete);
		
		JPanel pnlCentar = new JPanel();
		pnlCentar.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		pnlCentar.setLayout(new BoxLayout(pnlCentar, BoxLayout.X_AXIS));
		
		JPanel pnlDraw = new PnlDraw(this);
		pnlCentar.add(pnlDraw);
	}

}
