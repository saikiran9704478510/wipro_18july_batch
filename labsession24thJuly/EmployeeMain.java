package labsession24thJuly;

public class EmployeeMain {
	public static void main(String[] args) {
		ContractEmployee c=new ContractEmployee();
		String name = c.name;
		System.out.println(name);
		c.calculateSalary();
		
		
		PermanentEmployee p =new PermanentEmployee ();
		String name1 = p.name;
		System.out.println(name1);
		p.calculateSalary();
		
	}

}
