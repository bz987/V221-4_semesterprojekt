package ui;
import controller.*;
import java.util.Scanner;

public class SalesUI {
    private SalesController salesController;
    private ProductController productController;
    private CustomerController customerController;
    private SalesAssistantController SalesAssistantController;
    private String SalesAssistantPhoneNumber = "";
    /**
     * Constructor for objects of class LoanMenu
     */
    public SalesUI() {
        // initialise instance variables
        productController = new ProductController();
        salesController = new SalesController();
        customerController = new CustomerController();
        SalesAssistantController = new SalesAssistantController();
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
                    break;
                case 5:
                    printReciept();
                case 6:
                    registerSalesAssistant();
                    break;
                case 7:
                    unregisterSalesAssistant();
                    System.out.println("");
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
        System.out.println(" (5) Færdiggør kvittering");
        System.out.println(" (6) Login som salgsassistent");
        System.out.println(" (7) Log af som salgsassistent");
        System.out.println(" (0) Tilbage");
        System.out.print("\n VÃ¦lg:");
        int choice = getIntegerFromUser(keyboard);
        keyboard.close();
        return choice;
    }
    private void findProduct() {
        String barcode = writeProductBarcode();
        if (salesController.addProduct(barcode)){
            System.out.println("Added: "+productController.findProduct(barcode).getName()+" to the reciept");
        } else {
            System.out.println("Alert: Opret et salg eller en order fÃ¸rst!");
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
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv produktets lager addresse");
        String input = keyboard.nextLine();
        keyboard.close();
        return input;
    }

    private String writeProductName() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv produkt navn");
        String input = keyboard.nextLine();
        keyboard.close();
        return input;
    }
    private int writeProductAmount() {
        int returnValue = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv antal");
        returnValue = Integer.parseInt(keyboard.nextLine());
        keyboard.close();
        return returnValue;
    }
    private double writeProductCost() {
        double returnValue = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv pris");
        returnValue = Double.parseDouble(keyboard.nextLine());
        keyboard.close();
        return returnValue;
    }
    private double writeProductRetailPrice() {
        double returnValue = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv retail pris");
        returnValue = Double.parseDouble(keyboard.nextLine());
        keyboard.close();
        return returnValue;
    }
    private String writeProductCategory() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv produkt kategori");
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
    private String writeProductLocation() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv produkt placering");
        String input = keyboard.nextLine();
        keyboard.close();
        return input;
    }
    
    private void registerSalesAssistant() {
        String phoneNumber = writePhoneNumber();
        if (SalesAssistantController.findAssistant(phoneNumber) != null){
            SalesAssistantPhoneNumber = phoneNumber;
            System.out.println("Salgsassistent er blevet registreret");
        } else {
            System.out.println("Kunne ikke finde salgsassistent tilhÃ¸rende "+phoneNumber);
        }
    }
    private void unregisterSalesAssistant() {
        if (!SalesAssistantPhoneNumber.isEmpty()){
            SalesAssistantPhoneNumber = "";
            System.out.println("Fjernede den registrerede salgsassistent");
        } else {
            System.out.println("Der er ikke registreret nogen salgsassistent");
        }
    }

    private String writePhoneNumber(){
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Skriv et telefonnummer");
        String input = keyboard.nextLine();
        keyboard.close();
        return input;
    }
    private void printReciept(){
        if(salesController.finalizeSale()){
            if(!SalesAssistantPhoneNumber.isEmpty()){
                SalesAssistantController.findAssistant(SalesAssistantPhoneNumber).addSale();
                System.out.println("Salget er færdiggjort");
            }
        }
        else if(salesController.finalizeOrder()){
            if(!SalesAssistantPhoneNumber.isEmpty()){
                SalesAssistantController.findAssistant(SalesAssistantPhoneNumber).addSale();
                System.out.println("Ordren er færdiggjort");
            }
        }
        
    }

    private int getIntegerFromUser(Scanner keyboard) {
        int nextInt = -1;
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal vaere et tal - prÃ¸v igen");
            keyboard.nextLine();
        }
        nextInt = keyboard.nextInt();
        return nextInt;
    }
}
