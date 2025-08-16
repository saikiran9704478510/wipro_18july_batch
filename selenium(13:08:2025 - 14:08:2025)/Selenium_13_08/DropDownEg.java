package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownEg {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open the page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);

        // Locate dropdown using XPath
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown-class-example']"));

        // Create Select object
        Select select = new Select(dropdown);

        // Select each option manually
        select.selectByVisibleText("Option1");
        Thread.sleep(1000);

        select.selectByVisibleText("Option2");
        Thread.sleep(1000);

        select.selectByVisibleText("Option3");
        Thread.sleep(1000);

      
    }
}

