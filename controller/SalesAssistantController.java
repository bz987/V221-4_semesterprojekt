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
    
    public boolean createAssistant(){
        return true;
    }
    
    public boolean updateAssistant(){
        return true;
    }
    
    public boolean deleteAssistant(){
        return true;
    }
}
