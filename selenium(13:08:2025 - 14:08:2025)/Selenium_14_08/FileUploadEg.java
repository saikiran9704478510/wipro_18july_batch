package com.wipro.JavaSelenium_14_08;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadEg {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open the file upload page
        driver.get("https://the-internet.herokuapp.com/upload");

        // Maximize the window
        driver.manage().window().maximize();

        // Locate the file upload input (from Inspect -> XPath)
        WebElement fileUpload = driver.findElement(By.xpath("//input[@id='file-upload']"));

        // Send the file path to upload
        fileUpload.sendKeys("C:\\Users\\HP\\Downloads\\selenium_practice_locators.txt"); // change path to your file

        // Locate and click the submit button
        WebElement submit = driver.findElement(By.xpath("//input[@id='file-submit']"));
        submit.click();

        // Wait for upload confirmation
        Thread.sleep(2000);

        // Validate success message
        WebElement validationMsg = driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']"));

        if (validationMsg.isDisplayed()) {
            System.out.println("✅ The file was uploaded successfully.");
        } else {
            System.out.println("❌ The file upload failed.");
        }

        // Close browser
        driver.quit();
    }
}

