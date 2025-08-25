package test_ng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShoppingCartAutomation {

    WebDriver driver;

    @BeforeClass
    public void setup() throws InterruptedException {
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        driver.get("https://www.demoblaze.com/");
        System.out.println("\n============================");
        System.out.println("Opened Demoblaze Website");
        System.out.println("============================\n");
        Thread.sleep(4000);
    }

    // ---------------------- MULTIPLE TEST CASES ----------------------

    @Test(priority = 1)
    public void openHomePage() throws InterruptedException {
        System.out.println("➡ Step 0: Verifying homepage title...");
        String title = driver.getTitle();
        if (title.contains("STORE")) {
            System.out.println("✅ Home page loaded successfully!");
        } else {
            System.out.println("❌ Home page not loaded correctly!");
        }
        Thread.sleep(2000);
    }

    // ---------------------- PARAMETERIZATION ----------------------
    @Parameters({"productName"})
    @Test(priority = 2)
    public void addProductToCart(String productName) throws InterruptedException {
        System.out.println("➡ Step 1: Selecting product -> " + productName);

        driver.findElement(By.xpath("//a[contains(text(),'" + productName + "')]")).click();
        Thread.sleep(4000);

        System.out.println("➡ Step 2: Adding product to cart...");
        driver.findElement(By.xpath("//a[contains(text(),'Add to cart')]")).click();
        Thread.sleep(5000);

        driver.switchTo().alert().accept();
        System.out.println("✅ Product added to cart!");
        Thread.sleep(3000);

        // Navigate back to home for next step
        driver.findElement(By.xpath("//a[contains(text(),'Home')]")).click();
        Thread.sleep(4000);
    }

    // ---------------------- DEPENDENCY ----------------------
    @Test(priority = 3, dependsOnMethods = {"addProductToCart"})
    public void goToCartAndCheckout() throws InterruptedException {
        System.out.println("➡ Step 3: Navigating to cart...");
        driver.findElement(By.xpath("//a[contains(text(),'Cart')]")).click();
        Thread.sleep(4000);

        WebElement product = driver.findElement(By.xpath("//tr/td[2]"));
        if (product.isDisplayed()) {
            System.out.println("✅ Product visible in cart: " + product.getText());
        } else {
            System.out.println("❌ Product not found in cart!");
        }
        Thread.sleep(2000);

        System.out.println("➡ Step 4: Clicking Place Order...");
        driver.findElement(By.xpath("//button[contains(text(),'Place Order')]")).click();
        Thread.sleep(4000);
    }

    // ---------------------- PARAMETERIZED ORDER FORM ----------------------
    @Parameters({"name", "country", "city", "card", "month", "year"})
    @Test(priority = 4, dependsOnMethods = {"goToCartAndCheckout"})
    public void fillOrderForm(String name, String country, String city, String card, String month, String year) throws InterruptedException {
        System.out.println("➡ Step 5: Filling order form with parameters...");

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("country")).sendKeys(country);
        driver.findElement(By.id("city")).sendKeys(city);
        driver.findElement(By.id("card")).sendKeys(card);
        driver.findElement(By.id("month")).sendKeys(month);
        driver.findElement(By.id("year")).sendKeys(year);

        Thread.sleep(2000);

        System.out.println("➡ Step 6: Clicking Purchase...");
        driver.findElement(By.xpath("//button[contains(text(),'Purchase')]")).click();
        Thread.sleep(4000);

        WebElement confirmation = driver.findElement(By.xpath("//h2[contains(text(),'Thank you for your purchase!')]"));
        if (confirmation.isDisplayed()) {
            System.out.println("✅ Order placed successfully!");
        } else {
            System.out.println("❌ Order failed!");
        }
        Thread.sleep(3000);

        driver.findElement(By.xpath("//button[contains(text(),'OK')]")).click();
        Thread.sleep(2000);
    }

    // ---------------------- SKIP TEST ----------------------
    @Test(priority = 5)
    public void skipTestExample() {
        System.out.println("➡ Step 7: Skipping this test intentionally...");
        throw new SkipException("Skipping this test case for demo purpose!");
    }

    @AfterClass
    public void tearDown() throws InterruptedException {
        System.out.println("🔴 Closing Browser in 5 seconds...");
        Thread.sleep(5000);
        driver.quit();
    }
}
