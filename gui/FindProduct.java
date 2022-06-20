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

public class FindProduct extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductController productController;
	private JTextField textField;
	private JLabel lblNewLabel_1;


	/**
	 * Create the dialog.
	 */
	public FindProduct() {
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
	
		lblNewLabel_1 = new JLabel("Lokationen er:");
		lblNewLabel_1.setBounds(10, 123, 416, 97);
		contentPanel.add(lblNewLabel_1);
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
		HashMap<String, String> data = getProductData(getTextFieldData());
		lblNewLabel_1.setText("<html>Produkt navn: " +data.get("ProductName")+"<br/>" + "Lokationen er: "+data.get("Location")+"<br/>" + "Antal :" +data.get("Amount")+"</html>");
		
	}

	private void close() {
		contentPanel.setVisible(false);
		dispose();
		
	}

	private void init() {
		productController = new ProductController();

		
	}
}
