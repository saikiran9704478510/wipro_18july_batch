package LabSession23rdJuly;
/*
 * 1. Write a Java program to create a class called Animal with a method called makeSound(). 
 * Create a subclass called Cat that overrides the makeSound() method to bark.
 */
public class Animal {
	public void makeSound() {
		System.out.println("we are animal , we can make sound");
	}
	
	public static void main(String[] args) {
		Dog d1 = new Dog();
		d1.makeSound();
	}

}

 class Dog extends Animal{
	 public void makeSound() {
			System.out.println("I am Dog  , I can only bark");
		}
	 
 }