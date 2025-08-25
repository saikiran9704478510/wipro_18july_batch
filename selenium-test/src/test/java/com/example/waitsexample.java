package com.example;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitsexample {

    public static void main(String[] args) {
        
    	// Set GeckoDriver path if not in system PATH
    	
    	WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(new FirefoxOptions());
        driver.manage().window().maximize();
        
        // Implicit Wait (applies globally for all findElement calls)
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://the-internet.herokuapp.com/login");

        // Explicit Wait - for username field
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
        username.sendKeys("tomsmith");

        // Fluent Wait - for password field
        WebElement password = driver.findElement(By.id("password"));
        
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(300))
                .ignoring(ElementNotInteractableException.class);

        fluentWait.until(d -> {
            password.sendKeys("SuperSecretPassword!");
            return true;
        });

        // Click Login button
        driver.findElement(By.cssSelector("button.radius")).click();

        // Close browser after short wait
        try { Thread.sleep(2000); } catch (InterruptedException e) {}
        driver.quit();
    }
}
