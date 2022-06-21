package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.ProductController;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;
import java.awt.Dialog.ModalityType;

public class FindProduct2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductController productController;
	private JTextField textField;
	private CreateOrder2 createOrder2;


	/**
	 * Create the dialog.
	 */
	public FindProduct2(CreateOrder2 createOrder2) {
		this.createOrder2 = createOrder2;
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Produkt s\u00F8gning");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 436, 230);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Indtast Stregkode:");
			lblNewLabel.setBounds(10, 18, 133, 40);
		}
		
		textField = new JTextField();
		textField.setBounds(167, 18, 240, 40);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JLabel lblNewLabel_2 = new JLabel("V\u00E6lg Produkt:");
			lblNewLabel_2.setBounds(28, 25, 129, 27);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 436, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("V\u00E6lg produkt");
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						printProductLocation();
					}
				});
				
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Tilbage");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						close();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init();
	}
	
	private String getTextFieldData() {
		String temp = "";
		temp += textField.getText();
		return temp;
	}
	private HashMap<String, String> getProductData(String barcode) {
		HashMap<String, String> temp = new HashMap<>();
		temp.put("Location", productController.findProduct(barcode).getLocation());
		temp.put("ProductName", productController.findProduct(barcode).getName());
		temp.put("Amount", ""+productController.findProduct(barcode).getAmount());
		return temp;
	}

	private void printProductLocation() {
		createOrder2.receiveData(getTextFieldData());
		
	}

	private void close() {
		contentPanel.setVisible(false);
		dispose();
		
	}

	private void init() {
		productController = new ProductController();

		
	}
}
