package model;

public class Order extends Sale{
    private Customer customer;
    
    private Order(int finalPrice, String date){
        super(finalPrice,date);
    }
    
    public void setCustomer(Customer customer){
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    
}
