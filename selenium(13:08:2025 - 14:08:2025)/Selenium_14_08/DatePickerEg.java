package com.wipro.JavaSelenium_14_08;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerEg {

    public static void main(String[] args) throws InterruptedException {
        
        ChromeOptions chromeOptions = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.get("https://ui.shadcn.com/docs/components/date-picker");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Open date picker
        WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id='date']"));
        datePickerBtn.click();
        Thread.sleep(2000);

        // Select first date
        WebElement daypicker1 = driver.findElement(By.xpath("//button[@data-day='8/13/2025']"));
        daypicker1.click();
        Thread.sleep(2000);

        // Open date picker again
        datePickerBtn.click();
        Thread.sleep(2000);

        // Select second date
        WebElement daypicker2 = driver.findElement(By.xpath("//button[@data-day='8/22/2025']"));
        daypicker2.click();
        Thread.sleep(2000);

        
    }
}


