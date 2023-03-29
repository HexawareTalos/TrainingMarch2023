package automation.training;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FormHandling {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();

		driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
		driver.findElement(By.xpath("//input[@value=\"Male\"]")).click();
		driver.findElement(By.xpath("//input[@value=\"Automation Tester\"]")).click();
		
		
		Select select = new Select(driver.findElement(By.name("selenium_commands")));
		boolean ismultiple = select.isMultiple();
		System.out.println("is multiselect dropdown -> "+ismultiple);
		if(ismultiple) {
			select.selectByVisibleText("Browser Commands");
			select.selectByVisibleText("Wait Commands");
			select.selectByVisibleText("Switch Commands");
		}else {
			select.selectByVisibleText("Wait Commands");
		}
		
		System.out.println("ALL Options ---");
		
		select.getOptions().forEach((str)->{
			System.out.println(str.getText());
		});
		
				
		System.out.println("selected Options ---");
		select.getAllSelectedOptions().forEach((str)->{
			System.out.println(str.getText());
		});
		
	}
}
