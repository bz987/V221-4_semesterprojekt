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
import model.Line;
import model.Product;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;

public class CreateOrder2 extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private TableModel ptm;
	private Customer customer;
	private SalesController salesController;
	private ProductController productController;
	private CustomerController customerController;

	/**
	 * Create the dialog.
	 */
	public CreateOrder2() {
		setModalityType(ModalityType.DOCUMENT_MODAL);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JScrollPane scrollPane = new JScrollPane();
			contentPanel.add(scrollPane, BorderLayout.CENTER);
			{
				table = new JTable();
				
				scrollPane.setViewportView(table);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("F\u00E6rdigg\u00F8r ordre");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						salesController.finalizeOrder();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Tilf\u00F8j produkt");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Addproduct();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			{
				JButton btnNewButton = new JButton("Annuller");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				buttonPane.add(btnNewButton);
				
				

				
			}
			
		}
		init();
	}

	private void init() {
		salesController = new SalesController();
		productController = new ProductController();
		customerController = new CustomerController();
		ptm = new TableModel();
		table.setModel(ptm);
	}

	private void Addproduct() {
		FindProduct2 findproduct2 = new FindProduct2(this);
		findproduct2.setVisible(true);
	}
	
	public void receiveData(String barcode) {
		Line l = new Line(productController.findProduct(barcode));
		boolean foundOnTable = false;
		for (int i=0; i<ptm.getRowCount(); i++) {
			if (l.getBarcode().equals(ptm.getLine(i).getBarcode())) {
				ptm.getLine(i).addOne();
				ptm.fireTableDataChanged();
				foundOnTable = true;
			}
		}
		if (!foundOnTable) {
			ptm.addData(l);
		}
	}
	public void setCustomer(String phonenumber) {
		customer = customerController.findCustomer(phonenumber);
	}

}
