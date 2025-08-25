package test_ng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testng_parameters {

    @Parameters({"browser", "platform"})
    @Test
    public void testparameters(String browser, String platform) {
        WebDriver driver = null;

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();   // geckodriver for macOS
                FirefoxOptions ffOpt = new FirefoxOptions();
                // ffOpt.addArguments("--headless");        // uncomment if desired
                driver = new FirefoxDriver(ffOpt);
                break;

            case "edge":
                WebDriverManager.edgedriver().setup();      // msedgedriver for macOS
                EdgeOptions edgeOpt = new EdgeOptions();
                // edgeOpt.addArguments("--headless");      // uncomment if desired
                driver = new EdgeDriver(edgeOpt);
                break;

            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("Running on " + platform + " with " + browser);
        driver.quit();
    }
}