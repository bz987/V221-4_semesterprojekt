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
    
    public boolean removeCostumer(){
        return true;
    }
    
    public Costumer getCostumer(String phoneNumber){  /// skal måske lige fikses
        int i = 0;
        boolean found = false;
        Costumer customerFound = null;
        while(!found && i < customers.size()){
            if(customers.containsKey(phoneNumber)){
                customerFound = customers.get(i);
                found = true;
                i++;
            }
            else{
                i++;
            }
        }
        return customerFound;
    }
    
    
    
}
