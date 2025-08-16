package Labs_14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MoveToElements {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            // Setup ChromeDriver
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();

            // Open practice page
            driver.get("https://rahulshettyacademy.com/AutomationPractice/");
            Thread.sleep(2000); 

            // Create Actions instance
            Actions actions = new Actions(driver);

            // Find elements
            WebElement hoverButton = driver.findElement(By.id("mousehover"));
            WebElement topOption = driver.findElement(By.xpath("//a[@href='#top']"));

            // Hover over the "Mouse Hover" button
            actions.moveToElement(hoverButton).perform();
            System.out.println("Hovered over Mouse Hover button");
            Thread.sleep(3000); 

            // Hover to "Top" option and click
            actions.moveToElement(topOption).click().perform();
            System.out.println("Clicked Top link");
            Thread.sleep(3000); 

            // Verify URL contains #top
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("#top")) {
                System.out.println(" Navigated to top successfully.");
            } else {
                System.out.println(" URL did not change as expected.");
            }

            Thread.sleep(3000); 

        } catch (Exception e) {
            System.out.println(" Error occurred: " + e.getMessage());
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println(" Browser closed.");
            }
        }
    }
}
