package LabSession31thJuly;
//Sort Employees by Name (Alphabetical Order)
import java.util.*;


class Employee implements Comparable<Employee> {
 
 String name;

 public Employee( String name) {
     
     this.name = name;
     
 }

 
 @Override
 public int compareTo(Employee e) {
     return this.name.compareTo(e.name);
 }

 
 @Override
 public String toString() {
     return   name ;
 }
public static void main(String[] args) {
     List<Employee> employees = new ArrayList<>();
     
    
     employees.add(new Employee( "Jyotirmay"));
     employees.add(new Employee( "Aman"));
     employees.add(new Employee( "Bobo"));
     employees.add(new Employee( "David"));

     
     Collections.sort(employees);

     
     System.out.println("Employees sorted by name:");
     for (Employee e : employees) {
         System.out.println(e);
     }
  }
}

