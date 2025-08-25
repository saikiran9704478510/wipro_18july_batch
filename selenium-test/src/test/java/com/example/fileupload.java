package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class fileupload {
    public static void main(String[] args) throws InterruptedException {

        // Firefox Options
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        // Open file upload page
        driver.get("https://the-internet.herokuapp.com/upload");

        // Maximize window
        driver.manage().window().maximize();

        // Locate file input element
        WebElement uploadInput = driver.findElement(By.id("file-upload"));

        // Provide local file path
        uploadInput.sendKeys("/Users/apple/Desktop/myFile.txt"); // Change path to your file
        Thread.sleep(2000);

        // Click upload button
        WebElement uploadButton = driver.findElement(By.id("file-submit"));
        uploadButton.click();
        Thread.sleep(2000);

        // Check upload confirmation message
        String message = driver.findElement(By.tagName("h3")).getText();
        
        if (message.contains("File Uploaded!")) {
            System.out.println("The file is uploaded successfully");
        } else {
            System.out.println("The file upload failed");
        }

        // Close browser
        driver.quit();
    }
}

