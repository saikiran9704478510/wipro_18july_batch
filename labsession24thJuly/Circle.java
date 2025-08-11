package labsession24thJuly;

public class Circle extends Shape {
	private double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Override method
    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

}
