package controller;
import model.*;

public class CustomerController {
    private CustomerContainer customer;
    
    public CustomerController(){
        customer = customer.getInstance(); 
    }
    
    public Customer findCustomer(String phoneNumber){
        Customer custom = customer.getCustomer(phoneNumber);
        return custom;
    }
    
    public boolean createCustomer(Customer c, String phoneNumber){
        boolean isAdded = customer.addCustomer(c, phoneNumber);
        return isAdded;
    }
    
    public boolean updateCustomer(){
        return false;
    }
    
    public boolean deleteCustomer(String cprNr){
        boolean isRemoved = customer.removeCustomer(cprNr);
        return isRemoved;
    }
    
    public boolean setCustomerDiscount(String phonenr,int discount){
        return false;
    }
    
    public boolean setCustomerCredit(String phonenr,int amount){
        return false;
    }
    
}
