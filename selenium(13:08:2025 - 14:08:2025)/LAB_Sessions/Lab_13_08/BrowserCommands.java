package Labs_13_08;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserCommands {

    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeOptions
        ChromeOptions chromeOptions = new ChromeOptions();

        // Setup WebDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create WebDriver instance
        WebDriver driver = new ChromeDriver(chromeOptions);

        // Open Facebook
        driver.get("https://www.facebook.com/");

        // Maximize window
        driver.manage().window().maximize();
        Thread.sleep(1000);

        // Get and print page title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        // Get and print page source
        String pageSource = driver.getPageSource();
        System.out.println("Page Source: " + pageSource);

        // Get and print current URL
        String url = driver.getCurrentUrl();
        System.out.println("Current URL: " + url);

        // Close browser
        driver.close();
    }
}


