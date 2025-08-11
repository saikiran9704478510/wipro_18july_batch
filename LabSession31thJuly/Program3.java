package LabSession31thJuly;
//print 1 to 100 without using any loop
public class Program3 {
    public static void main(String[] args) {
        printNumbers(1);  
    }

    // Recursive method
    public static void printNumbers(int num) {
        if (num > 100) {
            return;
        }

        System.out.print(num+" ");
        printNumbers(num + 1);  // Recursive call
    }
}
