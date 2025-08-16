package com.wipro.JavaSelenium_13_08;

import java.util.List; // ✅ Needed for multiple elements
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultipleRadioEg {

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

        // Maximize window
        driver.manage().window().maximize();

        
        List<WebElement> radioButtons = driver.findElements(By.xpath("//input[@type='radio']"));

        System.out.println("Total radio buttons found: " + radioButtons.size());

       
        for (WebElement radio : radioButtons) {
            Thread.sleep(1000);
            radio.click();
        }

      
    }
}

