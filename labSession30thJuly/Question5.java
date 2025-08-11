package labSession30thJuly;
//find largest element from arraylist
import java.util.*;

public class Question5 {
    public static void main(String[] args) {
    	
        ArrayList<Integer> nums = new ArrayList<>();
        
        nums.add(15);
        nums.add(32);
        nums.add(8);
        nums.add(50);
        nums.add(28);
        nums.add(78);
         int max=0;
        for(int i=0;i<nums.size();i++) {
        	if(nums.get(i)>max)
        	max=nums.get(i);
        	
        }
        
        System.out.println("max elemnet is  "+max);
        
      // System.out.println(nums.get(5));
       // System.out.println(nums);

       // int max = Collections.max(nums);
      //  System.out.println( max);
    }
}
