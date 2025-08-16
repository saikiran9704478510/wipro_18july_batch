package com.wipro.JavaSelenium_14_08;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionEg {
    public static void main(String[] args) {
        WebDriver driver = null;
        try {
            ChromeOptions chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOptions);

            driver.get("https://www.amazon.in/");
            driver.manage().window().maximize();

            Actions act = new Actions(driver);

            // Double click on Sell link
            WebElement sell = driver.findElement(By.xpath("//a[normalize-space()='Sell']"));
            act.doubleClick(sell).perform();
            Thread.sleep(2000);

            // Navigate back
            driver.navigate().back();
            Thread.sleep(1000);

            // Right click on Mobiles link
            WebElement mobiles = driver.findElement(By.xpath("//a[normalize-space()='Mobiles']"));
            act.contextClick(mobiles).perform();

        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.close();
            }
        }
    }
}


