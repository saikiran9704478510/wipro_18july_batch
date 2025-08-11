package LabSession18thJuly;
//Write a program to check whether a number is divisible by 5 and 11 or not
import java.util.*;
public class Program8 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        
        if (number % 5 == 0 && number % 11 == 0) {
            System.out.println(number + " is divisible by both 5 and 11.");
        } else {
            System.out.println(number + " is NOT divisible by both 5 and 11.");
        }
    }

}
