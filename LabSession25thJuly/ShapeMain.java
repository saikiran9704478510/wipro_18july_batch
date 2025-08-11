package LabSession25thJuly;

public class ShapeMain {
	 public static void main(String[] args) {
	        Shape rect = new Rectangle(10, 5);
	        Shape circle = new Circle(7);
	        Shape triangle = new Triangle(8, 4);

	        System.out.println("Area of Rectangle: " + rect.getArea());
	        System.out.println("Area of Circle: " + circle.getArea());
	        System.out.println("Area of Triangle: " + triangle.getArea());
	    }

}
