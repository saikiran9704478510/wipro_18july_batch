package test_ng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGDependencyExample {

    WebDriver driver;

    @Test
    public void login() throws InterruptedException {
        // Automatic driver download & setup
        WebDriverManager.firefoxdriver().setup();

        // Optional: headless or custom arguments
        FirefoxOptions options = new FirefoxOptions();
        // options.addArguments("--headless");  // uncomment for headless run

        driver = new FirefoxDriver(options);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // enter username
        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");

        // enter password
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("admin123");

        // click login
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(2000); // simple wait (replace with WebDriverWait in real projects)
    }

    @Test(dependsOnMethods = {"login"})
    public void testCheckbox() throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement checkbox = driver.findElement(By.id("checkBoxOption1"));
        checkbox.click();

        Thread.sleep(2000);
        driver.quit();
    }
}