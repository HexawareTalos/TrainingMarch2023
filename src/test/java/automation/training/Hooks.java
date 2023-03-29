package automation.training;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hooks {
    /**
     * Before and After
     */

    @Before
    public static void setUp(){
        System.out.println("Inside Before - SetUp Driver");
        DriverManager.setDriver();
    }

    @After
    public static  void tearDown(Scenario scenario){
        System.out.println("Inside After - TearDown Driver");
        /**
         * Check the Scenario is passed or Failed
         */
        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        DriverManager.tearDown();
    }

//
//    @AfterStep
//    public void screenShot(Scenario scenario){
//        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
//        scenario.attach(screenshot,"image/png",scenario.getName()+"_"+scenario.getLine());
//    }


}
