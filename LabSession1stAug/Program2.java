package LabSession1stAug;

import java.util.Scanner;

public class Program2 {
	public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter a byte value: ");
        byte b = scanner.nextByte();

        
        System.out.print("Enter a short value: ");
        short s = scanner.nextShort();

        
        System.out.print("Enter an int value: ");
        int i = scanner.nextInt();

        
        System.out.print("Enter a long value: ");
        long l = scanner.nextLong();

       
        System.out.print("Enter a float value: ");
        float f = scanner.nextFloat();

       
        System.out.print("Enter a double value: ");
        double d = scanner.nextDouble();

       
        System.out.print("Enter a char value: ");
        char c = scanner.next().charAt(0);

       
        System.out.print("Enter a boolean value (true/false): ");
        boolean bool = scanner.nextBoolean();

     
        System.out.println("\n--- You entered ---");
        System.out.println("byte: " + b);
        System.out.println("short: " + s);
        System.out.println("int: " + i);
        System.out.println("long: " + l);
        System.out.println("float: " + f);
        System.out.println("double: " + d);
        System.out.println("char: " + c);
        System.out.println("boolean: " + bool);

       
	}

}
