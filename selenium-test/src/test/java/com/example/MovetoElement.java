package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MovetoElement {
    public static void main(String[] args) {
        
    	try {

    		FirefoxOptions firefoxOption = new FirefoxOptions();
    		WebDriverManager.firefoxdriver().setup();  
    		
    		WebDriver driver = new FirefoxDriver(firefoxOption);

            // Open the test page
            driver.get("https://www.amazon.com");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Create Actions class instance
            Actions act = new Actions (driver);
    		
            WebElement prime = driver.findElement(By.xpath("//span[normalize-space()='Prime']"));
    		act.moveToElement(prime).perform();
    		
    		Thread.sleep(4000);
    		
    		WebElement joinnow = driver.findElement(By.xpath("//a[@href ='/prime']"));
    		act.click(joinnow).perform();
    		
    		Thread.sleep(2000);			

        }
    	catch (Exception e) {
            e.printStackTrace();
        }
    }
}


