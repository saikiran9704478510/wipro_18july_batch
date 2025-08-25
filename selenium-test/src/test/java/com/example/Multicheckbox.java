package com.example;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multicheckbox {
	public static void main(String[] args) throws InterruptedException {

    	FirefoxOptions firefoxOptions = new FirefoxOptions();
    	WebDriverManager.firefoxdriver().setup();
    	
    	WebDriver driver = new FirefoxDriver(firefoxOptions);
        
    	driver.get("https://rahulshettyacademy.com/AutomationPractice/");
    	
    	driver.manage().window().maximize();
    	
    	List<WebElement> chkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
    	
    	int size = chkboxes.size();
    	System.out.println(size);
    	
    	for(int i = 0; i < size; i++) {
    		
    		Thread.sleep(1000);
    		
    		chkboxes.get(i).click();
    		
    		Thread.sleep(1000);
    		
    	}
    	
    	List<WebElement> radioButtons = driver.findElements(
    	        By.xpath("//input[@type='radio' and @name='radioButton']"));

    	int radioSize = radioButtons.size();
    	System.out.println("Total radio buttons in the group: " + radioSize);

    	for (int i = 0; i < radioSize; i++) {
    	    
    		Thread.sleep(1000);
    	    
    		radioButtons.get(i).click();
    	    
    		Thread.sleep(1000);
    	}
    	
    	
}
}
