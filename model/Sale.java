package model;
import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> listOfProducts;
    private double finalPrice;
    private String date;
    private String salesNumber;
    private Product product;
    private CustomerContainer customerContainer;
    
    public Sale(String date, String salesNumber){
        listOfProducts = new ArrayList<>();
        customerContainer = customerContainer.getInstance();
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

    // public double discountCalculator(){
        // if(isAllowance() == true){
            // double discountedPrice = product.getRetailPrice()*(customerContainer.getDiscount()/100);
            // return discountedPrice;
        // }
        // else{

            // return product.getRetailPrice();
        // }
    // }

    public Product finalPriceCalc(String barcode){
        boolean found = false;
        int i = 0;
        Product product = null;
        while(!found && i < listOfProducts.size()){
            if(listOfProducts.get(i).getBarcode() == barcode){
                found = true;
                double discountedPrice = product.getRetailPrice()*(customerContainer.getDiscount()/100);
                
            }
            else{
                i++;
            }

        }
        return product;
    }
}
