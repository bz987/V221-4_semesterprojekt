package ui;
import controller.*;
import java.util.Scanner;

public class SalesUI {
    private SalesController salesController;
    private ProductController productController;
    private CustomerController customerController;
    private SalesAssistantController 
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
            int choice = writeLoanMenu();
            switch (choice) {
                case 1:
                    System.out.println(" Denne er ikke implementeret endnu!");
                    break;
                case 2:
                    System.out.println();
                    break;
                case 3:
                    System.out.println();
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

    private int writeLoanMenu() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("****** Salgssmenu ******");
        System.out.println(" (1) Opret salg");
        System.out.println(" (2) Opret order");
        System.out.println(" (3) Find product");
        System.out.println(" (0) Tilbage");
        System.out.print("\n Vælg:");
        int choice = getIntegerFromUser(keyboard);
        return choice;
    }

    private int getIntegerFromUser(Scanner keyboard) {
        while (!keyboard.hasNextInt()) {
            System.out.println("Input skal være et tal - prøv igen");
            keyboard.nextLine();
        }
        return keyboard.nextInt();
    }
}
