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

    public boolean addSalesAssistant(String phoneNumber, SalesAssistant assistant){
        if(instance != null){
            salesAssistants.put(phoneNumber, assistant);
        }else{
            return false;
        }

        return true;
    }

    public boolean removeAssistant(String phoneNumber){
        if(salesAssistants != null){
            salesAssistants.remove(phoneNumber);
        }else{
            return false;
        }
        return true;   
    }

    public SalesAssistant getAssistant(String phoneNumber){
        SalesAssistant s = null;
        if(salesAssistants.containsKey(phoneNumber)){
            s = salesAssistants.get(phoneNumber);
        }
        return s;
    }

    public SalesAssistant getAssistant(int id){
        SalesAssistant s = null;
        if(salesAssistants.containsKey(id)){
            s = salesAssistants.get(id);
        }
        return s;
    }

    
}
