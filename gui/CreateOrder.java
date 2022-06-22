package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.ProductController;
import controller.SalesController;
import model.Customer;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Dialog.ModalityType;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateOrder extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private ProductController productController;
	private CustomerController customerController;
	private SalesController salesController;
	private JTextField textField;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateOrder dialog = new CreateOrder();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateOrder() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setTitle("Ordreoprettelse");
		setBounds(100, 100, 360, 314);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 253, 232);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Indtast kundetelefonnummer");
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(10, 11, 247, 57);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(10, 60, 237, 29);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 100, 333, 132);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 230, 341, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Opret ordre");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						generateOrder();
						
					}
				});
				okButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
					}
				});
				
				JButton btnNewButton = new JButton("Find kunde");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						findCustomer();
						
					}
				});
				btnNewButton.addMouseListener(new MouseAdapter() {
				
				});
				buttonPane.add(btnNewButton);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				{
					JButton cancelButton = new JButton("Annuller");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							close();
						}
					});
					cancelButton.setActionCommand("Cancel");
					buttonPane.add(cancelButton);
				}
				
			}
			init();
			
		}
	}
	private void close() {
			contentPanel.setVisible(false);
			dispose();
		
	}

	private void generateOrder() {
		if(findCustomer()) {
			salesController.createOrder(getTextFieldData());
			CreateOrder2 createOrder2 = new CreateOrder2();
			createOrder2.setCustomer(getTextFieldData());
			createOrder2.setVisible(true);
			this.setVisible(false);
		}
		
	}

	private void init() {
		customerController = new CustomerController();
		salesController = new SalesController();
		
	}

	private String getTextFieldData() {
		String temp = "";
		temp += textField.getText();
		return temp;
	}
	
	private boolean findCustomer() {
		Customer c = customerController.findCustomer(getTextFieldData());
		boolean success = true;
		if(c == null) {
			c = new Customer("n/a", "n/a", "n/a", 0, "n/a", 0.0) ;
			success = false;
		}
		
		String s = "<html>";
		s += "Kundenavn: " + c.getName();
		s += "<br/>Kundetelefonnummer: " + c.getPhoneNumber();
		s += "<br/>Kundens discount: " + c.getDiscount();
		s += "<br/>Kundens credit: " + c.getCredit();
		s += "<br/Kundegruppe: " + c.getGroup();
		s += "<html/>";
		
		lblNewLabel_1.setText(s);
		
		return success;
}
	
	
}
