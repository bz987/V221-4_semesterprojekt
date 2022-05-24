package controller;
import model.*;
public class ProductController {
    private ProductContainer productContainer;

    public ProductController(){
        productContainer = productContainer.getInstance();
    }
    
    public Product findProduct(String barcode){
        return productContainer.getProduct(barcode);
    }
    
    public boolean createProduct(int id,String name, int amount,int priceCost, int retailPrice, String category, String barcode, String location){
        Product product = new Product(name, amount, priceCost, retailPrice, category, barcode, location);
        productContainer.addProduct(barcode, product);
        return true;
    }
    
    public boolean updateProduct(){
        return true;
    }
    
    public boolean deleteProduct(String barcode){
        return productContainer.removeProduct(barcode);
    }
}
