package Labs_13_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectDeselect {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open the website
        driver.get("https://grotechminds.com/multiple-select/");
        Thread.sleep(2000);

        // Locate the multi-select dropdown using XPath
        WebElement multiSelect = driver.findElement(By.xpath("//select[@name='cars']"));

        // Create Select object
        Select select = new Select(multiSelect);

        // Select multiple options first
        select.selectByVisibleText("Motorcycle");
        select.selectByVisibleText("Sedan");
        select.selectByVisibleText("Hatchback");
        select.selectByVisibleText("SUV");

        Thread.sleep(2000);

        // Deselect options individually (No loop)
        select.deselectByVisibleText("Motorcycle");
        Thread.sleep(1000);
        select.deselectByVisibleText("Sedan");
        Thread.sleep(1000);
        select.deselectByVisibleText("Hatchback");
        Thread.sleep(100);
        select.deselectByVisibleText("SUV");

        // Close browser
        driver.quit();
    }
}

