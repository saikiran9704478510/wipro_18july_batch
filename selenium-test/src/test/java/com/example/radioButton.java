package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class radioButton {

    public static void main(String[] args) throws InterruptedException {

    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	WebDriverManager.firefoxdriver().setup();
    	
    	WebDriver driver = new FirefoxDriver(firefoxOptions);
        
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	
//    	checkbox : 
        WebElement option1 = driver.findElement(By.xpath("//input[@id = 'checkBoxOption1']"));

        option1.click();

//        radiobutton : 
        WebElement radioOption3 = driver.findElement(By.xpath("//input[@value='radio3']"));
        
        radioOption3.click();

        Thread.sleep(3000);

    }
}