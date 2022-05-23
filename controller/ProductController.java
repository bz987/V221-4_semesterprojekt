package controller;
import model.*;
public class ProductController {
    private ProductContainer productContainer;

    public ProductController(){
        productContainer = productContainer.getInstance();
    }
    
    public Product findProduct(){
        return null;
        
        
    }
    
    public boolean createProduct(){
        return true;
    }
    
    public boolean updateProduct(){
        return true;
    }
    
    public boolean deleteProduct(){
        return true;
    }
}
