package automation.training;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features",
        glue = "automation.training",
        publish = true,
        tags = "@smoke",
        plugin = {"pretty", "html:target/testreport.html","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class Runner extends AbstractTestNGCucumberTests {

}
