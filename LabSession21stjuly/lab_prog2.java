package demo;

//2. Create an abstract class Employee with:

//Fields: name, id
//Abstract method calculateSalary()
//Subclasses:
//PermanentEmployee with fixed monthly salary
//ContractEmployee with hourly rate and hours worked

abstract class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    abstract double calculateSalary();
}

class PermanentEmployee extends Employee {
    double monthlySalary;

    PermanentEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    double calculateSalary() {
        return monthlySalary;
    }
}

class ContractEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    ContractEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

public class lab_prog2{
    public static void main(String[] args) {
        Employee emp1 = new PermanentEmployee("Alice", 101, 50000);
        Employee emp2 = new ContractEmployee("Bob", 102, 300, 120);

        System.out.println("Salary of " + emp1.name + ": ₹" + emp1.calculateSalary());
        System.out.println("Salary of " + emp2.name + ": ₹" + emp2.calculateSalary());
    }
}
