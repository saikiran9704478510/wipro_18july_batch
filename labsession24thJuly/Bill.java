package labsession24thJuly;
/*
 * Billing System
Abstract class Bill:
Abstract method generateBill()
Subclasses:
ElectricityBill
WaterBill
Each subclass should implement bill generation logic.
 */

public abstract class Bill {
	String customerName;
    int accountNumber;

    Bill(String customerName, int accountNumber) {
        this.customerName = customerName;
        this.accountNumber = accountNumber;
    }

    // Abstract method
    abstract void generateBill();
	
	

}
class ElectricityBill extends Bill {
    int unitsConsumed;
    double ratePerUnit = 7.5;

    ElectricityBill(String customerName, int accountNumber, int unitsConsumed) {
        super(customerName, accountNumber);
        this.unitsConsumed = unitsConsumed;
    }

    @Override
    void generateBill() {
        double total = unitsConsumed * ratePerUnit;
        System.out.println("Electricity Bill");
        System.out.println("Customer: " + customerName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Units Consumed: " + unitsConsumed);
        System.out.println("Total Amount: ₹" + total);
        System.out.println("----------------------");
    }
}

// WaterBill class
class WaterBill extends Bill {
    int litersUsed;
    double ratePer1000Liters = 25.0;

    WaterBill(String customerName, int accountNumber, int litersUsed) {
        super(customerName, accountNumber);
        this.litersUsed = litersUsed;
    }

    @Override
    void generateBill() {
        double total = (litersUsed / 1000.0) * ratePer1000Liters;
        System.out.println("Water Bill");
        System.out.println("Customer: " + customerName);
        System.out.println("Account No: " + accountNumber);
        System.out.println("Liters Used: " + litersUsed);
        System.out.println("Total Amount: ₹" + total);
        System.out.println("----------------------");
    }
}


