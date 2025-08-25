package test_ng;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(TestNGListners.class)   // Attach custom TestNG Listener
public class LoginAutomationTestALL {

    WebDriver driver;
    SoftAssert softAssert;   // for soft assertions

    // ---------- SUITE LEVEL ----------
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("📂 Opening DB connection before Suite...");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("📂 Closing DB connection after Suite...");
    }

    // ---------- TEST LEVEL ----------
    @BeforeTest
    public void beforeTest() {
        System.out.println("🛠 Preparing Test Execution...");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("🛠 Cleaning up after Test Execution...");
    }

    // ---------- CLASS LEVEL ----------
    @BeforeClass
    public void setup() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");
        System.out.println("\n============================");
        System.out.println("✅ Opened Practice Test Login Page");
        System.out.println("============================\n");
        Thread.sleep(3000);
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("🔴 Closing Browser in 5 seconds...");
        Thread.sleep(3000);
        driver.quit();
    }

    // ---------- METHOD LEVEL ----------
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("🌐 Launching Browser before Test Method...");
        softAssert = new SoftAssert(); // initialize before each test
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("🌐 Closing Browser after Test Method...");
        softAssert.assertAll(); // collect soft assertions
    }

    // ---------- TEST CASES ----------
    @Test(priority = 1)
    public void validLogin() throws InterruptedException {
        System.out.println("➡ Test 1: Performing VALID login...");

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(3000);

        WebElement logoutBtn = driver.findElement(By.xpath("//a[contains(text(),'Log out')]"));

     // Hard assertion
        Assert.assertTrue(logoutBtn.isDisplayed(), "❌ Valid Login Failed - Logout button not visible!");

        // Soft assertion – NOW uses the correct expected text
        String actualLogoutText = logoutBtn.getText();
        softAssert.assertEquals(actualLogoutText, "Log out","❌ Soft Assertion Failed - Logout button text mismatch!");

        System.out.println("✅ Valid Login Passed: User logged in successfully!");
    }

    @Test(priority = 2)
    public void invalidLogin() throws InterruptedException {
        System.out.println("➡ Test 2: Performing INVALID login...");

        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("wrongUser");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("wrongPass");
        driver.findElement(By.xpath("//button[@id='submit']")).click();
        Thread.sleep(2000);

        WebElement errorMsg = driver.findElement(By.xpath("//div[@id='error']"));

        // Hard Assertion
        Assert.assertTrue(errorMsg.isDisplayed(), "❌ Invalid Login Failed - Error message not shown!");

        // Soft Assertion
        String actualError = errorMsg.getText();
        String expectedError = "Your username is invalid!"; // actual site message
        softAssert.assertEquals(actualError, expectedError, "❌ Soft Assertion Failed - Error message mismatch!");

        System.out.println("✅ Invalid Login Passed: Error message displayed correctly.");
    }
}
