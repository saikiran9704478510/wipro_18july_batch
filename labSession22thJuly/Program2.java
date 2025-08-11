//write a progarm to Check if a Number is Even or Odd

package labSession22thJuly;
import java.util.*;
public class Program2 {
	public static void checkEvenOdd(int number) {
        if (number % 2 == 0) {
            System.out.println("The number is Even.");
        } else {
            System.out.println("The number is Odd.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        checkEvenOdd(num);

      
    }
	

}
