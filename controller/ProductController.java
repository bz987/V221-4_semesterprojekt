package controller;
import model.*;
public class ProductController {
    private ProductContainer productContainer;

    public ProductController(){
        productContainer = ProductContainer.getInstance();
    }
    
    public Product findProduct(String barcode){
        return productContainer.getProduct(barcode);
    }
    
    public boolean createProduct(int id,String name, int amount,double priceCost, double retailPrice, String category, String barcode, String location, String locationAddress){
        boolean success = false;
        Product product = new Product(name, amount, priceCost, retailPrice, category, barcode, location, new Warehouse(locationAddress));
        productContainer.addProduct(barcode, product);
        if (productContainer.getProduct(barcode) != null){
            success = true;
        }
        return success;
    }
    
    public boolean updateProduct(){
        return true;
    }
    
    public boolean deleteProduct(String barcode){
        return productContainer.removeProduct(barcode);
    }

    public int getNewProductNumber(){
        return productContainer.getAmountOfProducts()+1;
    }
}
