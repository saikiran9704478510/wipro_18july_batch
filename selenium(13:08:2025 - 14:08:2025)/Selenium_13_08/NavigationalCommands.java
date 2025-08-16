package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationalCommands {

    public static void main(String[] args) throws InterruptedException {

        // Create ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance with ChromeOptions
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Maximize window
        driver.manage().window().maximize();

        // Open first page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/"); 
        Thread.sleep(2000);

        // Navigate to second page
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);

        // Navigate back
        driver.navigate().back();
        Thread.sleep(2000);

        // Navigate forward
        driver.navigate().forward();
        Thread.sleep(2000);

        // Refresh the page
        driver.navigate().refresh();
       

       
    }
}

