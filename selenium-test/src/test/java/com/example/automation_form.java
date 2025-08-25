package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

public class automation_form {
    public static void main(String[] args) throws InterruptedException {

        // Firefox Options
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        // Open practice form
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        driver.manage().window().maximize();

        // Fill name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Madan");
        Thread.sleep(1000);

        // Fill email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("sai@gmail.com");
        Thread.sleep(1000);

        // Select gender - Male
        driver.findElement(By.xpath("//input[@id='gender']")).click();
        Thread.sleep(1000);

        // Fill mobile number
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("123456789");
        Thread.sleep(1000);

        // Enter date of birth
        driver.findElement(By.id("dob")).sendKeys("2002-04-11");
        Thread.sleep(1000);

        // Enter subjects
        driver.findElement(By.xpath("//input[@id='subjects']"))
                .sendKeys("maths, physics, java selenium python, software testing");
        Thread.sleep(1000);

        // Select hobby - Reading
        driver.findElement(By.xpath("//div[7]//div[1]//div[1]//div[2]//input[1]")).click();
        Thread.sleep(1000);

        // Upload picture
        WebElement uploadPic = driver.findElement(By.id("picture"));
        uploadPic.sendKeys("/Users/apple/Documents/Passport_Photograph.jpg"); 
        Thread.sleep(1000);

       
        // Enter address
        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@placeholder='Currend Address']"));
        currentAddress.sendKeys("Vijayawada, Andhra Pradesh");
        Thread.sleep(1000);

        // Select State - NCR
        Select stateSelect = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateSelect.selectByVisibleText("NCR");
        Thread.sleep(1000);

        // Select City - Agra
        Select citySelect = new Select(driver.findElement(By.xpath("//select[@id='city']")));
        citySelect.selectByVisibleText("Agra");
        Thread.sleep(1000);

        // Click Login button
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        Thread.sleep(2000);

        // Close browser
//        driver.quit();
    }
}

