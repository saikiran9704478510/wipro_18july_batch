package demo;

	abstract class Bill {
	    abstract void generateBill();
	}

	class ElectricityBill extends Bill {
	    double units;

	    ElectricityBill(double units) {
	        this.units = units;
	    }

	    void generateBill() {
	        double cost = units * 7.5; // rate per unit
	        System.out.println("Electricity Bill: ₹" + cost);
	    }
	}

	class WaterBill extends Bill {
	    double liters;

	    WaterBill(double liters) {
	        this.liters = liters;
	    }

	    void generateBill() {
	        double cost = liters * 2.0; // rate per liter
	        System.out.println("Water Bill: ₹" + cost);
	    }
	}

	public class lab_prog5 {
	    public static void main(String[] args) {
	        Bill eb = new ElectricityBill(150);
	        Bill wb = new WaterBill(300);

	        eb.generateBill();
	        wb.generateBill();
	    }

}
