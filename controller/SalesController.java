package controller;
import model.*;

public class SalesController {

    private SalesContainer salesContainer;
    
    public SalesController(){
        salesContainer = salesContainer.getInstance();
    }
    
    public boolean createSale(double finalPrice, String date, String salesNumber){
        Sale sale = new Sale(finalPrice, date, salesNumber);
        salesContainer.addSale(sale);
        return true;
    }
    
    public boolean updateSale(){
        return true;
    }
    
    public boolean deleteSale(){
        return true;
    }
    
    public boolean createorder(){
        return true;
    }
    
        public boolean updateOrder(){
        return true;
    }
    
    public boolean deleteOrder(){
        return true;
    }
}
