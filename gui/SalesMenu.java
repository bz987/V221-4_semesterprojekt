package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalesMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMenu window = new SalesMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SalesMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton CreateSale = new JButton("Opret salg");
		CreateSale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		CreateSale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateSale.setBounds(10, 117, 156, 29);
		frame.getContentPane().add(CreateSale);
		
		JButton FindProduct = new JButton("Find produkt");
		FindProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		FindProduct.setBounds(10, 78, 156, 29);
		frame.getContentPane().add(FindProduct);
		
		JButton CreateOrder = new JButton("Opret ordre");
		CreateOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		CreateOrder.setBounds(10, 42, 156, 29);
		frame.getContentPane().add(CreateOrder);
		
		JButton CreateProduct = new JButton("Opret produkt");
		CreateProduct.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		CreateProduct.setBounds(10, 195, 156, 29);
		frame.getContentPane().add(CreateProduct);
		
		JButton CreateCustomer = new JButton("Opret kunde");
		CreateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		CreateCustomer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		CreateCustomer.setBounds(10, 159, 155, 29);
		frame.getContentPane().add(CreateCustomer);
	}
}
