package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class deselect {

    public static void main(String[] args) throws InterruptedException {

        // 1️⃣ Start Firefox
        FirefoxOptions opts = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(opts);
        
        // 2️⃣ Go to the multi-select page
        driver.get("https://grotechminds.com/multiple-select/");

        // 3️⃣ Locate the <select> element
        WebElement selectElement = driver.findElement(By.xpath("//ul[@class='select2-selection__rendered']']"));
        Select multiSelect = new Select(selectElement);

        /* 4️⃣ SELECT OPTIONS */
        multiSelect.selectByVisibleText("Motorcycle");
        multiSelect.selectByVisibleText("Sedan");
        multiSelect.selectByVisibleText("Hatchback");
        multiSelect.selectByVisibleText("SUV");

        // Quick visual pause
        Thread.sleep(2000);

        /* 5️⃣ DE-SELECT ONE BY ONE */
        multiSelect.deselectByVisibleText("Motorcycle");
        Thread.sleep(1000);

        multiSelect.deselectByIndex(2); // 0-based → JavaScript
        Thread.sleep(1000);

        /* 6️⃣ SELECT AGAIN for demo */
        multiSelect.selectByVisibleText("Motorcycle");
        multiSelect.selectByVisibleText("Hatchback");
        Thread.sleep(1000);

        /* 7️⃣ DE-SELECT ALL AT ONCE */
        multiSelect.deselectAll();

        // 8️⃣ Close browser
        driver.quit();
    }
}