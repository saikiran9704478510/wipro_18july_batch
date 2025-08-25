package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class dynamic {

    public static void main(String[] args) {
                
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Open site
        driver.get("https://the-internet.herokuapp.com/login");

        // 1. starts-with (username input ID = "username")
        WebElement username = driver.findElement(By.xpath("//input[starts-with(@id,'user')]"));
        username.sendKeys("tomsmith");

        // 2. contains (password input ID = "password")
        WebElement password = driver.findElement(By.xpath("//input[contains(@id,'pass')]"));
        password.sendKeys("SuperSecretPassword!");

        // 3. and condition (button has name='login' and type='submit')
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit' and contains(text(),'Login')]"));
        loginBtn.click();

        // 4. text() function (read success or failure message after login attempt)
        WebElement message = driver.findElement(By.xpath("//div[@id='flash' and contains(text(),'You')]"));
        System.out.println("Message displayed: " + message.getText());

        // 5. ends-with (XPath 1.0 workaround for Selenium)
        // Example: match "username" field by suffix "name"
        WebElement usernameAgain = driver.findElement(By.xpath("//input[substring(@id, string-length(@id) - string-length('name') +1) = 'name']"));
        System.out.println("Ends-with XPath worked: " + usernameAgain.getAttribute("id"));

        // Close browser
        driver.quit();
    }
}