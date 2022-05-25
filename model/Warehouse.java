package model;

public class Warehouse {
    private String address;
    
    public Warehouse(String address){
        this.address = address;
    }
    
    public String getAddress(){
        return address;
    }
    
    public void setAddress(String address){
        this.address = address;
    }
}
