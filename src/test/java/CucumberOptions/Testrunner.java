package CucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features= "src/test/java/features",
        glue="StepDefinitions"
)
public class Testrunner extends AbstractTestNGCucumberTests {

}
