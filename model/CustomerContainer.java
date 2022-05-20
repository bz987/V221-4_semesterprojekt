package model;
import java.util.HashMap;

public class CustomerContainer {
    private HashMap<String, Costumer> customers;
    private static CustomerContainer instance;
    
    
    private CustomerContainer(){
        customers = new HashMap<>();
    }
    
    public static CustomerContainer getInstance(){
        if(instance == null){
            instance = new CustomerContainer();
        }
        return instance;
    }
    
    private boolean addCustomer(Costumer c, String phoneNumber){
        if(instance != null){
            customers.put(phoneNumber, c);
        }else{
            return false;
        }
        
        return true;
    }
    
    private Costumer getCostumer(String phoneNumber){
        return null;
    }
    
    
}
