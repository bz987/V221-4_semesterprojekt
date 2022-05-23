package model;
import java.util.HashMap;

public class CustomerContainer {
    private HashMap<String, Customer> customers;
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
    
    private boolean addCustomer(Customer c, String phoneNumber){
        if(instance != null){
            customers.put(phoneNumber, c);
        }else{
            return false;
        }
        return true;
    }
    
    public boolean removeCustomer(){
        return true;
    }
    
    public Customer getCustomer(String phoneNumber){  /// skal måske lige fikses
        Customer customer = null;
        if(customers.containsKey(phoneNumber)){
            customer = customers.get(phoneNumber);
        }else{
            return null;
        }
        return customer;
    }
    
    
    
}
