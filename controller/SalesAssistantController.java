package controller;
import model.*;

public class SalesAssistantController {
    private SalesAssistantContainer salesAssistantContainer;
    
    public SalesAssistantController(){
        salesAssistantContainer = SalesAssistantContainer.getInstance();
    }

    public SalesAssistant findAssistant(String phoneNumber){
        return salesAssistantContainer.getAssistant(phoneNumber);
    }

    public boolean createAssistant(String name, String phoneNumber, String address, String id, int monthlySalary){ 
        SalesAssistant assistant = new SalesAssistant(name, phoneNumber, address, id, monthlySalary);
        salesAssistantContainer.addSalesAssistant(phoneNumber, assistant);
        return true; // skal nok laves en ændring her
    }

    public boolean updateAssistant(){
        return false;
    }

    public boolean deleteAssistant(String phoneNumber){
        return salesAssistantContainer.removeAssistant(phoneNumber);
    }
}
