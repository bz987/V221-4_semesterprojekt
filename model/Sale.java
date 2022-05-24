package model;
import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> listOfProducts;
    private double finalPrice;
    private String date;
    private String salesNumber;
    private Product product;
    private Customer customer;
    
    public Sale(double finalPrice, String date, String salesNumber){
        listOfProducts = new ArrayList<>();
        this.finalPrice = finalPrice;
        this.date = date;
        this.salesNumber = salesNumber;
    }
    
    public void addProduct(Product product){
        listOfProducts.add(product);
    }
    
    public double getFinalPrice(){
        return finalPrice;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setFinalPrice(double finalPrice){
        this.finalPrice = finalPrice;
    }
    
    public void setDate(String date){
        this.date = date;
    }
    
    public String getSalesNumber(){
        return salesNumber;
    }
    
    public void setSalesNumber(String salesNumber){
        this.salesNumber = salesNumber;
    }
    
    public boolean isAllowance(){
        boolean allowance = false;
        if(product.getPriceCost()*1.1 < product.getRetailPrice()){
            allowance = true;
        }
        return allowance;
    }
    
    public void discountCalculator(){
        if(isAllowance() == true){
            double discountedPrice = product.getRetailPrice()*(customer.getDiscount()/100);
            
        }
    }
}
