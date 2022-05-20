package model;
import java.util.HashMap;

public class SalesAssistantContainer {
    private HashMap<String, SalesAssistant> salesAssistants;
    private static SalesAssistantContainer instance;
    
    
    private SalesAssistantContainer(){
         salesAssistants= new HashMap<>();
    }
    
    public static SalesAssistantContainer getInstance(){
        if(instance == null){
            instance = new SalesAssistantContainer();
        }
        return instance;
    }
    
    private boolean addCustomer(SalesAssistant s, String phoneNumber){
        if(instance != null){
            salesAssistants.put(phoneNumber, s);
        }else{
            return false;
        }
        
        return true;
    }
}
