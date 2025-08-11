package labsession24thJuly;

/*
 * Create an abstract class Vehicle with abstract method move().
Subclasses:
Car, Bike, Bus
Each subclass should override move() with specific output like:
Car is moving on four wheels
Bike is moving on two wheels

 */


 abstract class Veh {
	
	abstract void move();
	
	

}

class Car extends Vehicle{
	void move() {
		System.out.println("I am car , I have four wheels to move");
	}


}

class Bike extends Vehicle{
	void move() {
		System.out.println("I am Bike , I have two wheels to move");
	}


}
class Bus extends Vehicle{
	void move() {
		System.out.println("I am Bus , I have Ten wheels to move");
	}


}

public class Vehicle{
	public static void main(String[] args) {
		Bus b1=new Bus();
		b1.move();
		
		
	}
	
}
