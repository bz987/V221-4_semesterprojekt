package ui;
import controller.*;
import java.util.Scanner;

public class SalesUI {
    private SalesController salesController;
    private ProductController productController;
    private CustomerController customerController;
    private SalesAssistantController salesAssistantController;
    /**
     * Constructor for objects of class LoanMenu
     */
    public SalesUI() {
        // initialise instance variables
        productController = new ProductController();
        salesController = new SalesController();
        customerController = new CustomerController();
        salesAssistantController = new SalesAssistantController();
    }

    public void start() {
        productMenu();
    }
    
    private void productMenu() {
        boolean running = true;
        while (running) {
            int choice = writeSaleMenu();
            switch (choice) {
                case 1:
                    createSale();
                    System.out.println(" Denne er ikke implementeret endnu!");
                    break;
                case 2:
                    createOrder();
                    System.out.println();
                    break;
                case 3:
                    createProduct();
                    break;
                case 4:
                    findProduct();
                    System.out.println(" Denne er ikke implementeret endnu!");
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

    

    private int writeSaleMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Salgssmenu ******");
        System.out.println(" (1) Opret salg");
        System.out.println(" (2) Opret order");
        System.out.println(" (3) Opret produkt");
        System.out.println(" (4) Find product");
        System.out.println(" (0) Tilbage");
        System.out.print("\n V�lg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }
    private void findProduct() {
    }

    private void createOrder() {
    }

    private void createSale() {
    }
    private void createProduct() {
        String productName = writeProductName();
        int amount = writeProductAmount();
        double priceCost = writeProductCost();
        double retailPrice = writeProductRetailPrice();
        String category = writeProductCategory();
        String barcode = writeProductBarcode();
        String location = writeProductLocation();
        String warehouseAddress = writeWarehouseAddress();
        productController.createProduct(productController.getNewProductNumber(), productName,amount,priceCost,retailPrice,category,barcode,location,warehouseAddress);
    
    }
    private String writeWarehouseAddress() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv produktets lager addresse");
            return keyboard.nextLine();
        }
    }

    private String writeProductName() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv produkt navn");
            return keyboard.nextLine();
        }
    }
    private int writeProductAmount() {
        int returnValue = 0;
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv antal");
            returnValue = Integer.parseInt(keyboard.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    private double writeProductCost() {
        double returnValue = 0;
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv pris");
            returnValue = Double.parseDouble(keyboard.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    private double writeProductRetailPrice() {
        double returnValue = 0;
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv retail pris");
            returnValue = Double.parseDouble(keyboard.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return returnValue;
    }
    private String writeProductCategory() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv produkt kategori");
            return keyboard.nextLine();
        }
    }
    private String writeProductBarcode() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv produkt barcode");
            return keyboard.nextLine();
        }
    }
    private String writeProductLocation() {
        try (Scanner keyboard = new Scanner(System.in)) {
            System.out.println("Skriv produkt placering");
            return keyboard.nextLine();
        }
    }
    
    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal vaere et tal - proev igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}
