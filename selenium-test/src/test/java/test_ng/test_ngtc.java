package test_ng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test_ngtc {
    @Test
	public void launchbrowser() {
//		ChromeOptions chromeOptions = new ChromeOptions();
// 
//		WebDriverManager.chromedriver().setup();
// 
//		WebDriver driver = new ChromeDriver(chromeOptions);
    	FirefoxOptions opts = new FirefoxOptions();
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(opts);
 
		driver.get("https://the-internet.herokuapp.com/windows");
		// maximize the window
		driver.manage().window().maximize();
	}
}
