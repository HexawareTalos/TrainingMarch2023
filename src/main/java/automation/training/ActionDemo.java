package automation.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionDemo {
    public static void main(String[] args) {
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
/**
 * Actions
 */

        driver.get("https://demoqa.com/buttons");

        Actions actions = new Actions(driver);  //instantiate
        WebElement doubleClickButtonEle = driver.findElement(By.id("doubleClickBtn"));

        actions.doubleClick(doubleClickButtonEle); // action
        actions.perform();  // - to perform on UI


        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

        WebElement rightclickEle = driver.findElement(By.id("rightClickBtn"));
        actions.contextClick(rightclickEle).perform();

        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

        /**
         * JavaScriptExecutor
         */
        driver.get("https://demoqa.com/text-box");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('userName').value='Selenium Automation';");

        /**
         * Alert Handling
         * 1. accept
         * 2. dismiss
         * 3. sendKeys();
         * 4.getText();
         */
        driver.get("https://demoqa.com/alerts");
      driver.findElement(By.id("alertButton")).click();
        driver.switchTo().alert().accept();
        driver.findElement(By.id("timerAlertButton")).click();
        WebDriverWait  wait =new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("QA Test Automation");
        driver.switchTo().alert().accept();

        /**
         * Switch iframes
         */
        driver.get("https://demoqa.com/frames");

        driver.switchTo().frame("frame1");
        System.out.println(driver.findElement(By.id("sampleHeading")).getText());

        driver.switchTo().defaultContent();

    }
    }
