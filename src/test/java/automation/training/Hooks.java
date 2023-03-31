package automation.training;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterClass;

import java.io.File;


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

//    @AfterClass
//    public static void writeExtentReport() {
//        Reporter.loadXMLConfig(new File(getReportConfigPath()));
//    }
//    public static String getReportConfigPath(){
//        String reportConfigPath = "src/test/resources/extent-config.xml";
//        if(reportConfigPath!= null) return reportConfigPath;
//        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
//    }


}
