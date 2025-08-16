package com.wipro.JavaSelenium_14_08;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesEg {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOption = new ChromeOptions();
            driver = new ChromeDriver(chromeOption);

            // Open target URL
            driver.get("https://jqueryui.com/droppable/");
            driver.manage().window().maximize();

            // Actions instance for mouse operations
            Actions actions = new Actions(driver);

            // Wait to see the page load
            Thread.sleep(2000);

            // Switch to the iFrame — using index
            driver.switchTo().frame(0);

            // Locate draggable and droppable elements
            WebElement drag = driver.findElement(By.id("draggable"));
            WebElement drop = driver.findElement(By.id("droppable"));

            // Wait before action
            Thread.sleep(2000);

            // Perform drag and drop
            actions.dragAndDrop(drag, drop).perform();
            System.out.println("✅ Drag and drop performed successfully!");

            // Wait to observe the result
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("❌ Error occurred: " + e.getMessage());
        } finally {
            // Quit the browser
            if (driver != null) {
                driver.quit();
                System.out.println("✅ Browser closed.");
            }
        }
    }
}

