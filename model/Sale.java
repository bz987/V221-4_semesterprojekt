package model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> listOfProducts;
    private double finalPrice;
    private String date;
    private int salesNumber;

    public Sale(int salesNumber){
        listOfProducts = new ArrayList<>();
        this.date = LocalDate.now().toString();
        this.finalPrice = 0;
    }

    public void addProduct(Product product){
        listOfProducts.add(product);
        calcFinalPrice();
    }

    public void calcFinalPrice(){
        long finalPrice = 0;
        for (Product p : listOfProducts) {
            finalPrice += p.getRetailPrice();
        }
        this.finalPrice = finalPrice;
    }

    public int getSalesNumber(){
        return salesNumber;
    }
    public String getDate(){
        return date;
    }
    public double getPrice(){
        return finalPrice;
    }
    public int amountOfProducts(){
        return listOfProducts.size();
    }
}
