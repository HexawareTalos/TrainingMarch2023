package automation.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WindowHandling {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize(); //implicit
        driver.get("https://demoqa.com/browser-windows");

        //driver.getWindowHandle()   - String
        //driver.getWindowHandles() -  Set<String>
        System.out.println(driver.getWindowHandle());
        String parentWindow= driver.getWindowHandle();

        driver.findElement(By.id("tabButton")).click();
        System.out.println("New Tab opened");
       driver.getWindowHandles().forEach((str)->{
            System.out.println(str);
        });

//       driver.switchTo().newWindow(WindowType.WINDOW);
//       driver.switchTo().newWindow(WindowType.TAB);

        Set<String> allwindows = driver.getWindowHandles();

        for (String window:allwindows) {
            System.out.println("-----> iterated window ID -> "+ window);
            if(!window.equals(parentWindow)){
                driver.switchTo().window(window);

                System.out.println(driver.getTitle());
                String heading=driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(heading);
               driver.close();
               driver.switchTo().window(parentWindow);
                System.out.println(driver.getTitle());
            }
        }

    }
    }
