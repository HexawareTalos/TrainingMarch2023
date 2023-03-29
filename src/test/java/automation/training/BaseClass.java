package automation.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class BaseClass {
    public static WebDriver driver;
    public static WebDriver driverCreation(){
        WebDriverManager.edgedriver().setup();
         driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); //implicit
        return  driver;
    }
}
