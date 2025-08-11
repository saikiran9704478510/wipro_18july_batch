package LabSession23rdJuly;
//reverse the array
import java.util.*;

public class Program2 {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        for(int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        System.out.println("Reversed array: " + Arrays.toString(arr));
    }
}
