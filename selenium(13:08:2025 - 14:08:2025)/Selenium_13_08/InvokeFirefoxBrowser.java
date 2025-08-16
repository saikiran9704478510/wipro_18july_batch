package com.wipro.JavaSelenium_13_08;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class InvokeFirefoxBrowser {
    public static void main(String[] args) {

        // Set Firefox Options (optional, for custom settings)
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addArguments("--start-maximized");

        // Setup WebDriver for Firefox using WebDriverManager
        WebDriverManager.firefoxdriver().setup();

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        // Open a website
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}


