package controller;
import model.*;
import utility.Utility;

public class CustomerController {
    private CustomerContainer customer;
    
    public CustomerController(){
        customer = CustomerContainer.getInstance(); 
    }
    
    public Customer findCustomer(String phoneNumber){
        return customer.getCustomer(phoneNumber);        
    }
    
    public boolean createCustomer(String name, String phoneNumber, String address, int discount, String group, double credit){
        Customer c = new Customer(name, phoneNumber, address, discount, group, credit);
        return customer.addCustomer(phoneNumber, c);
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
        } else { // If a new phoneNumber is found, remove the customer entry in the list and set phoneNumber to the new one.
            customer.removeCustomer(phoneNumber);
            phoneNumber = newData.getPhoneNumber();
        }
        if (newData.getAddress() == null){
            newData.setAddress(oldData.getAddress());
        }
        if (newData.getGroup() == null){
            newData.setGroup(oldData.getGroup());
        }

        // since this is only changeable by the manager, this will not change here.
        newData.setDiscount(oldData.getDiscount());
        newData.setCredit(oldData.getCredit());

        customer.addCustomer(phoneNumber, newData);
        if (customer.getCustomer(phoneNumber).equals(newData)){ // quick check to see if the phoneNumber now has the newData in the container
            updatedSuccessfully = true;
        }

        return updatedSuccessfully;
    }
    
    public boolean deleteCustomer(String phoneNumber){
        return customer.removeCustomer(phoneNumber);
    }
    
    public boolean setCustomerDiscount(String phoneNumber, int discount){
        boolean success = false;
        discount = Utility.clamp(discount, 10, 30);
        Customer c = customer.getCustomer(phoneNumber);
        c.setDiscount(discount);
        customer.addCustomer(phoneNumber, c);
        if (customer.getCustomer(phoneNumber).getDiscount() == discount){
            success = true;
        }
        return success;
    }
    
    public boolean setCustomerCredit(String phoneNumber, double amount){
        return false;
    }
    
}
