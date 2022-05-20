package model;

public class SalesAssistant extends Person {
    private String id;
    private int monthlySalary;
    
    private SalesAssistant(String name, String phoneNumber, String address, String id, int monthlySalary){
        super(name, phoneNumber, address);
        this.id = id;
        this.monthlySalary = monthlySalary;
    }
    
    private String getID(){
        return id;
    }
    
    private int monthlySalary(){
        return monthlySalary;
    }
    
    private void setId(){
        this.id = id;
    }
    
    private void setMonthlySalary(){
        this.monthlySalary = monthlySalary;
    }
}
