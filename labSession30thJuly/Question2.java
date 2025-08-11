package labSession30thJuly;
//Create a Arraylist and sort a list of integers

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        
        ArrayList<Integer> num = new ArrayList<>();

                num.add(45);
        num.add(10);
        num.add(30);
        num.add(5);
        num.add(90);

        System.out.println("Original List: " + num);

        
        Collections.sort(num);
        System.out.println("Sorted in Ascending Order: " + num);

       
       
    }
}
