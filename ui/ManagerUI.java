package ui;
import controller.*;
//import model.*;
import java.util.Scanner;

public class ManagerUI {
    private SalesController salesController;
    private ProductController productController;
    private CustomerController customerController;
    private SalesAssistantController salesAssistantController; // TODO: Ikke implementeret
    /**
     * Constructor for objects of class LoanMenu
     */
    public ManagerUI() {
        // initialise instance variables
        productController = new ProductController();
        salesController = new SalesController();
        customerController = new CustomerController();
        salesAssistantController = new SalesAssistantController();
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
                    createSale();
                    break;
                case 2:
                    createOrder();
                    break;
                case 3:
                    createCustomer();
                    break;
                case 4:
                    findProduct();
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
        System.out.println(" (6) Sæt discount");
        System.out.println(" (7) Sæt kredit");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        keyboard.close();
        return choice;
    }

    private void findProduct() {
        String barcode = writeProductBarcode();
        if (salesController.addProduct(barcode)){
            System.out.println("Added: "+productController.findProduct(barcode).getName()+" to the reciept");
        } else {
            System.out.println("Alert: Opret et salg eller en order først!");
        }
    }

    private void createOrder() {
        String phoneNumber = writePhoneNumber();
        if (salesController.createOrder(phoneNumber)){
            System.out.println("En order er blevet registreret under navnet "+customerController.findCustomer(phoneNumber).getName());
        } else {
            System.out.println("Alert: Kunne ikke oprette ordren!");
        }
    }

    private void createSale() {
        if (salesController.createSale()){
            System.out.println("Et salg er blevet oprettet under salgs nummeret "+ salesController.getNumberOfSales()+1);
        } else {
            System.out.println("Alert: Kunne ikke oprette et salgs!");
        }
    }

    private String writePhoneNumber(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv et telefonnummer");
        String input = keyboard.nextLine();
        keyboard.close();
        return input;
    }

    private String writeProductBarcode() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv produkt barcode");
        String input = keyboard.nextLine();
        keyboard.close();
        return input;
    }

    private void createCustomer(){
        String name = writeCustomerName();
        String phoneNumber = writeCustomerPhoneNumber();
        String address = writeCustomerAddress();
        int discount = writeCustomerDiscount();
        String group = writeCustomerGroup();
        double credit = writeCustomerCredit();
        customerController.createCustomer(name, phoneNumber, address, discount, group, credit);
    }

    private String writeCustomerName(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundenavn");
        String customerName = keyboard.nextLine();
        keyboard.close();
        return customerName;
    }

    private String writeCustomerPhoneNumber(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundetelefonnummer");
        String customerPhoneNumber = keyboard.nextLine();
        keyboard.close();
        return customerPhoneNumber;
    }

    private String writeCustomerAddress(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundeaddresse");
        String customerAddress = keyboard.nextLine();
        keyboard.close();
        return customerAddress;
    }

    private int writeCustomerDiscount(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundediscount");
        int customerDiscount = keyboard.nextInt();
        keyboard.close();
        return customerDiscount;
    }
    
    private String writeCustomerGroup(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundegruppe");
        String customerGroup = keyboard.nextLine();
        keyboard.close();
        return customerGroup;
    }
    
    private double writeCustomerCredit(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv kundekredit");
        double customerCredit = keyboard.nextDouble();
        keyboard.close();
        return customerCredit;
    }

    private void findCustomer(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv telefonnummer");
        String phoneNumber = keyboard.nextLine();
        System.out.println("================Customer=================");
        System.out.println("Name: "+customerController.findCustomer(phoneNumber).getName());
        System.out.println("PhoneNr: "+customerController.findCustomer(phoneNumber).getPhoneNumber());
        System.out.println("Address: "+customerController.findCustomer(phoneNumber).getAddress());
        System.out.println("Discount: "+customerController.findCustomer(phoneNumber).getDiscount());
        System.out.println("=========================================");
        keyboard.close();
    }

    private int getIntegerFromUser(Scanner keyboard) {
        int nextInt = -1;
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal vaere et tal - prøv igen");
            keyboard.nextLine();
        }
        nextInt = keyboard.nextInt();
        return nextInt;
    }
}