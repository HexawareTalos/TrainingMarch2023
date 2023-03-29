package automation.training;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import pageLocators.LoginPage;

public class MyStepdefs {

    private  static final Logger log = LogManager.getLogger(MyStepdefs.class);
    WebDriver driver= DriverManager.getDriver();

    @Given("^user navigate to OHRM application$")
    public void userNavigateToOHRMApplication() {
        log.info("URL navigation");
        DriverManager.openURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("user login to application")
    public void userLoginToApplication() {
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.xpath("//button[@type='submit']")).click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login();
        System.out.println("Login successfull");
    }

    @When("user click {string} in menu list")
    public void userClickInMenuList(String menu) {
        driver.findElement(By.xpath("//a[contains(@href,'" + menu + "')]")).click();
    }

    @Then("user lands on {string} Page")
    public void userLandsOnPage(String pageName) {
        String expectedValue = driver.findElement(By.tagName("h6")).getText();
        Assert.assertEquals("Page not matches with expected value", pageName, expectedValue);
    }

    @When("User Enter FromDate as {string} and ToDate as {string}")
    public void userEnterFromDateAsAndToDateAs(String fromDate, String toDate) {
        By fromDateInput = RelativeLocator.with(By.xpath("//input")).near(By.xpath("//label[text()='From Date']"));
        By toDateInput = RelativeLocator.with(By.xpath("//input")).near(By.xpath("//label[text()='To Date']"));

        WebElement fromDateEle = driver.findElement(fromDateInput);
        WebElement toDateEle = driver.findElement(toDateInput);
        fromDateEle.clear();
        fromDateEle.sendKeys(fromDate);
        toDateEle.clear();
        toDateEle.sendKeys(toDate);

    }

    @And("select show leave status as {string}")
    public void selectShowLeaveStatusAs(String status) {
        By statusDropdown = RelativeLocator.with(By.xpath("//div[@class='oxd-select-text-input']")).near(By.xpath("//label[text()='Show Leave with Status']"));
        driver.findElement(statusDropdown).click();
        driver.findElement(By.xpath("//div[@role='listbox']//*[contains(text(),'" + status + "')]")).click();
    }

    @And("user click Search")
    public void userClickSearch() {
        driver.findElement(By.xpath("//button[text()=' Search ']")).click();

    }

    @Then("verify Successful login screen {string}")
    public void verifySuccessfulLoginScreen(String validation) {
        // driver.findELe("//Invalid credentials")
        //if(validation)
    }

}
