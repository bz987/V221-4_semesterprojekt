package model;
import java.util.HashMap;

public class CustomerContainer {
    private HashMap<String, Customer> customers;
    private static CustomerContainer instance;
    private Customer customer;
    
    private CustomerContainer(){
        customers = new HashMap<>();
    }
    
    
    
    public static CustomerContainer getInstance(){
        if(instance == null){
            instance = new CustomerContainer();
        }
        return instance;
    }
    
    public Customer createCustomer(String name, String phoneNumber, String address, int discount, String group, int credit){
        Customer customer = new Customer(name, phoneNumber, address, discount, group, credit);
        addCustomer(customer, phoneNumber);
        return customer;
    }
    
    public boolean addCustomer(Customer c, String phoneNumber){
        boolean added = false;
        if(instance != null){
            customers.put(phoneNumber, c);
            if (customers.containsKey(phoneNumber)){
                added = true;
            }
        }
        return added;
    }
    
    public boolean removeCustomer(String phoneNumber){
        boolean removed = false;
        if(customers != null){
            customers.remove(phoneNumber);
            if (!customers.containsKey(phoneNumber)){
                removed = true;
            }
        }
        return removed; 
    }
    
    public Customer getCustomer(String phoneNumber){  
        Customer customer = null;
        if(customers.containsKey(phoneNumber)){
            customer = customers.get(phoneNumber);
        }
        return customer;
    }
    
        public int getDiscount(){
        return customer.getDiscount();
    }
}
