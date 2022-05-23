package model;
import java.util.HashMap;

public class CostumerContainer {
    private HashMap<String, Costumer> costumers;
    private static CostumerContainer instance;
    
    
    private CostumerContainer(){
        costumers = new HashMap<>();
    }
    
    public static CostumerContainer getInstance(){
        if(instance == null){
            instance = new CostumerContainer();
        }
        return instance;
    }
    
    private boolean addCostumer(Costumer c, String phoneNumber){
        if(instance != null){
            costumers.put(phoneNumber, c);
        }else{
            return false;
        }
        return true;
    }
    
    public boolean removeCostumer(){
        return true;
    }
    
    public Costumer getCostumer(String phoneNumber){  /// skal måske lige fikses
        Costumer costumer = null;
        if(costumers.containsKey(phoneNumber)){
            costumer = costumers.get(phoneNumber);
        }else{
            return null;
        }
        return costumer;
    }
    
    
    
}
