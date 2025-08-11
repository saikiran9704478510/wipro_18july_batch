package LabSession31thJuly;

import java.util.LinkedHashMap;
import java.util.Map;

public class Program2 {
    public static void main(String[] args) {
        String input = "aabccdbe";

        
        Map<Character, Integer> charCountMap = new LinkedHashMap<>();

       
        for (char ch : input.toCharArray()) {
            charCountMap.put(ch, charCountMap.getOrDefault(ch, 0) + 1);
        }

 
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First non-repeating character is: " + entry.getKey());
                return;
            }
        }

        System.out.println("No non-repeating character found.");
    }
}
