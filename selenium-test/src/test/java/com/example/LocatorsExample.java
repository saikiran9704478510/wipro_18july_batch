package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsExample {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver (replace with FirefoxDriver or EdgeDriver if needed)
		FirefoxOptions firefoxOption = new FirefoxOptions();
		WebDriverManager.firefoxdriver().setup();  
		
		WebDriver driver = new FirefoxDriver(firefoxOption);

        // Open the login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // wait for page to load
        Thread.sleep(2000);

        // enter text in username field
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        Thread.sleep(2000);

        // enter text in password field
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        Thread.sleep(2000);

        // click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        // wait to observe result
        Thread.sleep(5000);

        // close browser
        driver.quit();
    }
}

