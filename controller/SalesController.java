package controller;
import model.*;

public class SalesController {
    private ProductController productController;
    private SalesContainer salesContainer;
    private Sale sale;
    
    public SalesController(){
        productController = new ProductController();
        salesContainer = SalesContainer.getInstance();
    }
    
    public boolean createSale(){
        boolean success = false;
        sale = new Sale(salesContainer.getAmountOfSales()+1);
        if (sale.getPrice() == 0){
            success = true;
        }
        return success;
    }

    public boolean addProduct(String barcode){
        boolean success = false;
        if (sale != null){
            sale.addProduct(productController.findProduct(barcode));
            success = true;
        }
        return success;
    }
    
    public boolean updateSale(){
        return true;
    }
    
    public boolean deleteSale(int salesNumber){
        return salesContainer.removeSale(salesNumber);
    }
    
    public boolean createorder(Order order){
        return salesContainer.addOrder(order);
    }
    
        public boolean updateOrder(){
        return true;
    }
    
    public boolean deleteOrder(int orderNumber){
        return salesContainer.removeOrder(orderNumber);
    }

    public int getNumberOfSales(){
        return salesContainer.getAmountOfSales();
    }
}
