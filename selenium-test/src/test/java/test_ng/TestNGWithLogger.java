package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import utilities.LoggerHelper;

public class TestNGWithLogger {

    private static final Logger log = LoggerHelper.getLogger(TestNGWithLogger.class);
    WebDriver driver;

    @BeforeTest
    public void setup() {
        log.info("Setting up Chrome browser");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        log.info("Browser launched successfully");
    }

    @Test
    public void loginTest() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        log.info("Navigated to OrangeHRM login page");

        Thread.sleep(2000);

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        log.info("Entered username: Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");
        log.info("Entered password");

        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        log.info("Clicked on Login button");

        Thread.sleep(2000);
        log.info("Login test execution completed");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            log.info("Browser closed successfully");
        }
    }
}
