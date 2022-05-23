package controller;
import model.*;

public class SalesController {

    private SalesContainer salesContainer;
    
    public SalesController(){
        salesContainer = salesContainer.getInstance();
    }
    
    public boolean createSale(){
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
