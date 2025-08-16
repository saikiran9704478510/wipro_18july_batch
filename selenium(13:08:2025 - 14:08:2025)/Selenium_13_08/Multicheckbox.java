package com.wipro.JavaSelenium_13_08;

import java.util.List; // ✅ Correct List import

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multicheckbox {

    public static void main(String[] args) throws InterruptedException {

        // Create ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance with ChromeOptions
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Wait for elements to load
        Thread.sleep(2000);

        // Maximize the window
        driver.manage().window().maximize();

        // ✅ Use findElements to get all checkboxes
        List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));

        int size = chkboxes.size();
        
        System.out.println(size);
        
        for (int i=0;i<size;i++)
        {
        	Thread.sleep(1000);
        	chkboxes.get(i).click();
        }
   
        
    }}
      
        // Loop to click all checkboxes


