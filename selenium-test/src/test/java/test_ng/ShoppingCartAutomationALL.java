package test_ng;

import java.time.Duration;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(ShoppingCartAutomationALL.TestListener.class)
public class ShoppingCartAutomationALL {

    WebDriver driver;

    // 🔹 TestNG Lifecycle Annotations
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Opening the DB connections");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Closing the DB connections");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Checking products");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Removing products");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Opening the API connections");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("Closing the API connections");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Launching browser");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Closing the browser");
        if (driver != null) {
            driver.quit();
        }
    }

    // 🔹 Demo Testcases from AnnotationsDemo
    @Test(priority = 1)
    public void testCase1() {
        System.out.println("✅ Testcase1 is executed");
    }

    @Test(priority = 2)
    public void testCase2() {
        System.out.println("✅ Testcase2 is executed");
    }

    @Test(priority = 3)
    public void testCase3() {
        System.out.println("✅ Testcase3 is executed");
    }

    // 🔹 Soft Assertion Example
    @Test(priority = 4)
    public void testSoftAssertionLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Orange"; // intentionally wrong
        System.out.println("Page Title: " + actualTitle);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertNotEquals(actualTitle, expectedTitle, "❌ Title should not match 'Orange'");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);

        softAssert.assertAll();
    }

    // 🔹 Hard Assertion Example
    @Test(priority = 5)
    public void testHardAssertionLogin() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        String actualTitle = driver.getTitle();
        String expectedTitle = "Orange"; // intentionally wrong
        System.out.println("Page Title: " + actualTitle);

        Assert.assertEquals(actualTitle, expectedTitle, "❌ Title did not match!");

        WebElement username = driver.findElement(By.name("username"));
        username.sendKeys("Admin");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
    }

    // 🔹 Listener Test with Login
    @Test(priority = 6)
    public void testLoginWithListener() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement username = wait.until(d -> driver.findElement(By.name("username")));
        username.sendKeys("Admin");

        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("admin123");

        driver.findElement(By.xpath("//button[@type='submit']")).click();
    }

    // 🔹 Custom Listener (merged from TestNGListners)
    public static class TestListener implements ITestListener {
        @Override
        public void onTestStart(ITestResult result) {
            System.out.println("✅ Test execution started: " + result.getName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            System.out.println("✅ Test passed successfully: " + result.getName());
        }

        @Override
        public void onTestFailure(ITestResult result) {
            System.out.println("❌ Test failed: " + result.getName());
        }

        @Override
        public void onTestSkipped(ITestResult result) {
            System.out.println("⚠️ Test skipped: " + result.getName());
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
            System.out.println("⚠️ Test partially failed: " + result.getName());
        }

        @Override
        public void onFinish(ITestContext context) {
            System.out.println("📌 All test cases execution completed.");
        }
    }
}