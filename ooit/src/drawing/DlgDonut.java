package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgDonut extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private JButton btnOk;
	protected boolean isOk;
	private JButton btnCancel;
	private JButton btnInnerColor;
	private JButton btnOuterColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setBounds(100, 100, 450, 300);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel = new JLabel("X coordinate:");
					panel_1.add(lblNewLabel);
				}
				{
					txtX = new JTextField();
					panel_1.add(txtX);
					txtX.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_1 = new JLabel("Y coordinate:");
					panel_1.add(lblNewLabel_1);
				}
				{
					txtY = new JTextField();
					panel_1.add(txtY);
					txtY.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_2 = new JLabel("Radius:");
					panel_1.add(lblNewLabel_2);
				}
				{
					txtRadius = new JTextField();
					panel_1.add(txtRadius);
					txtRadius.setColumns(10);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JLabel lblNewLabel_3 = new JLabel("Inner Radius:");
					panel_1.add(lblNewLabel_3);
				}
				{
					txtInnerRadius = new JTextField();
					panel_1.add(txtInnerRadius);
					txtInnerRadius.setColumns(10);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					btnInnerColor = new JButton("Inner Color");
					btnInnerColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Color color = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
							btnInnerColor.setBackground(color);
						}
					});
					panel_1.add(btnInnerColor);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					btnOuterColor = new JButton("Outer Color");
					btnOuterColor.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Color color = JColorChooser.showDialog(null, "Choose a color", Color.BLACK);
							btnOuterColor.setBackground(color);
						}
					});
					panel_1.add(btnOuterColor);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						if(Integer.parseInt(gettxtRadius().getText()) < Integer.parseInt(gettxtInnerRadius().getText())) {
							JOptionPane.showMessageDialog(null, "radius must be greater than inner radius", "message", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
						isOk=true;
						setVisible(false);
					
						}
					}
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk=false;
						setVisible(false);
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}
	
	public JButton getbtnOk() {
		return btnOk;
	}

	public void setOkButton(JButton btnOk) {
		this.btnOk = btnOk;
	}

	public JButton getBtnBorderColor() {
		return btnOuterColor;
	}
	public JButton getBtnInnerColor() {
		return btnInnerColor;
	}

	public JTextField gettxtX() {
		return txtX;
	}

	public void settxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField gettxtY() {
		return txtY;
	}

	public void settxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField gettxtRadius() {
		return txtRadius;
	}

	public void settxtRadius(JTextField textRadius) {
		this.txtRadius = textRadius;
	}

	public JTextField gettxtInnerRadius() {
		return txtInnerRadius;
	}

	public void settxtInnerRadius(JTextField textInnerRadius) {
		this.txtInnerRadius = textInnerRadius;
	}

}
