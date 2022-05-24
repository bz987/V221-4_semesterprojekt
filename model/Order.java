package model;

public class Order extends Sale{
    private Customer customer;
    
    public Order(double finalPrice, String date, String salesNumber){
        super(finalPrice,date, salesNumber);
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    
}
