package com.example;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dropdown {
	
	public static void main(String[] args) throws InterruptedException {

    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	WebDriverManager.firefoxdriver().setup();
    	
    	WebDriver driver = new FirefoxDriver(firefoxOptions);
        
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	
    	WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
    	Select sel = new Select(dropdown);

    	// by visible text
    	sel.selectByVisibleText("Option2");

    	// by value attribute
    	sel.selectByValue("option3");

    	// by index (0-based)
    	sel.selectByIndex(1);
    	
    	driver.close();
    	
	}
}
