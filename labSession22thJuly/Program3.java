package labSession22thJuly;

import java.util.Scanner;

public class Program3 {

    
    public static void calculateGrade(int marks) {
        if (marks >= 90 && marks <= 100) {
            System.out.println("Grade: A");
        } else if (marks >= 75 && marks <= 89) {
            System.out.println("Grade: B");
        } else if (marks >= 60 && marks <= 74) {
            System.out.println("Grade: C");
        } else if (marks >= 40 && marks <= 59) {
            System.out.println("Grade: D");
        } else if (marks >= 0 && marks < 40) {
            System.out.println("Grade: Fail");
        } else {
            System.out.println("Invalid marks. Please enter a value between 0 and 100.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter marks (0-100): ");
        int marks = scanner.nextInt();

        
        calculateGrade(marks);

        
    }
}
