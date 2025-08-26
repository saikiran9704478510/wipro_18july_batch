package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class SauceDemoSteps {

    WebDriver driver;

    @Given("User is on SauceDemo login page")
    public void user_is_on_saucedemo_login_page() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() throws InterruptedException {
    	Thread.sleep(2000);       
    	driver.findElement(By.id("user-name")).sendKeys("standard_user");
    	Thread.sleep(2000);       
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    	Thread.sleep(2000);       
        driver.findElement(By.id("login-button")).click();
    }

    @When("User enters invalid username and password")
    public void user_enters_invalid_username_and_password() throws InterruptedException {
    	Thread.sleep(2000);       
        driver.findElement(By.id("user-name")).sendKeys("wrong_user");
    	Thread.sleep(2000);       
        driver.findElement(By.id("password")).sendKeys("wrong_pass");
    	Thread.sleep(2000);       
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User is navigated to Products page")
    public void user_is_navigated_to_products_page() throws InterruptedException {
    	Thread.sleep(2000);       
        String title = driver.findElement(By.className("title")).getText();
        if (!title.equals("Products")) {
            throw new AssertionError("Not navigated to Products page");
        }
    }

    @When("User adds a product to the cart")
    public void user_adds_a_product_to_the_cart() throws InterruptedException {
    	Thread.sleep(2000);       
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    	Thread.sleep(2000);       
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("User proceeds to checkout")
    public void user_proceeds_to_checkout() throws InterruptedException {
    	Thread.sleep(2000);       
        driver.findElement(By.id("checkout")).click();
    }

    @When("User enters checkout details")
    public void user_enters_checkout_details() throws InterruptedException {
    	Thread.sleep(2000);       
        driver.findElement(By.id("first-name")).sendKeys("Sai");
    	Thread.sleep(2000);       
        driver.findElement(By.id("last-name")).sendKeys("Kiran");
    	Thread.sleep(2000);       
        driver.findElement(By.id("postal-code")).sendKeys("500001");
    	Thread.sleep(2000);       
        driver.findElement(By.id("continue")).click();
    }

    @When("User completes the purchase")
    public void user_completes_the_purchase() throws InterruptedException {
    	Thread.sleep(2000);       
        driver.findElement(By.id("finish")).click();
    }

    @Then("Order confirmation message is displayed")
    public void order_confirmation_message_is_displayed() throws InterruptedException {
    	Thread.sleep(2000);       
        String msg = driver.findElement(By.className("complete-header")).getText();
        if (!msg.contains("Thank you")) {
            throw new AssertionError("Order not completed. Message: " + msg);
        }
        driver.quit();
    }

    @Then("An error message is displayed on SauceDemo")
    public void an_error_message_is_displayed_on_saucedemo() throws InterruptedException {
    	Thread.sleep(2000);       
        String errorText = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        if (!errorText.contains("Epic sadface")) {
            throw new AssertionError("Expected error message not found. Actual: " + errorText);
        }
        driver.quit();
    }
}
