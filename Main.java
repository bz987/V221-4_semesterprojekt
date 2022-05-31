import java.util.Scanner;

import ui.ManagerUI;
import ui.SalesUI;
import ui.State;
import ui.WarehouseUI;

public class Main {
    public static void main(String[] args) {
        State STATE = State.FRONTPAGE;
        SalesUI sUI = new SalesUI();
        ManagerUI mUI = new ManagerUI();
        WarehouseUI wUI = new WarehouseUI();
        boolean running = true;

        while (running){
            switch (STATE) {
                case MANAGER:
                    mUI.start();
                    break;
                case ASSISTANT:
                    sUI.start();
                    break;
                case WAREHOUSE:
                    System.out.println("Offline");
                    break;
                case FRONTPAGE:
                    int choice = -1;
                    Scanner keyboard = new Scanner(System.in);
                    
                    System.out.println("======== Vælg en afdeling ========");
                    System.out.println(" (1) Manager UI");
                    System.out.println(" (2) Salgs UI");
                    System.out.println(" (3) Lager UI");
                    System.out.println(" (0) Sluk");
                    System.out.println("==============================");
                    System.out.print("Valg: ");

                    if (keyboard.hasNextInt()){
                        choice = keyboard.nextInt();
                    } else {
                        System.out.println("Info: Please enter a number!");
                    }
                    keyboard.close();

                    switch (choice) {
                        case 1:
                            STATE = State.MANAGER;
                            break;
                        case 2:
                            STATE = State.ASSISTANT;
                            break;
                        case 3:
                            STATE = State.WAREHOUSE;
                            break;
                        case 0:
                            running = false;
                            break;
                        default:
                            System.out.println("Error: wrong input!");
                            break;
                    }
                    break;
                case STOP:
                    running = false;
                    break;
            }
        }
    }
}
