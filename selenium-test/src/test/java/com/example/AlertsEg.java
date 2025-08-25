package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsEg {

    public static void main(String[] args) throws InterruptedException {

        /* ---------- 1. Launch Firefox ---------- */
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions opts = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(opts);
        driver.manage().window().maximize();

        /* ---------- 2. Open the practice page ---------- */
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        /* ---------- 3. JS Alert (simple) ---------- */
        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert simple = driver.switchTo().alert();
        System.out.println("Alert text: " + simple.getText());
        simple.accept();               // Click OK
        Thread.sleep(1000);

        /* ---------- 4. JS Confirm ---------- */
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        Alert confirm = driver.switchTo().alert();
        System.out.println("Confirm text: " + confirm.getText());
        confirm.dismiss();             // Click Cancel
        Thread.sleep(1000);

        /* ---------- 5. JS Prompt ---------- */
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        Alert prompt = driver.switchTo().alert();
        prompt.sendKeys("Hello from Selenium");
        System.out.println("Prompt text: " + prompt.getText());
        prompt.accept();               // Click OK
        Thread.sleep(1000);

        /* ---------- 6. Verify the result label ---------- */
        String result = driver.findElement(By.id("result")).getText();
        System.out.println("Result on page: " + result);

        /* ---------- 7. Clean-up ---------- */
        Thread.sleep(2000);
        driver.quit();
    }
}