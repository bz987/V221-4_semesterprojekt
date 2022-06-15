package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.ProductController;
import ctr.Controller;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FindProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductController productController;
	private CustomerController customerController;
	private JTextField textField;


	/**
	 * Create the dialog.
	 */
	public FindProduct(ProductController productController, CustomerController customerController) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 230);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Indtast Stregkode:");
			lblNewLabel.setBounds(10, 18, 133, 40);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(167, 18, 240, 40);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Lokationen er:");
		lblNewLabel_1.setBounds(10, 123, 111, 26);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 436, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("V\u00E6lg produkt");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Tilbage");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init(productController, customerController);
	}
	
	private void init(ProductController productController, CustomerController customerController) {
		this.productController = productController;
		this.customerController = customerController;

	}
}
