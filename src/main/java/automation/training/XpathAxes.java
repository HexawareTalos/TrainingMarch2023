package automation.training;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathAxes {
	// div[@class="orangehrm-container"]/div[@role='table']/div[@class="oxd-table-body"]

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		
		driver.findElement(By.linkText("Register")).click();
		driver.findElements(By.partialLinkText("About Us")).get(1).click();

		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	
		
		
		/**
		 * css selector
		 */
		//  ^  -  Starts with
		//	$  - ENdswith
		//	*  - contains
				
		
		
		driver.findElement(By.xpath("//a/span[text()='Admin']")).click(); // replace with link text

		By username = RelativeLocator.with(By.tagName("input")).above(By.xpath("//label[text()='Username']"));
		driver.findElement(username).sendKeys("Admin");
		
		List<WebElement> rows = driver.findElements(By.xpath(
				"//div[@class=\"orangehrm-container\"]/div[@role='table']/div[@class=\"oxd-table-body\"]/child::div"));
		System.out.println(rows.size());
		
		for (int i = 1; i <= rows.size(); i++) {
		
			WebElement employeeNameEle=driver.findElement(By.xpath("//div[@class=\"orangehrm-container\"]/div[@role='table']/div[@class=\"oxd-table-body\"]/child::div["+i+"]/div/div[@role=\"cell\"][4]/div"));
			System.out.println(employeeNameEle.getText());
		}
		String name="Garry White";
		
		String xpath="//div[text()='"+name+"']/ancestor::div[2]/div[1]//input"; //div[text()='Garry White']/ancestor::div[2]/div[1]//input
	}
}
