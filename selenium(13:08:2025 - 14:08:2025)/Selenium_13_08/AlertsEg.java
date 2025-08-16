package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsEg {

    public static void main(String[] args) throws InterruptedException {
        
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        // Navigate to the Alerts page
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);

        // 1. Simple JS Alert (OK only)
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]"))
              .click();
        Alert alert1 = driver.switchTo().alert();
        alert1.accept();
        Thread.sleep(3000);

        // 2. JS Confirm (OK or Cancel)
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]"))
              .click();
        Alert alert2 = driver.switchTo().alert();
        
        alert2.dismiss();  // using Cancel here

        Thread.sleep(3000);

        // 3. JS Prompt (input + OK)
        driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]"))
              .click();
        Alert alert3 = driver.switchTo().alert();
        
        alert3.sendKeys("Hello Selenium");
        alert3.accept();

        Thread.sleep(3000);

      
    }
}

