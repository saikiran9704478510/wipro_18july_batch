package com.wipro.JavaSelenium_14_08;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElementsEg {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();

            // Open Amazon
            driver.get("https://www.amazon.in/");

            // Create Actions instance
            Actions act = new Actions(driver);

            // Hover over "Prime"
            WebElement prime = driver.findElement(By.xpath("//span[normalize-space()='Prime']"));
            act.moveToElement(prime).perform();
            Thread.sleep(2000);

            // Click "Join Now"
            WebElement joinNow = driver.findElement(By.xpath("//a[@href='/prime']"));
            act.click(joinNow).perform();
            Thread.sleep(2000);

            System.out.println("✅ Hovered over Prime and clicked Join Now successfully!");

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            // Cleanup - close browser
            if (driver != null) {
                driver.quit();
                System.out.println("✅ Browser closed.");
            }
        }
    }
}

