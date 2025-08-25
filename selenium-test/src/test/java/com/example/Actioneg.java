package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Actioneg {
    public static void main(String[] args) throws Exception {
        
        // Setup Firefox driver
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        Actions act = new Actions(driver);

        // Double click example
        WebElement sell = driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
        act.doubleClick(sell).perform();
        
        Thread.sleep(4000);

        driver.navigate().back();
        Thread.sleep(4000);

        // Right click (context click) example
        WebElement mobiles = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
        act.contextClick(mobiles).perform();

        Thread.sleep(4000);

        driver.quit();
    }
}
