package com.wipro.JavaSelenium_14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardsEvent {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();

            // Open Facebook
            driver.get("https://www.facebook.com/");
            Thread.sleep(2000);

           
            Actions act = new Actions(driver);

            // Find Email field and type in uppercase using SHIFT key
            WebElement email = driver.findElement(By.id("email"));
            act.moveToElement(email)
                    .click() // ensure focus is in email field
                    .keyDown(Keys.SHIFT)
                    .sendKeys("hello")
                    .keyUp(Keys.SHIFT)
                    .build()
                    .perform();

            Thread.sleep(2000);

            // Find Password field and type "hi"
            WebElement password = driver.findElement(By.id("pass"));
            act.moveToElement(password) .click() 
                    .sendKeys("hi")
                    .build()
                    .perform();

            Thread.sleep(2000);

            System.out.println(" Email contains HELLO and password contains hi!");

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
                driver.quit();
                System.out.println(" Browser closed.");
            
        }
    }
}
