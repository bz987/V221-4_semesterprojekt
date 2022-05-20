package model;

public class Warehouse {
    private String address;
    
    
    private Warehouse(String address){
        this.address = address;
    }
    
    private String getAddress(){
        return address;
    }
    
    private void setAddress(){
        this.address = address;
    }
}
