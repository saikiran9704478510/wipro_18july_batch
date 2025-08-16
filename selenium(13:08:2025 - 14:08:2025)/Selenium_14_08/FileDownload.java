package com.wipro.JavaSelenium_14_08;



import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownload {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        // Open the website
        driver.get("https://the-internet.herokuapp.com/download");

        // Maximize window
        driver.manage().window().maximize();

        // Locate file link using XPath (from inspect) and click
        WebElement fileDownload = driver.findElement(By.xpath("//a[text()='some-file.txt']")); // replace with actual file name
        fileDownload.click();

        // Wait for file to download (basic wait)
        Thread.sleep(5000);

        // Check if the file exists in Downloads folder
        String downloadPath = "C:\\Users\\HP\\Downloads\\some-file.txt"; // update file name here
        File f = new File(downloadPath);

        if (f.exists()) {
            System.out.println("✅ File download complete: " + f.getName());
        } else {
            System.out.println("❌ File not found in Downloads.");
        }

        // Close browser
        driver.quit();
    }
}
