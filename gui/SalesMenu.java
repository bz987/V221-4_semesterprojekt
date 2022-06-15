package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductController;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalesMenu extends JFrame {

	private JPanel contentPane;
	private ProductController productController;


	/**
	 * Create the frame.
	 */
	public SalesMenu(ProductController productController) {
		setTitle("Salgsmenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton findProduct = new JButton("Find Produkt");
		findProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FindProduct();
			}
		});
		findProduct.setBounds(145, 27, 120, 23);
		contentPane.add(findProduct);
		
		JButton createSale = new JButton("Opret salg");
		createSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openCreateSale();
			}
		});
		createSale.setBounds(10, 27, 125, 23);
		contentPane.add(createSale);
		
		JButton logOut = new JButton("Log af");
		logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logOut();
			}
		});
		logOut.setBounds(275, 213, 124, 23);
		contentPane.add(logOut);
		
		JButton createProduct = new JButton("Opret produkt");
		createProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openCreateProduct();
			}
		});
		createProduct.setBounds(275, 78, 125, 23);
		contentPane.add(createProduct);
		
		JButton createOrder = new JButton("Opret Ordre");
		createOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openCreateOrder();
			}
		});
		createOrder.setBounds(275, 27, 125, 23);
		contentPane.add(createOrder);
		
		JButton createCustomer = new JButton("Opret kunde");
		createCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				openCreateCustomer();
			}
		});
		createCustomer.setBounds(10, 78, 125, 23);
		contentPane.add(createCustomer);
		
		init();
	}

	private void init() {
		this.productController = new ProductController(); 
	}

	private void logOut() {
		contentPane.setVisible(false);
		dispose();
		
	}

	protected void FindProduct() {
		FindProduct findProduct = new FindProduct(productController);
		findProduct.setVisible(true);

		
	}

	protected void openCreateOrder() {
		// TODO Auto-generated method stub
		
	}

	protected void openCreateProduct() {
		// TODO Auto-generated method stub
		
	}

	protected void openCreateCustomer() {
		// TODO Auto-generated method stub
		
	}

	protected void openCreateSale() {
		// TODO Auto-generated method stub
		
	}
}
