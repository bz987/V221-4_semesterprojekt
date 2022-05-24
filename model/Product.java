package model;

public class Product {
    private String name;
    private int amount;
    private double priceCost;
    private double retailPrice;
    private String category;
    private String barcode;
    private String location;

    public Product(String name, int amount,double priceCost, double retailPrice, String category, String barcode, String location){
        this.name = name;
        this.amount = amount;
        this.priceCost = priceCost;
        this.retailPrice = retailPrice;
        this.category = category;
        this.barcode = barcode;
        this.location = location;
    }
    
    
    //getters
    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public double getPriceCost(){
        return priceCost;
    }

    public double getRetailPrice(){
        return retailPrice;
    }

    public String getCategory(){
        return category;
    }
    
    public String getBarcode(){
        return barcode;
    }
    
    private String getLocation(){
        return location;
    }
    
    private void setName(String name){
        this.name = name;
    }
    
    private void setAmount(int amount){
        this.amount = amount;
    }
    
    private void setPriceCost(double priceCost){
        this.priceCost = priceCost;
    }
    
    private void setRetailPrice(double retailPrice){
        this.retailPrice = retailPrice;
    }
    
    private void setCategory(String category){
        this.category = category;
    }
    
    private void setBarcode(String barcode){
        this.barcode = barcode;
    }
    
    private void setLocation(String location){
        this.location = location;
    }
}

