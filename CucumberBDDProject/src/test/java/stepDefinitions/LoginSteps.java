package stepDefinitions;

import utils.DriverFactory;
import io.cucumber.java.en.*;
import pages.loginpage;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSteps {

	WebDriver driver = DriverFactory.getDriver();
	loginpage lp = new loginpage(driver);
	
    @Given("User is on the login page")
    public void user_is_on_the_login_page() throws InterruptedException {
    	Thread.sleep(5000);
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @When("user enters the username")
    public void user_enters_the_username() throws InterruptedException {
    	Thread.sleep(5000);
        driver.findElement(By.name("username")).sendKeys("Admin");
    }

    @When("user enters the password")
    public void user_enters_the_password() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("admin123");
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button() throws InterruptedException {
    	Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    @Then("user is navigated to home page")
    public void user_is_navigated_to_home_page() throws InterruptedException {
        // simple assertion by URL or page title
        Thread.sleep(2000);
        String url = driver.getCurrentUrl();
        if (!url.contains("dashboard")) {
            throw new AssertionError("Not on Dashboard. Current URL: " + url);
        }
        System.out.println(" Successfully navigated to Dashboard!");
    }
    
    // ---------------- Invalid login steps ----------------
    
    @When("user enters the invalid password")
    public void user_enters_the_invalid_password() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys("WrongPass");
    }
    @Then("An error message is displayed")
    public void an_error_message_is_displayed() throws InterruptedException {
        Thread.sleep(2000);
        String errorText = driver.findElement(By.xpath("//p[contains(@class,'oxd-alert-content-text')]")).getText();
        if (!errorText.contains("Invalid credentials")) {
            throw new AssertionError("Expected error message not found. Actual: " + errorText);
        }
        System.out.println("Login failed as expected. Error message: " + errorText);
    }
    @When("user enters the username {string}")
    public void user_enters_the_username(String username) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("username")).sendKeys(username);
    }
    @When("user enters the password {string}")
    public void user_enters_the_password(String password) throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.name("password")).sendKeys(password);
    }
    @When("user enters credentials")
    public void user_enters_credentials(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
    	
    	List<Map<String, String>> users = dataTable.asMaps(String.class, String.class);
    
   		for (Map<String, String> user : users) {

    
   			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    
   			Thread.sleep(10000);
    
   			String username = user.get("username");
   			String password = user.get("password");
    
   			WebElement username1 = driver.findElement(By.name("username"));
    
   			Thread.sleep(4000);
    
   			username1.sendKeys(username);
    
   			Thread.sleep(2000);
    
   			WebElement password1 = driver.findElement(By.name("password"));
    
   			password1.sendKeys(password);
    
   			Thread.sleep(2000);
    }
}
    @Given("the user is on the login page")
	public void the_user_is_on_the_login_page() throws InterruptedException {
		// launch the application on the chrome browser
				Thread.sleep(10000);
 
				driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 
				Thread.sleep(2000);
 
	}
 
	@When("the user enters username {string} and password {string}")
	public void the_user_enters_username_and_password(String username, String password) throws InterruptedException {
 
	lp.enterCredentials(username, password);
	}
 
	@Then("the user should be navigated to the home page")
	public void the_user_should_be_navigated_to_the_home_page() {
		lp.clickLogin();
	}
}
