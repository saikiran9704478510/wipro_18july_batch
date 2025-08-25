package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

    public static void main(String[] args) throws InterruptedException {

        FirefoxOptions opts = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(opts);

        driver.manage().window().maximize();          // full-screen

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        String Title = driver.getTitle();
        System.out.println(Title);
        
        String pagesource = driver.getPageSource();
        System.out.println(pagesource);
        
        String url = driver.getCurrentUrl();
        System.out.println(url);
       
        driver.close();     // closes current tab/window
        // driver.quit();   // closes *all* windows and ends the session
    }
}
