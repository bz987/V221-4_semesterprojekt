package controller;
import model.*;

public class SalesController {

    private SalesContainer salesContainer;
    
    public SalesController(){
        salesContainer = salesContainer.getInstance();
    }
    
    public boolean createSale(String date, String salesNumber){
        Sale sale = new Sale(date, salesNumber);
        salesContainer.addSale(sale);
        return true;
    }
    
    public boolean updateSale(){
        return true;
    }
    
    public boolean deleteSale(String salesNumber){
        return salesContainer.removeSale(salesNumber);
    }
    
    public boolean createorder(Order order){
        return salesContainer.addOrder(order);
    }
    
        public boolean updateOrder(){
        return true;
    }
    
    public boolean deleteOrder(String orderNumber){
        return salesContainer.removeOrder(orderNumber);
    }
}
