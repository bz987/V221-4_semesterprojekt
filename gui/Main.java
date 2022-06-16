package gui;

import utility.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import controller.CustomerController;
import controller.ProductController;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

	private JFrame frmVlgEnMenu;
	private ProductController productController;
	private CustomerController customerController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		TestData.generate();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmVlgEnMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmVlgEnMenu = new JFrame();
		frmVlgEnMenu.setResizable(false);
		frmVlgEnMenu.setTitle("Vælg en menu");
		frmVlgEnMenu.setBounds(100, 100, 450, 300);
		frmVlgEnMenu.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frmVlgEnMenu.getContentPane().setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton salgBtn = new JButton("Salg");
		salgBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenSalesMenu();
			}
		});
		salgBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmVlgEnMenu.getContentPane().add(salgBtn);
		
		JButton managerBtn = new JButton("Manager");
		managerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmVlgEnMenu.getContentPane().add(managerBtn);
		
		JButton stockBtn = new JButton("Lager");
		frmVlgEnMenu.getContentPane().add(stockBtn);
		
		init();
	}

	private void OpenSalesMenu() {
		SalesMenu salesMenu = new SalesMenu(productController);
		salesMenu.setVisible(true);
		
	}

	private void init() {
		productController = new ProductController();
		customerController = new CustomerController();
		
	}

		
}


