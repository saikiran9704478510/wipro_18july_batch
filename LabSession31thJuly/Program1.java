package LabSession31thJuly;

public class Program1 {
    public static void main(String[] args) {
        
    	String input = "a2b3c4";
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < input.length(); i += 2) {
            char ch = input.charAt(i);         
            int count = Character.getNumericValue(input.charAt(i + 1)); 

           
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }

       
        System.out.println(result.toString()); 
    }
}
