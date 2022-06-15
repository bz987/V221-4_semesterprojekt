package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

import controller.CustomerController;
import controller.ProductController;
import ctr.Controller;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {

	private JFrame frmVlgEnMenu;
	private ProductController productController;
	private CustomerController customerController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		
		JButton btnSalg = new JButton("Salg");
		btnSalg.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpenSalesMenu();
			}
		});
		btnSalg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmVlgEnMenu.getContentPane().add(btnSalg);
		
		JButton btnNewButton = new JButton("Manager");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		frmVlgEnMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Lager");
		frmVlgEnMenu.getContentPane().add(btnNewButton_1);
		
		init();
	}

	private void init() {
		productController = new ProductController();
		customerController = new CustomerController();
		
	}

	private void OpenSalesMenu(MouseEvent e) {
		SalesMenu salesMenu = new SalesMenu();
		salesMenu.setModalityType(ModalityType.APPLICATION_MODAL);
		salesMenu.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		salesMenu.setVisible(true);

		
		
		
		
	}

}
