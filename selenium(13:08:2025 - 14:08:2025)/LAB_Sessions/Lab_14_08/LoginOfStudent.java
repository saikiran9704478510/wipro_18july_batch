package Labs_14_08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginOfStudent {
    public static void main(String[] args) throws InterruptedException {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open the form URL
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        Thread.sleep(2000);

        // Fill Name
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Saswat Pati");
        Thread.sleep(1500);

        // Fill Email
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("saswatliku@example.com");
        Thread.sleep(1500);

        // Select Gender
        driver.findElement(By.xpath("//label[text()='Male']/preceding-sibling::input")).click();
        Thread.sleep(1500);

        // Mobile number
        driver.findElement(By.xpath("//input[@id='mobile']")).sendKeys("9876543210");
        Thread.sleep(1500);

        // Date of Birth
        WebElement dobField = driver.findElement(By.xpath("//input[@id='dob']"));
        dobField.sendKeys("06/02/2002"); // MM/DD/YYYY
        Thread.sleep(1500);

        // Subjects
        driver.findElement(By.xpath("//input[@id='subjects']")).sendKeys("Computer Science");
        Thread.sleep(1500);

        // Hobbies
        driver.findElement(By.xpath("//label[text()='Sports']/preceding-sibling::input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Reading']/preceding-sibling::input")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[text()='Music']/preceding-sibling::input")).click();
        Thread.sleep(1500);

        // Upload Picture
        driver.findElement(By.xpath("//input[@id='picture']"))
              .sendKeys("C:\\Users\\HP\\OneDrive\\Pictures\\Screenshots\\Screenshot 2024-05-09 093533.png");
        Thread.sleep(2000);

        // Current Address
        driver.findElement(By.xpath("//textarea[@placeholder='Currend Address']"))
              .sendKeys("lc-147/23, Sailashree vihar , Chandrasekharpur");
        Thread.sleep(2000);

        // Select State
        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));
        stateDropdown.selectByVisibleText("Uttar Pradesh");
        Thread.sleep(1500);

        // Select City
        Select cityDropdown = new Select(driver.findElement(By.xpath("//select[@id='city']")));
        cityDropdown.selectByVisibleText("Lucknow");
        Thread.sleep(2000);
        
        //Login
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();
       
        
        // Final confirmation
        System.out.println("Form filled successfully!");
        

        
    }
}


