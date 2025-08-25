package test_ng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.SkipException;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormFillingTest {

    WebDriver driver;
    int delay = 1000; // 1 sec

    // -----------------------------
    // Setup & Teardown
    // -----------------------------
    @BeforeClass(alwaysRun = true)
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // -----------------------------
    // PARAMETERIZATION (from testng.xml)
    // -----------------------------
    @Test(priority = 1, groups = {"Sanity"})
    @Parameters({"firstName", "lastName", "gender", "experience", "date"})
    public void fillBasicDetails(String firstName, String lastName, String gender, int exp, String date) throws InterruptedException {
        // Accept cookies if present
        try {
            WebElement acceptCookies = driver.findElement(By.id("ez-accept-all"));
            if (acceptCookies.isDisplayed()) {
                acceptCookies.click();
                Thread.sleep(delay);
            }
        } catch (Exception e) {
            System.out.println("No cookies popup displayed.");
        }

        driver.findElement(By.name("firstname")).clear();
        driver.findElement(By.name("firstname")).sendKeys(firstName);
        Thread.sleep(delay);

        driver.findElement(By.name("lastname")).clear();
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        Thread.sleep(delay);

        if (gender.equalsIgnoreCase("Male")) {
            driver.findElement(By.id("sex-0")).click();
        } else {
            driver.findElement(By.id("sex-1")).click();
        }
        Thread.sleep(delay);

        driver.findElement(By.id("exp-" + exp)).click();
        driver.findElement(By.id("datepicker")).clear();
        driver.findElement(By.id("datepicker")).sendKeys(date);

        System.out.println("✅ Basic details filled for: " + firstName + " " + lastName);
    }

    // -----------------------------
    // DEPENDENCY (runs after fillBasicDetails)
    // -----------------------------
    @Test(priority = 2, dependsOnMethods = {"fillBasicDetails"}, groups = {"Sanity", "Regression"})
    public void selectProfessionAndTools() throws InterruptedException {
        driver.findElement(By.id("profession-1")).click(); // Automation Tester
        driver.findElement(By.id("tool-2")).click(); // Selenium WebDriver
        Thread.sleep(delay);
        System.out.println("✅ Profession & Tools selected.");
    }

    @Test(priority = 3, dependsOnMethods = {"selectProfessionAndTools"}, groups = {"Regression"})
    public void selectDropdowns() throws InterruptedException {
        WebElement continents = driver.findElement(By.id("continents"));
        new Select(continents).selectByVisibleText("Europe");

        WebElement seleniumCommands = driver.findElement(By.id("selenium_commands"));
        Select selectCommands = new Select(seleniumCommands);
        selectCommands.selectByVisibleText("Browser Commands");
        selectCommands.selectByVisibleText("Navigation Commands");
        Thread.sleep(delay);

        System.out.println("✅ Dropdowns selected.");
    }

    // -----------------------------
    // SKIP TEST EXAMPLE
    // -----------------------------
    @Test(priority = 4)
    public void uploadFile() {
        boolean skipFileUpload = true; // change to false if you want to run
        if (skipFileUpload) {
            throw new SkipException("⏭ File upload skipped intentionally.");
        }

        WebElement fileInput = driver.findElement(By.id("photo"));
        fileInput.sendKeys("C:\\Users\\HP\\OneDrive\\Pictures\\Screenshots\\Screenshot.png");
        System.out.println("✅ File uploaded successfully.");
    }

    // -----------------------------
    // FINAL SUBMISSION (depends on Dropdowns)
    // -----------------------------
    @Test(priority = 5, dependsOnMethods = {"selectDropdowns"}, groups = {"Regression"})
    public void submitForm() throws InterruptedException {
        driver.findElement(By.id("submit")).click();
        Thread.sleep(2000);
        System.out.println("✅ Form submitted successfully.");
    }
}