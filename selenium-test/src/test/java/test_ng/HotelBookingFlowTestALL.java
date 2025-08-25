package test_ng;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Listeners;

@Listeners(test_ng.TestNGListners.class)// Attach custom listener
public class HotelBookingFlowTestALL {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    SoftAssert softAssert;

    /* ---------------- TestNG Annotations ---------------- */
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
    public void setup() throws InterruptedException {
        System.out.println("📌 Opening API connections");

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        actions = new Actions(driver);
        driver.manage().window().maximize();

        driver.get("https://phptravels.net/");
        Thread.sleep(3000);

        softAssert = new SoftAssert();
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("📌 Closing API connections");
        if (driver != null) {
            System.out.println("🔴 Closing Browser in 5 seconds...");
            Thread.sleep(5000);
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("📌 Launching browser (already open)");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("📌 Closing after test method execution");
    }

    /* ---------------- Test Cases ---------------- */

    @Test(priority = 1)
    public void validateHomePageTitle() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "PHPTRAVELS"; // Example validation
        System.out.println("Page Title: " + actualTitle);

        // Hard Assertion
        Assert.assertTrue(actualTitle.contains("PHPTRAVELS"), "❌ Home page title mismatch!");

        // Soft Assertion
        softAssert.assertEquals(actualTitle, expectedTitle, "❌ Title did not match exactly!");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void bookHotel() throws InterruptedException {
        System.out.println("STEP 1: Navigate to Hotels tab");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-name='hotels']"))).click();
        Thread.sleep(3000);

        System.out.println("STEP 2: Enter Destination (Dubai)");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-hotels_city-container"))).click();
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("select2-search__field")));
        searchBox.sendKeys("Dubai");
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("select2-hotels_city-results"), "Dubai,United Arab Emirates"));
        searchBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);

        System.out.println("STEP 3 & 4: Select Check-in and Check-out dates");
        driver.findElement(By.id("checkin")).click();
        WebElement checkinDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotels-checkin-calendar']//div[text()='20']")));
        checkinDate.click();
        Thread.sleep(2000);
        WebElement checkoutDate = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='hotels-checkout-calendar']//div[text()='25']")));
        checkoutDate.click();
        Thread.sleep(3000);

        System.out.println("STEP 5: Add one child guest");
        driver.findElement(By.xpath("//a[contains(@class, 'travellers')]")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'dropdown-item') and .//div[text()='Child']]//button[contains(@class,'bootstrap-touchspin-up')]"))).click();
        Thread.sleep(3000);

        System.out.println("STEP 6: Click Search");
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);

        System.out.println("STEP 7: Select the first hotel from results");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h4[contains(@class,'title')]/a)[1]"))).click();
        Thread.sleep(5000);

        System.out.println("STEP 8: Switch to the new browser tab");
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(3000);

        System.out.println("STEP 9: Book the first available room");
        WebElement availableRoomsHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[normalize-space()='Available Rooms']")));
        actions.moveToElement(availableRoomsHeader).perform();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//form[contains(@class,'book-form')]//button[normalize-space()='Book Now'])[1]"))).click();
        Thread.sleep(4000);

        System.out.println("STEP 10: Fill booking details");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("Saswat");
        driver.findElement(By.name("lastname")).sendKeys("Pati");
        driver.findElement(By.name("email")).sendKeys("saswat@test.com");
        driver.findElement(By.name("phone")).sendKeys("9876543210");
        driver.findElement(By.name("address")).sendKeys("Bhubaneswar, Odisha");
        Thread.sleep(3000);

        System.out.println("STEP 11: Confirm Booking");
        WebElement confirmBtn = driver.findElement(By.id("booking"));
        WebElement termsCheckbox = driver.findElement(By.id("agreechb"));
        actions.moveToElement(termsCheckbox).click().perform();
        Thread.sleep(2000);
        confirmBtn.click();
        Thread.sleep(5000);

        System.out.println("STEP 12: Verifying final invoice page");
        wait.until(ExpectedConditions.urlContains("invoice"));

        // Hard Assertion (Invoice page URL)
        Assert.assertTrue(driver.getCurrentUrl().contains("invoice"), "❌ Invoice page not loaded!");

        // Soft Assertion (URL validation)
        softAssert.assertTrue(driver.getCurrentUrl().contains("invoice"), "❌ Soft check failed for invoice page!");
        softAssert.assertAll();

        System.out.println("✅ Booking flow executed successfully!");
    }

    @Test(priority = 3)
    public void demoWaitsWithFluentWait() {
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement username = explicitWait.until(d -> driver.findElement(By.name("username")));
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