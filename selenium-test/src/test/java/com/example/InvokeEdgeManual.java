package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class InvokeEdgeManual {

    public static void main(String[] args) {

        // Set path to EdgeDriver executable
        System.setProperty("webdriver.edge.driver", "/Users/apple/Downloads/edgedriver_mac64/msedgedriver");

        // Create EdgeDriver instance
        WebDriver driver = new EdgeDriver();

        // Open a webpage
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
}
