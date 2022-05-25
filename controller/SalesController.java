package controller;
import model.*;

public class SalesController {
    private ProductController productController;
    private CustomerController customerController;
    private SalesContainer salesContainer;
    private Sale sale;
    private Order order;
    
    public SalesController(){
        productController = new ProductController();
        customerController = new CustomerController();
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
        } else if (order != null){
            order.addProduct(productController.findProduct(barcode));
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
    
    public boolean createOrder(String phoneNumber){
        boolean success = false;
        order = new Order(salesContainer.getAmountOfOrders(), customerController.findCustomer(phoneNumber));
        if (order.getPrice() == 0){
            success = true;
        }
        return success;
    }

    public boolean finalizeSale(){
        boolean success = false;
        salesContainer.addSale(sale);
        if (salesContainer.getMostRecentSale().getSalesNumber() == sale.getSalesNumber()){
            sale = null;
            success = true;
        }
        return success;
    }
    public boolean finalizeOrder(){
        boolean success = false;
        salesContainer.addOrder(order);
        if (salesContainer.getMostRecentOrder().getSalesNumber() == order.getSalesNumber()){
            order = null;
            success = true;
        }
        return success;
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
    public int getNumberOfOrders(){
        return salesContainer.getAmountOfOrders();
    }
}
