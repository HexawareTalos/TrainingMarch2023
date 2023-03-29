package automation.training;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features",
        glue = "automation.training",
        publish = true,
        tags = "@Regression",
        plugin = {"pretty", "html:target/testreport.html"})
public class Runner extends AbstractTestNGCucumberTests {

}
