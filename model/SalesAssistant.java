package model;

public class SalesAssistant extends Person {
    private String id;
    private int monthlySalary;
    
    public SalesAssistant(String name, String phoneNumber, String address, String id, int monthlySalary){
        super(name, phoneNumber, address);
        this.id = id;
        this.monthlySalary = monthlySalary;
    }
    
    public String getID(){
        return id;
    }
    
    public int getMonthlySalary(){
        return monthlySalary;
    }
    
    public void setId(){
        this.id = id;
    }
    
    public void setMonthlySalary(){
        this.monthlySalary = monthlySalary;
    }
}
