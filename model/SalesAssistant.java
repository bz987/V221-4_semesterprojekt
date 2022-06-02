package model;

public class SalesAssistant extends Person {
    private String id;
    private int monthlySalary;
    private int amountOfSales;
    
    public SalesAssistant(String name, String phoneNumber, String address, String id, int monthlySalary){
        super(name, phoneNumber, address);
        this.id = id;
        this.monthlySalary = monthlySalary;
        this.amountOfSales = 0;
    }
    
    public String getID(){
        return id;
    }
    
    public int getMonthlySalary(){
        return monthlySalary;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public void setMonthlySalary(int monthlySalary){
        this.monthlySalary = monthlySalary;
    }
    public void addSale(){
        this.amountOfSales+=1;
    }
}
