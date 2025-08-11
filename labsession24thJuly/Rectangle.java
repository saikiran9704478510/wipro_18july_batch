package labsession24thJuly;

public class Rectangle extends Shape {
	private double length;
    private double width;

    // Constructor
    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Override method
    @Override
    double calculateArea() {
        return length * width;
    }
	

}
