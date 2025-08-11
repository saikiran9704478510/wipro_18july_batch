package labSession22thJuly;

//Write a program to print Fibonacci series of n terms where n is input by user :
//0 1 1 2 3 5 8 13 24

import java.util.Scanner;

public class Program9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter the number of terms (n): ");
        int n = sc.nextInt();

        int first = 0, second = 1;

        System.out.print("Fibonacci Series up to " + n + " terms: ");

        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            
            int next = first + second;
            first = second;
            second = next;
        }

        
    }
}

