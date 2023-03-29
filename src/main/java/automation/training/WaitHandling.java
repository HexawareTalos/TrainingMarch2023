package automation.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitHandling {


    /**
     * Wait Handling
     * 1. Implicit Wait   - Applied globally on driver level - default time of implicit -Zero
     * 2. Explicit Wait   - Applied for every element individually  - default wait - 250ms
     * 3. Fluent Wait
     *
     * @param args
     */

    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
        driver.manage().window().maximize(); //implicit
        driver.get("https://parabank.parasoft.com/parabank/index.htm");


        driver.findElement(By.linkText("Register")).click();
        driver.findElements(By.partialLinkText("About Us")).get(1).click();
        /*
         *Explicit wait
         */
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(60));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("input[name='username']")))).sendKeys("Admin");;
        driver.findElement(By.name("password")).sendKeys("admin123");

//fluent wait
        Wait fluentwait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(Exception.class);

        /**
         *
         */
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        fluentwait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='submit']")));
        driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

    }
    }
