package controller;
import model.*;

public class SalesAssistantController {
    private SalesContainer salesContainer;

    public SalesAssistantController(){
        salesContainer = SalesContainer.getInstance();
    }
    
    public SalesAssistant findAssistant(){
        return null;
    }
    
    public boolean createAssistant(String name, String phoneNumber, String address, String id, int monthlySalary){
        SalesAssistant assistant = new SalesAssistant(name, phoneNumber, address, id, monthlySalary);
        salesContainer.addSalesAssistant(assistant);
    }
    
    public boolean updateAssistant(){
        return true;
    }
    
    public boolean deleteAssistant(){
        return true;
    }
}
