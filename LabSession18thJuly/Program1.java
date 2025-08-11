package LabSession18thJuly;
/*
Write a program with a method printDetails(String name, int age, String city) that prints:
 
Name: John
Age: 22
City: Delhi
 */
public class Program1 {
	
	public static void printDetails(String name, int age, String city) {
        System.out.println( name);
        System.out.println( age);
        System.out.println( city);
    }

    
    public static void main(String[] args) {
        
        printDetails("John", 22, "Delhi");
    }

}
