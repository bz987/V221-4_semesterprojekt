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
    
    public boolean addProduct(String barcode, Product p){
        if(instance != null){
            products.put(barcode, p);
        }else{
            return false;
        }
        return true;
    }
    
    public Product getProduct(String barcode){
        Product product = null;
        if(products.containsKey(barcode)){
            product = products.get(barcode);
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

    public int getAmountOfProducts(){
        return products.size();
    }
}
