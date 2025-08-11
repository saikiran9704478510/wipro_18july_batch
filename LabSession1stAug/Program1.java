package LabSession1stAug;
//1.Write a Java program to get a list of all file/directory names in the given directory.

import java.io.File;
import java.util.Scanner;

public class Program1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

       
        File directory = new File(dirPath);

      
        if (directory.exists() && directory.isDirectory()) {
            
            String[] fileList = directory.list();

            if (fileList != null && fileList.length > 0) {
                System.out.println("\nContents of the directory:");
                for (String fileName : fileList) {
                    System.out.println(fileName);
                }
            } else {
                System.out.println("The directory is empty.");
            }
        } else {
            System.out.println("Invalid directory path.");
        }

        scanner.close();
    }
}
