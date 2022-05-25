package model;
import java.util.HashMap;

public class SalesAssistantContainer {
    private HashMap<String, SalesAssistant> salesAssistants;
    private static SalesAssistantContainer instance;

    private SalesAssistantContainer(){
        salesAssistants = new HashMap<>();
    }

    public static SalesAssistantContainer getInstance(){
        if(instance == null){
            instance = new SalesAssistantContainer();
        }
        return instance;
    }

    public boolean addSalesAssistant(SalesAssistant assistant, String phoneNumber){
        if(instance != null){
            salesAssistants.put(phoneNumber, assistant);
        }else{
            return false;
        }
        return true;
    }

    public boolean removeAssistant(String phoneNumber){
        boolean removed = false;
        if(salesAssistants != null){
            salesAssistants.remove(phoneNumber);
            if (!salesAssistants.containsKey(phoneNumber)){
                removed = true;
            }
        }
        return removed; 
    }

    public SalesAssistant getAssistant(String phoneNumber){
        SalesAssistant salesAssistant = null;
        if(salesAssistants.containsKey(phoneNumber)){
            salesAssistant = salesAssistants.get(phoneNumber);
        }
        return salesAssistant;
    }
}
