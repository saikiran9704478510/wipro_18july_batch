package LabSession1stAug;

//Write a Java program to read the contents of a file into a byte array.
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Program3 {
    public static void main(String[] args) {
        
        String filePath = "C:/Files/LabSession/Program3.txt"; 

        File file = new File(filePath);

        try (FileInputStream fis = new FileInputStream(file)) {
           
            byte[] byteArray = new byte[(int) file.length()];

            
            int bytesRead = fis.read(byteArray);
            System.out.println("Bytes read: " + bytesRead);

            
            System.out.println("File contents as string:\n" + new String(byteArray));

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
