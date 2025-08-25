package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DatePicker {
    public static void main(String[] args) throws InterruptedException {

        // Firefox Options
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(firefoxOptions);

        // Launch URL
        driver.get("https://ui.shadcn.com/docs/components/date-picker");
        driver.manage().window().maximize();

        // Open date picker
        WebElement datePickerBtn = driver.findElement(By.xpath("//*[@id='date']"));
        datePickerBtn.click();
        Thread.sleep(2000);

        // Select first date
        WebElement dayPicker1 = driver.findElement(By.xpath("//button[@data-day='8/13/2025']"));
        dayPicker1.click();
        Thread.sleep(2000);

        // Open date picker again
        datePickerBtn.click();
        Thread.sleep(2000);

        // Select second date
        WebElement dayPicker2 = driver.findElement(By.xpath("//button[@data-day='8/22/2025']"));
        dayPicker2.click();
        Thread.sleep(2000);

        // Close browser
        driver.quit();
    }
}
