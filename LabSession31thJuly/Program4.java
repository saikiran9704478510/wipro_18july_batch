package LabSession31thJuly;
// reverse the given number
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a number to reverse: ");
        int number = scanner.nextInt();

        int reversed = 0;

        while (number != 0) {
            int digit = number % 10;          // get the last digit
            reversed = reversed * 10 + digit; // add digit to reversed
            number = number / 10;             // remove last digit
        }

        System.out.println("Reversed number: " + reversed);
        scanner.close();
    }
}
