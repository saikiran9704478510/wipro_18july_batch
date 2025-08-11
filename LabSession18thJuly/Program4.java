package LabSession18thJuly;
//Write a Program to Swap Two Variables Using a Third Variable
import java.util.*;


public class Program4 {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter first number (a): ");
        int a = sc.nextInt();
        System.out.print("Enter second number (b): ");
        int b = sc.nextInt();

        System.out.println("Before Swapping: a = " + a + ", b = " + b);

        
        int temp = a;
        a = b;
        b = temp;

     
        System.out.println("After Swapping: a = " + a + ", b = " + b);
    }

}
