package labsession24thJuly;

public class ShapeDemo {
	public static void main(String[] args) {
		Shape circle = new Circle(5.0);         
        Shape rectangle = new Rectangle(4.0, 6.0); 

        System.out.println("Area of Circle: " + circle.calculateArea());
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
	}
}
