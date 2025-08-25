package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationDemo {

    public static void main(String[] args) throws InterruptedException {

        // 1. Start the driver
        FirefoxOptions opts = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(opts);

        // 2. Navigate to first URL 
        driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
        System.out.println("Page 1 title: " + driver.getTitle());
        Thread.sleep(2000);

        // 3. Navigate to second URL
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Page 2 title: " + driver.getTitle());
        Thread.sleep(2000);

        // 4. Go back to the Practice Page
        driver.navigate().back();
        System.out.println("After back -> title: " + driver.getTitle());
        Thread.sleep(2000);

        // 5. Go forward to the Login page
        driver.navigate().forward();
        System.out.println("After forward -> title: " + driver.getTitle());
        Thread.sleep(2000);

        // 6. Refresh the current page
        driver.navigate().refresh();
        System.out.println("Page refreshed.");

        // 7. Quit
        driver.quit();
    }
}