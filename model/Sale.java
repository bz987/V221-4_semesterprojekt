    package model;
import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> listOfProducts;
    private int finalPrice;
    private String date;
    private String salesNumber;
    
    public Sale(int finalPrice, String date){
        listOfProducts = new ArrayList<>();
        this.finalPrice = finalPrice;
        this.date = date;
    }
    
    public int getFinalPrice(){
        return finalPrice;
    }
    
    public String getDate(){
        return date;
    }
    
    public void setFinalPrice(int finalPrice){
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
}
