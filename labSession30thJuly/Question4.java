package labSession30thJuly;

import java.util.*;

public class Question4 {
    public static void main(String[] args) {
        
        LinkedList<String> l1 = new LinkedList<>();
        l1.add("Java");
        l1.add("Python");
        l1.add("C++");
        l1.add("Ruby");
        l1.add(".Not");

        
        LinkedList<String> l2 = new LinkedList<>();
        l2.add("Java");
        l2.add("Python");
        l2.add("C++");
        l2.add("GoLang");

        
        if (l1.equals(l2)) {
            System.out.println("Both LinkedLists are equal.");
        } else {
            System.out.println("LinkedLists are NOT equal.");
        }
    }
}
