package model;

public class Order extends Sale{
    private Costumer costomer;
    
    private Order(int finalPrice, String date){
        super(finalPrice,date);
    }
    
    public void setCostumer(Costumer costumer){
        this.costomer = costomer;
    }
    
    public Costumer getCostumer(){
        return costomer;
    }
    
    
}
