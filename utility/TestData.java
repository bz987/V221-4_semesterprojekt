package utility;

import controller.CustomerController;
import controller.ProductController;
import model.Order;
import model.SalesContainer;

public class TestData {
    public static void generate(){
        ProductController pCtrl = new ProductController();
        CustomerController cCtrl = new CustomerController();
        SalesContainer sCon = SalesContainer.getInstance();

        pCtrl.createProduct("Krydsfiner byggeplade", 40, 600, 800, "Træprodukter", "0001", "O-3, H-40", "Kapgeringsale 69, Aalborg");
        pCtrl.createProduct("Petrolium", 60, 150, 300, "Brandstof", "0002", "O-2, H-1", "Kapgeringsale 69, Aalborg");
        pCtrl.createProduct("Spånplader", 20, 200, 375, "Træprodukter", "0003", "O-3, H-39", "Kapgeringsale 69, Aalborg");

        cCtrl.createCustomer("Brian", "42042069", "N/A", -30, "Privatkunde", 2000);
        cCtrl.createCustomer("Tom", "00000001", "Borgergade 1, Alstrup", 30, "Erhvervskunde", 300000);
        cCtrl.createCustomer("Connie", "80081351", "Achmed ale 30, Holmerolstrup", 10, "Privatkunde", 20000);
        
        sCon.addOrder(new Order(0,cCtrl.findCustomer("42042069")));
    }
}
