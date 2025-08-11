package LabSession23rdJuly;


class Shape {
 
 public double getArea() {
     return 0; 
 }
}


class Rectangle extends Shape {
 private double length;
 private double width;

 // Constructor
 public Rectangle(double length, double width) {
     this.length = length;
     this.width = width;
 }

 // Overriding the getArea() method
 @Override
 public double getArea() {
     return length * width;
 }
}

//Main class to test
public class Math {
 public static void main(String[] args) {
     Rectangle rect = new Rectangle(5.0, 4.0);
     System.out.println("Area of Rectangle: " + rect.getArea());
 }
}
