package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class demoguru {

    private WebDriver driver;

    // Locators
    private By firstNameField = By.xpath("//input[@name='firstName']");
    private By lastNameField = By.xpath("//input[@name='lastName']");
    private By phoneField = By.xpath("//input[@name='phone']");
    private By emailField = By.xpath("//input[@id='userName']");
    private By addressField = By.cssSelector("input[name='address1']"); 
    private By cityField = By.xpath("//input[@name='city']");
    private By stateField = By.xpath("//input[@name='state']");
    private By postalCodeField = By.xpath("//input[@name='postalCode']");
    private By countryDropdown = By.xpath("//select[@name='country']");
    private By usernameField = By.xpath("//input[@id='email']"); 
    private By passwordField = By.xpath("//input[@name='password']");
    private By confirmPasswordField = By.xpath("//input[@name='confirmPassword']");
    private By submitButton = By.xpath("//input[@name='submit']");

    // Constructor
    public demoguru(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterFirstName(String firstname) throws InterruptedException {
        driver.findElement(firstNameField).sendKeys(firstname);
        Thread.sleep(2000);
    }

    public void enterLastName(String lastname) throws InterruptedException {
        driver.findElement(lastNameField).sendKeys(lastname);
        Thread.sleep(2000);
    }

    public void enterPhone(String phone) throws InterruptedException {
        driver.findElement(phoneField).sendKeys(phone);
        Thread.sleep(2000);
    }

    public void enterEmail(String email) throws InterruptedException {
        driver.findElement(emailField).sendKeys(email);
        Thread.sleep(2000);
    }

    public void enterAddress(String address) throws InterruptedException {
        driver.findElement(addressField).sendKeys(address);
        Thread.sleep(2000);
    }

    public void enterCity(String city) throws InterruptedException {
        driver.findElement(cityField).sendKeys(city);
        Thread.sleep(2000);
    }

    public void enterState(String state) throws InterruptedException {
        driver.findElement(stateField).sendKeys(state);
        Thread.sleep(2000);
    }

    public void enterPostalCode(String postalCode) throws InterruptedException {
        driver.findElement(postalCodeField).sendKeys(postalCode);
        Thread.sleep(2000);
    }

    public void selectCountry(String country) throws InterruptedException {
        Select select = new Select(driver.findElement(countryDropdown));
        select.selectByVisibleText(country);
        Thread.sleep(2000);
    }

    public void enterUsername(String username) throws InterruptedException {
        driver.findElement(usernameField).sendKeys(username);
        Thread.sleep(2000);
    }

    public void enterPassword(String password) throws InterruptedException {
        driver.findElement(passwordField).sendKeys(password);
        Thread.sleep(2000);
    }

    public void enterConfirmPassword(String confirmPassword) throws InterruptedException {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
        Thread.sleep(3000);
    }

    public void clickSubmit() throws InterruptedException {
        driver.findElement(submitButton).click();
        Thread.sleep(2000);
    }
}