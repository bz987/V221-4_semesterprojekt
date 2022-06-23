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

    @Override
    public void calcFinalPrice(){
        double price = 0;
        for (Product p : listOfProducts) {
            price += p.getRetailPrice()*calcDiscount(p);
        }
        finalPrice = price;
    }
    
    public double calcDiscount(Product p){
        double calculatedDiscount = 0;
        if (p.getPriceCost()*1.2 < p.getRetailPrice()*(1-(customer.getDiscount()/100))){
            calculatedDiscount = 1-(customer.getDiscount()/100);
        }
        return calculatedDiscount;
    }
}
