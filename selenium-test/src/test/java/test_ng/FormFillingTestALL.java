package test_ng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;

@Listeners(TestNGListners.class)   // Attach custom listener
public class FormFillingTestALL {

    WebDriver driver;
    int delay = 1500; // delay in milliseconds (1.5 seconds)
    SoftAssert softAssert;

    /* -------------------- TestNG Annotations -------------------- */
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("📌 Opening DB connections");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("📌 Closing DB connections");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("📌 Checking products");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("📌 Removing products");
    }

    @BeforeClass
    public void setup() {
        System.out.println("📌 Opening API connections");

        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();

        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");

        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown() {
        System.out.println("📌 Closing API connections");
        driver.quit();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("📌 Launching browser (already launched)");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("📌 Closing the browser after test (quit handled in @AfterClass)");
    }

    /* -------------------- Test Cases -------------------- */

    @Test(priority = 1)
    public void validatePageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Automation Practice Form";  // Correct title
        System.out.println("Page Title: " + actualTitle);

        // Hard Assertion
        Assert.assertTrue(actualTitle.contains("Practice"), "❌ Title does not contain 'Practice'");

        // Soft Assertion
        softAssert.assertEquals(actualTitle, expectedTitle, "❌ Title did not match expected");
        softAssert.assertAll(); // collect soft results
    }

    @Test(priority = 2)
    public void fillForm() throws InterruptedException {
        // Accept cookies popup (if displayed)
        try {
            WebElement acceptCookies = driver.findElement(By.id("ez-accept-all"));
            if (acceptCookies.isDisplayed()) {
                acceptCookies.click();
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            System.out.println("⚠️ No cookies popup displayed.");
        }

        // First Name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("madan");
        Thread.sleep(delay);

        // Last Name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("saikiran");
        Thread.sleep(delay);

        // Gender
        driver.findElement(By.xpath("//input[@id='sex-0']")).click();
        Thread.sleep(delay);

        // Experience
        driver.findElement(By.xpath("//input[@id='exp-4']")).click();
        Thread.sleep(delay);

        // Date
        driver.findElement(By.xpath("//input[@id='datepicker']")).sendKeys("02-06-2002");
        Thread.sleep(delay);

        // Profession
        driver.findElement(By.xpath("//input[@id='profession-1']")).click();
        Thread.sleep(delay);

        // Tool
        driver.findElement(By.xpath("//input[@id='tool-2']")).click();
        Thread.sleep(delay);

        // Continent Dropdown
        WebElement continents = driver.findElement(By.xpath("//select[@id='continents']"));
        Select selectContinent = new Select(continents);
        selectContinent.selectByVisibleText("Europe");
        Thread.sleep(delay);

        // Selenium Commands
        WebElement seleniumCommands = driver.findElement(By.xpath("//select[@id='selenium_commands']"));
        Select selectCommands = new Select(seleniumCommands);
        selectCommands.selectByVisibleText("Browser Commands");
        Thread.sleep(delay);
        selectCommands.selectByVisibleText("Navigation Commands");
        Thread.sleep(delay);

        // File Upload
        WebElement fileInput = driver.findElement(By.xpath("//input[@id='photo']"));
        fileInput.sendKeys("C:\\Users\\HP\\OneDrive\\Pictures\\Screenshots\\Screenshot 2025-08-16 120806.png"); 
        Thread.sleep(delay);

        // Submit
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 3)
    public void testWaitsAndLoginDemo() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement username = wait.until(d -> driver.findElement(By.name("username")));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));

        // Fluent Wait Example
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(ElementNotInteractableException.class);

        fluentWait.until(d -> {
            password.sendKeys("admin123");
            return true;
        });

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }
}
