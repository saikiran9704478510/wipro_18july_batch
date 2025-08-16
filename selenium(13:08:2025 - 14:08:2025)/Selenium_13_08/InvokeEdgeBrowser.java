package com.wipro.JavaSelenium_13_08;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class InvokeEdgeBrowser {
    public static void main(String[] args) {
    	
    	//Manually download the driver from and copy the path and paste 
    	System.setProperty("webdriver.edge.driver", "C://Users//HP//Downloads//edgedriver_win64//msedgedriver.exe");
        // Create EdgeDriver instance
        WebDriver driver = new EdgeDriver();
        // Open a webpage
        driver.get("https://www.google.com");
    }
}
