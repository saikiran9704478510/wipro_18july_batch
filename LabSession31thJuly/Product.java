package LabSession31thJuly;
//Sort Products by Price then Name (Multiple Fields)

public class Product {
	String Pname;
	int Price;
	
	
	Product(String Pname,int Price){
		this.Pname=Pname;
		this.Price= Price;
	}
	
	public String toString() {
		 return Pname +" : "+Price;
	 }

}
