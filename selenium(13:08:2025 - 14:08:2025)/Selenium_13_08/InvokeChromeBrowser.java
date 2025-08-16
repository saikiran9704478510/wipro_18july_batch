package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeChromeBrowser {

    public static void main(String[] args) {

        // Create ChromeOptions instance for customization
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); // optional: start maximized

        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create ChromeDriver instance with ChromeOptions
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open OrangeHRM login page
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // You can add more steps here if needed, like validations or closing the browser
    }
}


