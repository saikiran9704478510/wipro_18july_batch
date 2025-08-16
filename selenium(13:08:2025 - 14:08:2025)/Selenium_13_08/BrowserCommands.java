package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

    public static void main(String[] args) throws InterruptedException {

        // Create ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance with ChromeOptions
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Open page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);

        // Browser commands
        System.out.println("Page Title: " + driver.getTitle());       // Get page title
        System.out.println("Current URL: " + driver.getCurrentUrl()); // Get current URL

        // Minimize browser window (Java 11+)
        driver.manage().window().minimize();
        Thread.sleep(1000);

        // Full screen mode
        driver.manage().window().fullscreen();
        Thread.sleep(1000);

        // Close the current tab
        driver.close();

        // Quit the entire browser session (all windows)
        driver.quit();
    }
}

