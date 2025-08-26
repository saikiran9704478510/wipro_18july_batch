package stepDefinitions;

import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.*;
import pages.PracticeFormPage;
import utils.DriverFactory;

public class PracticeFormSteps {
	WebDriver driver = DriverFactory.getDriver();
	PracticeFormPage lp = new PracticeFormPage(driver);
    
	@Given("User is on the automation practice form page")
	public void user_is_on_the_automation_practice_form_page() {
    	driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");

	}

	@When("User enters name {string} and email {string}")
	public void user_enters_name_and_email(String name, String email) throws InterruptedException {
		Thread.sleep(2000);
    	lp.enterName(name);
    	lp.enterEmail(email);
	}

	@When("User selects gender {string}")
	public void user_selects_gender(String string) throws InterruptedException {
		Thread.sleep(2000);
    	lp.selectGender();
	}

	@When("User enters mobile number {string}")
	public void user_enters_mobile_number(String mobile) throws InterruptedException {
		Thread.sleep(2000);
    	lp.enterMobile(mobile);
	}

	@When("User enters date of birth {string}")
	public void user_enters_date_of_birth(String dob) throws InterruptedException {
		Thread.sleep(2000);
    	lp.enterDOB(dob);
	}

	@When("User enters subjects {string}")
	public void user_enters_subjects(String subjects) throws InterruptedException {
		Thread.sleep(2000);
    	lp.enterSubjects(subjects);
	}

	@When("User selects hobby {string}")
	public void user_selects_hobby(String string) throws InterruptedException {
		Thread.sleep(2000);
    	lp.selectHobby();
	}

	@When("User uploads picture")
	public void user_uploads_picture() throws InterruptedException {
		Thread.sleep(2000);
    	lp.uploadPicture("/Users/apple/Documents/Passport_Photograph.jpg");
	}

	@When("User enters current address {string}")
	public void user_enters_current_address(String address) throws InterruptedException {
		Thread.sleep(2000);
    	lp.enterAddress(address);
	}

	@When("User selects state {string} and city {string}")
	public void user_selects_state_and_city(String state, String city) throws InterruptedException {
		Thread.sleep(2000);
    	lp.selectState(state);
    	lp.selectCity(city);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		Thread.sleep(2000);
    	lp.clickLogin();
	}

	@Then("Form should be submitted successfully")
	public void form_should_be_submitted_successfully() throws InterruptedException {
		Thread.sleep(2000);
        driver.quit();

	}

}
