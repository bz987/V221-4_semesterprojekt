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

    public boolean removeSale(String salesNumber){
        boolean found = false;
        int i = 0;

        while(!found && i < sales.size()){
            if(sales.get(i).getSalesNumber() == salesNumber){
                found = true;
                sales.remove(i);
            }
            else{
                i++;
            }
        }
        return found;
    }

    public Sale getMostRecentSale(){
        int i = (sales.size()-1);
        return sales.get(i);
    }
    
    public boolean addOrder(Order order){
        if(instance != null){
            orders.add(order);
        }else{
            return false;
        }

        return true;
    }
    
    public boolean removeOrder(String orderNumber){ //Look at later
        boolean found = false;
        int i = 0;

        while(!found && i < orders.size()){
            if(orders.get(i).getSalesNumber() == orderNumber){
                found = true;
                sales.remove(i);
            }
            else{
                i++;
            }
        }
        return found;
    }
    
    public Order getMostRecentOrder(){
        return null;
        int i = (orders.size()-1);
        return orders.get(i);
    }
    
    public ArrayList<Order> getOrdersFrom(String PhoneNumber){
        boolean found = false;
        int i = 0;

        while(!found && i < orders.size()){
            if(orders.get(i). == orderNumber){
                found = true;
                sales.remove(i);
            }
            else{
                i++;
            }
        }
        return null;
    }
}
