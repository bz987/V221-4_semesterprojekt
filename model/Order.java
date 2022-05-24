package model;

public class Order extends Sale{
    private Customer customer;
    
    public Order( String date, String salesNumber){
        super(date, salesNumber);
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    
}
