package model;

public class Order extends Sale{
    private Costumer costomer;
    
    public void setCostumer(Costumer costumer){
        this.costomer = costomer;
    }
    
    public Costumer getCostumer(){
        return costomer;
    }
    
    
}
