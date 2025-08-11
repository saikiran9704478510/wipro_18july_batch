package labSession22thJuly;
/*
 * 8. Write a Java program to display the pattern like a right angle triangle with a number.
Test Data
Input number of rows : 10
Expected Output :
1                                                                                
12                                                                               
123                                                                              
1234                                                                             
12345                                                                            
123456                                                                           
1234567      
 

 */
import java.util.Scanner;

public class Program11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Input number of rows: ");
        int rows = scanner.nextInt();

        
        for (int i = 1; i <= rows; i++) {
          
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            
            System.out.println();
        }
    }
}