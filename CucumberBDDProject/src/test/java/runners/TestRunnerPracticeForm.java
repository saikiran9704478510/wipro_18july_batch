package runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features/PracticeForm.feature",
        glue = {"stepDefinitions","Hooks"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        monochrome = true,
        tags = "@form"
)
public class TestRunnerPracticeForm extends AbstractTestNGCucumberTests {
}
