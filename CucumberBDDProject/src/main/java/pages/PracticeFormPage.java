package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeFormPage {
    WebDriver driver;

    // Locators
    By name = By.id("name");
    By email = By.id("email");
    By genderMale = By.id("gender"); 
    By mobile = By.id("mobile");
    By dob = By.id("dob");
    By subjects = By.id("subjects");
    By hobbyReading = By.xpath("//div[7]//div[1]//div[1]//div[2]//input[1]");
    By pictureUpload = By.id("picture");
    By address = By.xpath("//textarea[@placeholder='Currend Address']");
    By state = By.id("state");
    By city = By.id("city");
    By loginButton = By.xpath("//input[@value='Login']");

    // Constructor
    public PracticeFormPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterName(String uname) {
        driver.findElement(name).sendKeys(uname);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    public void selectGender() {
        driver.findElement(genderMale).click();
    }

    public void enterMobile(String mob) {
        driver.findElement(mobile).sendKeys(mob);
    }

    public void enterDOB(String date) {
        driver.findElement(dob).sendKeys(date);
    }

    public void enterSubjects(String sub) {
        driver.findElement(subjects).sendKeys(sub);
    }

    public void selectHobby() {
        driver.findElement(hobbyReading).click();
    }

    public void uploadPicture(String path) {
        driver.findElement(pictureUpload).sendKeys(path);
    }

    public void enterAddress(String addr) {
        driver.findElement(address).sendKeys(addr);
    }

    public void selectState(String st) {
        Select selectState = new Select(driver.findElement(state));
        selectState.selectByVisibleText(st);
    }

    public void selectCity(String ct) {
        Select selectCity = new Select(driver.findElement(city));
        selectCity.selectByVisibleText(ct);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
