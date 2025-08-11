package LabSession31thJuly;
import java.util.ArrayList;
import java.util.Collections;
//Sort Products by Price then Name (Multiple Fields)
import java.util.Comparator;
import java.util.List;


public class ComparatorProduct implements Comparator<Product> {

	@Override
	public int compare(Product o1, Product o2) {
		// TODO Auto-generated method stub
		return o1.Pname.compareTo(o2.Pname);// sorting by name 
		//return o1.Price - o2.Price;//sorting by price
    }
	
	
	
	 

	public static void main(String[] args) {
		List<Product> students = new ArrayList<>();
		students.add(new Product("Fruit",1000));
		students.add(new Product("Tea",2000));
		students.add(new Product("KetchUp",300));
		Collections.sort(students,new ComparatorProduct());
		
		for(Product s: students) {
			System.out.println(s);
	}

}
}
