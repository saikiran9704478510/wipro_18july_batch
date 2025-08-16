package com.wipro.JavaSelenium_14_08;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyBoardEvents {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

            // Navigate to login page on "the-internet" site
            driver.get("https://the-internet.herokuapp.com/login");

            // Implicit wait (for locating elements globally)
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

            // Locate username and password fields
            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));

            // Explicit wait to ensure username field is visible before interacting
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.visibilityOf(username));

            // Fluent wait for password field to be interactable before sending keys
            Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofMillis(300))
                    .ignoring(ElementNotInteractableException.class);

            // Send username text
            username.sendKeys("tomsmith");
            System.out.println("Username entered");

            // Use fluent wait lambda to send keys to password safely
            fluentWait.until(d -> {
                password.sendKeys("SuperSecretPassword!");
                return true;
            });
            System.out.println("Password entered");

            // Optionally, submit the form or click login button
            WebElement loginBtn = driver.findElement(By.cssSelector("button[type='submit']"));
            loginBtn.click();

            Thread.sleep(3000); // Wait to see result

            // Verify successful login by checking URL or message
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/secure")) {
                System.out.println("✅ Login successful!");
            } else {
                System.out.println("❌ Login failed.");
            }

        } catch (Exception e) {
            System.out.println("❌ Error occurred: " + e.getMessage());
        } finally {
            // Cleanup - close browser
            if (driver != null) {
                driver.quit();
                System.out.println("✅ Browser closed.");
            }
        }
    }
}




/*//fluent wait 

		 Wait<WebDriver> wait1 =

			        new FluentWait<>(driver)

			            .withTimeout(Duration.ofSeconds(2))

			            .pollingEvery(Duration.ofMillis(300))

			            .ignoring(ElementNotInteractableException.class);

			    wait1.until(

			        d -> {

			        	password.sendKeys("Displayed");

			          return true;

			        });

WebElement username = driver.findElement(By.name("username"));

		// explicit wait - applicable for single web element - selenium 4

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		 wait.until(d -> username.isDisplayed());		

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));*/
