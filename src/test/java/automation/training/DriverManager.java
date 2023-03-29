package automation.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;


public class DriverManager {
    /**
     * create Driver
     */

    private static DriverManager driverManager;

    private static WebDriver driver;

    private DriverManager() {
        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    public static void openURL(String url) {
        driver.get(url);
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setDriver() {
        if (driverManager == null) {
            driverManager = new DriverManager();
        }
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        driverManager = null;
    }
}
