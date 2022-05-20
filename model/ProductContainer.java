package model;
import java.util.HashMap;

public class ProductContainer {
    private HashMap<String, Product> products;
    private static ProductContainer instance;
    
    
    private ProductContainer(){
        products = new HashMap<>();
    }
    
    public static ProductContainer getInstance(){
        if(instance == null){
            instance = new ProductContainer();
        }
        return instance;
    }
    
    private boolean addCustomer(String id, Product p){
        if(instance != null){
            products.put(id, p);
        }else{
            return false;
        }
        
        return true;
    }
    
    private Costumer getCostumer(String phoneNumber){
        return null;
    }
    
}
