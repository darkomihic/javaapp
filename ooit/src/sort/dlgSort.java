package sort;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import stack.dlgStack;

public class dlgSort extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected JTextField txtcpX;
	protected JTextField txtcpY;
	protected JTextField txtRadius;
	protected boolean isOk=false;
	protected boolean error = false;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dlgStack dialog = new dlgStack();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public dlgSort() {
		setModal(true);
		setBounds(100, 100, 425, 151);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Center point X:");
				panel.add(lblNewLabel);
			}
			{
				txtcpX = new JTextField();
				panel.add(txtcpX);
				txtcpX.setColumns(10);
			}
			{
				JLabel txtcpY = new JLabel("Center point Y:");
				panel.add(txtcpY);
			}
			{
				txtcpY = new JTextField();
				panel.add(txtcpY);
				txtcpY.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			{
				JLabel lblNewLabel_2 = new JLabel("Radius:");
				panel.add(lblNewLabel_2);
			}
			{
				txtRadius = new JTextField();
				panel.add(txtRadius);
				txtRadius.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						try {
							
							
							int checkRadius = Integer.parseInt(txtRadius.getText());
							
							
							if(checkRadius<=0) {
								
								throw new IllegalArgumentException();
								
							}
							
							
							}catch (Exception badInput){
							
							JOptionPane.showMessageDialog(null, "You need to enter a NUMBER for both the coordinates and the width and height values"
									+ ", AND the width and height values cannot be 0 or negative!");
							error = true;
							
						}
						
						if (!error) {
							
							isOk = true;
							setVisible(false);
							txtcpX.setEditable(true);
							txtcpY.setEditable(true);
							txtRadius.setEditable(true);
							
						}
						
						error = false;
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						setVisible(false);
						
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
