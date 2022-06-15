package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import controller.ProductController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalesMenu {

	private JFrame frame;
	private ProductController productController;
	
	/**
	 * Create the application.
	 */
	public SalesMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ProductController productController) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton CreateSale = new JButton("Opret salg");
		CreateSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createSale();
			}
		});
		CreateSale.setBounds(10, 25, 132, 29);
		frame.getContentPane().add(CreateSale);
		
		JButton FindProduct = new JButton("Find produkt");
		FindProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				findProduct();
			}
		});
		FindProduct.setBounds(152, 25, 122, 29);
		frame.getContentPane().add(FindProduct);
		
		JButton CreateOrder = new JButton("Opret ordre");
		CreateOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createOrder();
			}
		});
		CreateOrder.setBounds(284, 25, 132, 29);
		frame.getContentPane().add(CreateOrder);
		
		JButton CreateProduct = new JButton("Opret produkt");
		CreateProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CreateProduct();
			}
		});
		CreateProduct.setBounds(10, 94, 156, 29);
		frame.getContentPane().add(CreateProduct);
		
		JButton CreateCustomer = new JButton("Opret kunde");
		CreateCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				createCustomer();
			}
		});
		CreateCustomer.setBounds(261, 94, 155, 29);
		frame.getContentPane().add(CreateCustomer);
		
		JButton LogOut = new JButton("Log af");
		LogOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogOut();
			}
		});
		LogOut.setBounds(312, 197, 89, 23);
		frame.getContentPane().add(LogOut);
		
		init();
	}

	private void init() {
		this.productController = new ProductController();
	}

	private void createSale() {
		// TODO Auto-generated method stub
		
	}

	private void findProduct() {
		
	}

	private void createOrder() {
		// TODO Auto-generated method stub
		
	}

	private void CreateProduct() {
		// TODO Auto-generated method stub
		
	}

	private void createCustomer() {
		// TODO Auto-generated method stub
		
	}

	protected void LogOut() {
		frame.setVisible(false);
		frame.dispose();
		
	}
}
