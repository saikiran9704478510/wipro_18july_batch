package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframe {
    public static void main(String[] args) throws InterruptedException {
        
        // Setup Firefox Driver
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();

        driver.get("https://jqueryui.com/droppable/");
        driver.manage().window().maximize();


        // Wait for the page to load
        Thread.sleep(2000);

        // Switch to iframe (the example content is inside this iframe)
        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        
        Thread.sleep(3000);


        // Locate elements inside the iframe
        WebElement drag = driver.findElement(By.id("draggable"));
        WebElement drop = driver.findElement(By.id("droppable"));

        // Perform drag and drop
        Actions actions = new Actions(driver);
        actions.dragAndDrop(drag, drop).perform();

        Thread.sleep(3000);

        // Switch back to main content
        driver.switchTo().defaultContent();

        driver.quit();
    }
}
