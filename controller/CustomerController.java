package controller;
import model.*;

public class CustomerController {
    private CustomerContainer customer;
    
    public CustomerController(){
        customer = customer.getInstance(); 
    }
    
    public Customer findCustomer(String phoneNumber){
        
    }
    
    public boolean createCustomer(String name, String phoneNumber, String address, int discount, String group, int credit, String cprNr){
        Customer c = new Customer(name, phoneNumber, address, discount, group, credit, cprNr);
        return customer.addCustomer(c, phoneNumber);
    }
    
    public boolean updateCustomer(String phoneNumber, Customer newData){
        boolean updated = false;
        Customer oldData = customer.getCustomer(phoneNumber);
        if (phoneNumber != newData.getPhoneNumber()){
            customer.removeCustomer(phoneNumber);
        }
        
        return updated;
    }
    
    public boolean deleteCustomer(String phoneNumber){
        return customer.removeCustomer(phoneNumber);
    }
    
    public boolean setCustomerDiscount(String phonenr,int discount){
        return false;
    }
    
    public boolean setCustomerCredit(String phonenr,int amount){
        return false;
    }
    
}
