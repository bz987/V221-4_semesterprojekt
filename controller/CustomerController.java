package controller;
import model.*;

public class CustomerController {
    private CustomerContainer customer;
    
    public CustomerController(){
        customer = customer.getInstance(); 
    }
    
    public Customer findCustomer(String phoneNumber){
        return customer.getCustomer(phoneNumber);        
    }
    
    public boolean createCustomer(String name, String phoneNumber, String address, int discount, String group, int credit, String cprNr){
        Customer c = new Customer(name, phoneNumber, address, discount, group, credit, cprNr);
        return customer.addCustomer(c, phoneNumber);
    }
    
    public boolean updateCustomer(String phoneNumber, Customer newData){
        boolean updatedSuccessfully = false;
        Customer oldData = customer.getCustomer(phoneNumber);

        // From here it check all variables and sees if there is a new value to be added or if we can use info from the old data.
        if (newData.getName() == null){
            newData.setName(oldData.getName());
        }
        if (newData.getPhoneNumber() == null){
            newData.setPhoneNumber(oldData.getPhoneNumber());
        } else { // If a new phoneNr is found, remove the customer entry in the list and set phoneNr to the new one.
            customer.removeCustomer(phoneNumber);
            phoneNumber = newData.getPhoneNumber();
        }
        if (newData.getAddress() == null){
            newData.setAddress(oldData.getAddress());
        }
        if (newData.getGroup() == null){
            newData.setGroup(oldData.getGroup());
        }
        if (newData.getCprNr() == null){
            newData.setCprNr(oldData.getCprNr());
        }

         // since this is only changeable by the manager, this will not change here.
        newData.setDiscount(oldData.getDiscount());
        newData.setCredit(oldData.getCredit());

        customer.addCustomer(newData, phoneNumber);
        if (customer.getCustomer(phoneNumber).equals(newData)){ // quick check to see if the phoneNr now has the newData in the container
            updatedSuccessfully = true;
        }

        return updatedSuccessfully;
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
