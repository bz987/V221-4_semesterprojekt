package model;
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

    public boolean removeSale(int salesNumber){
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
        }
        return true;
    }

    public boolean removeOrder(int orderNumber){ //Look at later
        boolean found = false;
        int i = 0;

        while(!found && i < orders.size()){
            if(orders.get(i).getSalesNumber() == orderNumber){
                found = true;
                orders.remove(i);
            }
            else{
                i++;
            }
        }
        return found;
    }

    public Order getMostRecentOrder(){
        int i = (orders.size()-1);
        return orders.get(i);
    }

    public ArrayList<Order> getOrdersFrom(String phoneNumber, Order order){ // burde virke
        ArrayList<Order> list = new ArrayList<>();

        if(order.getCustomer().getPhoneNumber() == phoneNumber){
            list.add(order);
        }

        return list;
    }

    public int getAmountOfSales(){
        return sales.size();
    }
    public int getAmountOfOrders(){
        return orders.size();
    }
}
