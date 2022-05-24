package ui;
import controller.*;
import model.*;
import java.util.Scanner;

public class ManagerUI {
    private SalesController salesController;
    private ProductController productController;
    private SalesAssistantController salesAssistantController;
    private CustomerContainer customerContainer;
    /**
     * Constructor for objects of class LoanMenu
     */
    public ManagerUI() {
        // initialise instance variables
        productController = new ProductController();
        salesController = new SalesController();
        salesAssistantController = new SalesAssistantController();
        customerContainer.getInstance();
    }

    public void start() {
        ManagerMenu();
    }
    
    private void ManagerMenu() {
        boolean running = true;
        while (running) {
            int choice = writeManagerMenu();
            switch (choice) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    createCustomer();
                    break;
                case 4:
                    break;
                case 5:
                    findCustomer();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("En uforklarlig fejl er sket med choice = " + choice);
                    break;
            }
        }
    }

    private int writeManagerMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** ManagerMenu ******");
        System.out.println(" (1) Opret salg");
        System.out.println(" (2) Opret order");
        System.out.println(" (3) Opret kunde");
        System.out.println(" (4) Find product");
        System.out.println(" (5) Find kunde");
        System.out.println(" (6) S�t discount");
        System.out.println(" (7) S�t kredit");
        System.out.println(" (0) Tilbage");
        System.out.print("\n V�lg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private void createCustomer(){
        String name = writeCustomerName();
        String phoneNumber = writeCustomerPhoneNumber();
        String address = writeCustomerAddress();
        int discount = writeCustomerDiscount();
        String group = writeCustomerGroup();
        double credit = writeCustomerCredit();
        customerContainer.createCustomer(name, phoneNumber, address, discount, group, credit);
    }

    private String writeCustomerName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundenavn");
        String customerName = keyboard.nextLine();
        return customerName;
    }

    private String writeCustomerPhoneNumber(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundetelefonnummer");
        String customerPhoneNumber = keyboard.nextLine();
        return customerPhoneNumber;
    }

    private String writeCustomerAddress(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundeaddresse");
        String customerAddress = keyboard.nextLine();
        return customerAddress;
    }

    private int writeCustomerDiscount(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundediscount");
        int customerDiscount = keyboard.nextInt();
        return customerDiscount;
    }
    
    private String writeCustomerGroup(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundegruppe");
        String customerGroup = keyboard.nextLine();
        return customerGroup;
    }
    
    private double writeCustomerCredit(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundekredit");
        double customerCredit = keyboard.nextDouble();
        return customerCredit;
    }

    private Customer findCustomer(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv telefonnummer");
        String search = keyboard.nextLine();
        Customer c = customerContainer.getCustomer(search);
        return c;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal v�re et tal - pr�v igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}