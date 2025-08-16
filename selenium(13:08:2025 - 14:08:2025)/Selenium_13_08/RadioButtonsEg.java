package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioButtonsEg {

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

        // Click radio button 3
        WebElement Radio3 = driver.findElement(By.xpath("//input[@value='radio3']"));
        Radio3.click();

       

    }
}

