package labSession30thJuly;
//1.Create a set  and  find Duplicate Elements in set
import java.util.*;

public class Question1 {
    public static void main(String[] args) {
   
        List<String> l = new ArrayList<>();
        l.add("Ram");
        l.add("shyam");
        l.add("Shivam");
        l.add("Seema");
        l.add("Ram");
        

        Set<String> s1 = new HashSet<>();
        Set<String> s2 = new HashSet<>();

        for (String name : l) {
           
            if (!s1.add(name)) {
                s2.add(name);
            }
        }

        System.out.println("Unique Elements: " + s1);     
        System.out.println("Duplicate Elements: " + s2); 
    }
}
