package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {
    public static void main(String[] args) {
        try {

    		FirefoxOptions firefoxOption = new FirefoxOptions();
    		WebDriverManager.firefoxdriver().setup();  
    		
    		WebDriver driver = new FirefoxDriver(firefoxOption);

            // Open the test page
            driver.get("https://the-internet.herokuapp.com/drag_and_drop");

            // Maximize the browser window
            driver.manage().window().maximize();

            // Create Actions class instance
            Actions act = new Actions(driver);

            // Locate source and target elements
            WebElement from = driver.findElement(By.id("column-a"));
            WebElement to = driver.findElement(By.id("column-b"));

            // Perform drag and drop
            act.dragAndDrop(from, to).perform();

            // Pause to observe the result
            Thread.sleep(2000);

            // Close browser
            driver.quit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

