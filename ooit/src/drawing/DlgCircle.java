package drawing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCircle() {
		setBounds(100, 100, 450, 300);
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
					textField = new JTextField();
					panel_1.add(textField);
					textField.setColumns(10);
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
					textField_1 = new JTextField();
					panel_1.add(textField_1);
					textField_1.setColumns(10);
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
					textField_2 = new JTextField();
					panel_1.add(textField_2);
					textField_2.setColumns(10);
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
					JButton btnInnerColor = new JButton("Inner Color");
					panel_1.add(btnInnerColor);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1);
				{
					JButton btnOuterColor = new JButton("Button Color");
					panel_1.add(btnOuterColor);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
