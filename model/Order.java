package model;

public class Order extends Sale{
    private Customer customer;
    
    public Order(int salesNumber, Customer customer){
        super(salesNumber);
        this.customer = customer;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public double discountCalculator(){
        double calculatedDiscount = 0;
        if(isAllowance() == true){
            //double discountedPrice = product.getRetailPrice()*(customerController.fin()/100);
            //calculatedDiscount = discountedPrice;
        }
        return calculatedDiscount;
    }
    
    public boolean isAllowance(){
        boolean allowance = false;
        // if(product.getPriceCost()*1.1 < product.getRetailPrice()){
        //     allowance = true;
        // }
        return allowance;
    }
}
