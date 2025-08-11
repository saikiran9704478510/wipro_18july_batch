package LabSession23rdJuly;
//write a java program to search for a element in array



import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       System.out.print("Enter the number of elements in the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        
        System.out.println("Enter " + n + " elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

       
        System.out.print("Enter the element to search: ");
        int num = sc.nextInt();

        
        boolean found = false;
        for(int i = 0; i < n; i++) {
            if(arr[i] == num) {
                System.out.println("Element " + num + " found at index " + i);
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Element " + num + " not found in the array.");
        }

        
    }
}
