package Labs_14_08;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class RahulShettyAutomation {
    public static void main(String[] args) throws InterruptedException {
        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);

        // Hide textbox
        WebElement hideBtn = driver.findElement(By.xpath("//input[@id='hide-textbox']"));
        hideBtn.click();
        System.out.println("Textbox hidden");
        Thread.sleep(2000);

        // Show textbox
        WebElement showBtn = driver.findElement(By.xpath("//input[@id='show-textbox']"));
        showBtn.click();
        System.out.println("Textbox shown");
        Thread.sleep(2000);

        // Open Tab
        WebElement openTab = driver.findElement(By.xpath("//a[@id='opentab']"));
        openTab.click();
        System.out.println("Tab opened");
        Thread.sleep(3000);

        // Switch back to original tab
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("AutomationPractice")) {
                break;
            }
        }

        // Open Window
        WebElement openWindow = driver.findElement(By.xpath("//button[@id='openwindow']"));
        openWindow.click();
        System.out.println("Window opened");
        Thread.sleep(3000);

        // Switch back to original window
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getCurrentUrl().contains("AutomationPractice")) {
                break;
            }
        }

        // Handle iframe
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='courses-iframe']")));
        System.out.println("Switched to iframe");
        Thread.sleep(2000);

        // Click on "All Access Plan" inside iframe
        WebElement allAccess = driver.findElement(By.xpath("//a[contains(text(),'All Access Plan')]"));
        allAccess.click();
        System.out.println("Clicked inside iframe");
        Thread.sleep(3000);

        // Switch back to main content
        driver.switchTo().defaultContent();

        System.out.println("Test completed successfully!");
        driver.quit();
    }
}

