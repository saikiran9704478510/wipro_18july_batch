package labsession24thJuly;

public class BillMain {
	 public static void main(String[] args) {
	        Bill eb = new ElectricityBill("Ravi Kumar", 10101, 350);
	        Bill wb = new WaterBill("Ravi Kumar", 10101, 5000);

	        eb.generateBill();
	        wb.generateBill();
	    }

}
