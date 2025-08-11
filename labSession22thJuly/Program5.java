//write a program to print sum of first N natural numbers


package labSession22thJuly;
import java.util.*;
public class Program5 {
	public static void main(String[] args) {
		int i=1;
		int s=0;
		int num=0;
		Scanner sc= new Scanner(System.in);
		
	
		System.out.println("enter no ");
		num=sc.nextInt();
		
		
		while(i<=num) {
			s=s+i;
			i++;
		}
		
		System.out.println("sum of natural no is = "+ s);
	}
	

}
