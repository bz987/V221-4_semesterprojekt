package model;
import java.util.HashMap;
import java.util.ArrayList;

public class SalesContainer {
    private ArrayList<Sale> sales;
    private ArrayList<Order> orders;
    private static SalesContainer instance;

    private SalesContainer(){
        sales = new ArrayList<>();
        orders = new ArrayList<>();
    }

    public static SalesContainer getInstance(){
        if(instance == null){
            instance = new SalesContainer();
        }
        return instance;
    }

    public boolean addSale(Sale sale){

        if(instance != null){
            sales.add(sale);
        }else{
            return false;
        }

        return true;
    }

    public boolean removeSale(){
        return true;
    }

    public Sale getMostRecentSale(){
        return null;
    }
    
    public boolean addOrder(Order order){
        if(instance != null){
            orders.add(order);
        }else{
            return false;
        }

        return true;
    }
    
    public boolean removeOrder(){
        return true;
    }
    
    public Order getMostRecentOrder(){
        return null;
    }
    
    public ArrayList<Order> getOrdersFrom(String PhoneNumber){
        return null;
    }
}
