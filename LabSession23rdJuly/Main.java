package LabSession23rdJuly;


class Vehicle {
 
 public void drive() {
     System.out.println("Driving a vehicle");
 }
}

//Subclass
class Car extends Vehicle {

 public void drive() {
     System.out.println("Repairing a car");
 }
}


public class Main {
 public static void main(String[] args) {
     Vehicle myCar = new Car(); 
     myCar.drive(); 
 }
}
