package model;

public class Product {
    private String name;
    private int amount;
    private double priceCost;
    private double retailPrice;
    private String category;
    private String barcode;
    private String location;
    private Warehouse warehouse;

    public Product(String name, int amount,double priceCost, double retailPrice, String category, String barcode, String location, Warehouse warehouse){
        this.name = name;
        this.amount = amount;
        this.priceCost = priceCost;
        this.retailPrice = retailPrice;
        this.category = category;
        this.barcode = barcode;
        this.location = location;
        this.setWarehouse(warehouse);
    }
    
    
    //getters & setters
    public Warehouse getWarehouse() {
        return warehouse;
    }
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
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
    
    public String getLocation(){
        return location;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setAmount(int amount){
        this.amount = amount;
    }
    
    public void setPriceCost(double priceCost){
        this.priceCost = priceCost;
    }
    
    public void setRetailPrice(double retailPrice){
        this.retailPrice = retailPrice;
    }
    
    public void setCategory(String category){
        this.category = category;
    }
    
    public void setBarcode(String barcode){
        this.barcode = barcode;
    }
    
    public void setLocation(String location){
        this.location = location;
    }
}

