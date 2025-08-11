package labSession30thJuly;

import java.util.*;

public class Question3 {
    public static void main(String[] args) {
        
        ArrayList<Integer> n = new ArrayList<>();
        n.add(10);
        n.add(30);
        n.add(20);
        n.add(40);
        n.add(50);
        n.add(50); 

       
        Set<Integer> set = new HashSet<>(n);
        n = new ArrayList<>(set);

       Collections.sort(n);
       int secondLargest = n.get(n.size()- 2);
        System.out.println("Second-largest element is: " + secondLargest);
    }
}
