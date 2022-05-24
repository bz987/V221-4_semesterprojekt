package model;

public class Product {
    private String name;
    private int amount;
    private int priceCost;
    private int retailPrice;
    private String category;
    private String barcode;
    private String location;

    public Product(String name, int amount,int priceCost, int retailPrice, String category, String barcode, String location){
        this.name = name;
        this.amount = amount;
        this.priceCost = priceCost;
        this.retailPrice = retailPrice;
        this.category = category;
        this.barcode = barcode;
        this.location = location;
    }
    
    public boolean isAllowance(){
        boolean allowance = false;
        if(priceCost*1.1 < retailPrice){
            allowance = true;
        }
        return allowance;
    }
    
    //getters
    public String getName(){
        return name;
    }

    public int getAmount(){
        return amount;
    }

    public int getPriceCost(){
        return priceCost;
    }

    public int getRetailPrice(){
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
    
    private void setPriceCost(int priceCost){
        this.priceCost = priceCost;
    }
    
    private void setRetailPrice(int retailPrice){
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

