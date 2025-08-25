package test_ng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataproviders {

    @DataProvider(name = "logindata", parallel = true)
    public Object[][] getData() {
        return new Object[][] {
                { "Admin", "admin123" },  // Valid credentials
                { "adm", "admin123" },    // Invalid username
                { "Admin", "wrongpass" }  // Invalid password
        };
    }

    @Test(dataProvider = "logindata")
    public void loginTest(String username, String password) throws InterruptedException {

        // Setup browser
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized"); 
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);

        // Enter Username
        WebElement usernameField = driver.findElement(By.name("username"));
        usernameField.sendKeys(username);

        // Enter Password
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);

        // Click Login
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(3000);

        // Check if login successful or failed
        try {
            WebElement dashboard = driver.findElement(By.xpath("//h6[text()='Dashboard']"));
            if (dashboard.isDisplayed()) {
                System.out.println("Login SUCCESS with: " + username + " | " + password);
            }
        } catch (Exception e) {
            System.out.println("Login FAILED with: " + username + " | " + password);
        }

        driver.quit(); // Close browser
    }
}
