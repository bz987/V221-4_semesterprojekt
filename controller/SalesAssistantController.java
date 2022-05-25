package controller;
import model.*;

public class SalesAssistantController {
    private SalesAssistantContainer salesAssistantContainer;

    public SalesAssistantController(){
        salesAssistantContainer = SalesAssistantContainer.getInstance();
    }

    public SalesAssistant findAssistant(String phoneNumber){
        return salesAssistantContainer.getAssistant(phoneNumber);
    }

    public boolean createAssistant(String name, String phoneNumber, String address, String id, int monthlySalary){ 
        SalesAssistant assistant = new SalesAssistant(name, phoneNumber, address, id, monthlySalary);
        salesAssistantContainer.addSalesAssistant(assistant, phoneNumber);
        return true; // skal nok laves en aendring her
    }

    public boolean updateAssistant(String phoneNumber, SalesAssistant newData){
        boolean updatedSuccessfully = false;
        SalesAssistant oldData = salesAssistantContainer.getAssistant(phoneNumber);

        // From here it check all variables and sees if there is a new value to be added or if we can use info from the old data.
        if (newData.getName() == null){
            newData.setName(oldData.getName());
        }
        if (newData.getPhoneNumber() == null){
            newData.setPhoneNumber(oldData.getPhoneNumber());
        } else { // If a new phoneNr is found, remove the customer entry in the list and set phoneNr to the new one.
            salesAssistantContainer.removeAssistant(phoneNumber);
            phoneNumber = newData.getPhoneNumber();
        }
        if (newData.getAddress() == null){
            newData.setAddress(oldData.getAddress());
        }
        if (newData.getMonthlySalary() == 0){ 
            newData.setMonthlySalary(oldData.getMonthlySalary());
        }

        salesAssistantContainer.addSalesAssistant(newData, phoneNumber);
        if (salesAssistantContainer.getAssistant(phoneNumber).equals(newData)){ // quick check to see if the phoneNr now has the newData in the container
            updatedSuccessfully = true;
        }

        return updatedSuccessfully;
    }

    public boolean deleteAssistant(String phoneNumber){
        return salesAssistantContainer.removeAssistant(phoneNumber);
    }
}
