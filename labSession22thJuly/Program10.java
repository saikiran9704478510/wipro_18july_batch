package labSession22thJuly;

//Write a method named is Even that accepts an int argument. 
//The method should return true if the argument is even, or false otherwise. 
	//	Also write a program to test your method.

import java.util.Scanner;

public class Program10 {

    
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = s.nextInt();

        
        if (isEven(num)) {
            System.out.println(num + " is even.");
        } else {
            System.out.println(num + " is odd.");
        }

    }
}

