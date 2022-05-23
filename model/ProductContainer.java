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
    
    public boolean addProduct(String id, Product p){
        if(instance != null){
            products.put(id, p);
        }else{
            return false;
        }
        
        return true;
    }
    
    public Product getProduct(String phoneNumber){
        Product product = null;
        if(products.containsKey(phoneNumber)){
            product = products.get(phoneNumber);
        }else{
            return null;
        }
        return product;
    }
    
    public boolean removeProduct(String barcode){
        if(products != null){
            products.remove(barcode);
        }else{
            return false;
        }
        return true; 
    }
}
