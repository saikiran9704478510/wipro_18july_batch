package com.wipro.JavaSelenium_14_08;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropEg {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            // Open the drag-and-drop demo page
            driver.get("https://the-internet.herokuapp.com/drag_and_drop");

            // Create Actions instance
            Actions actions = new Actions(driver);

            // Locate source & target elements
            WebElement source = driver.findElement(By.id("column-a"));
            WebElement target = driver.findElement(By.id("column-b"));

            // Perform drag and drop
            actions.dragAndDrop(source, target).perform();

            System.out.println("✅ Drag and drop completed successfully!");

            // Wait to observe the result
            Thread.sleep(3000);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        } finally {
            // Close the browser
            if (driver != null) {
                driver.quit();
            }
        }
    }
}


