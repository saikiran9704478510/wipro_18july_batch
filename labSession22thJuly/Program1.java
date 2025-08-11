package labSession22thJuly;
//write a program to check Check if Number is Positive, Negative, or Zero
import java.util.*;
public class Program1 {
	public static void checkNumber(int number) {
        if (number > 0) {
            System.out.println("The number is Positive.");
        } else if (number < 0) {
            System.out.println("The number is Negative.");
        } else {
            System.out.println("The number is Zero.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        checkNumber(num);

       
    }

}
