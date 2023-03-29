package automation.training;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.locators.RelativeLocator.RelativeBy;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocatorDemo {
	public static void main(String[] args) throws InterruptedException, AWTException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		String username="admin";
		String password ="admin";
		
		driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/");
		
		WebElement countryDropdown = driver.findElement(By.xpath("//select"));
		
		Select select = new Select(countryDropdown);
		/*
		 * selectByIndex(0)
		 * selectByValue(value)
		 * selectByVisibleText(text)
		 */
		select.selectByValue("IND");
		select.selectByVisibleText("Curaçao");
		
		
		System.out.println(select.getFirstSelectedOption().getText());
		System.out.println("-----\n"+select.getOptions().size());
		
		select.getOptions().forEach((str)->{
			System.out.println(str.getText());
		});
		
		
		
//		
//		driver.findElement(By.name("username")).sendKeys("john");
//
//		driver.findElement(By.name("password")).sendKeys("demo");
//		driver.findElement(By.name("password")).sendKeys(Keys.ENTER);
//		
////		Robot r = new Robot();
////		r.keyPress(KeyEvent.VK_ENTER);
////		r.keyRelease(KeyEvent.VK_ENTER);
//		
//	/*
//	 * Java Dtae Api - current date -14 - mar - 2023
//	 * currentdate -10 // 4-mar-2023
//	 * 
//	 * list - store all months
//	 */
//		
//		/**
//		 * Date picker
//		 * 
//		 * textbox - editable
//		 * 
//		 */
//		
//		
//		
//		// above
//		By aboutUsHeaderLink = RelativeLocator.with(By.linkText("About Us")).above(By.id("loginPanel"));
//		driver.findElement(aboutUsHeaderLink).click();
//
//		// below
//		By sitemapLink = RelativeLocator.with(By.linkText("Site Map")).below(By.id("loginPanel"));
//		driver.findElement(sitemapLink).click();
//
//		driver.findElement(RelativeLocator.with(By.linkText("Site Map")).below(By.id("loginPanel"))).click();
//
//		driver.findElement(RelativeLocator.with(By.linkText("Bill Pay")).toRightOf(By.id("loginPanel"))).click();

		/**
		 * input text - sendkeys 
		 * password text - sendkeys 
		 * button - click 
		 * dropdown -
		 * select/unselect radio - click checkbox - click clear() textarea - sendkeys
		 * file upload - sendkeys links - click multi select dropdown - select calender
		 * 
		 * 
		 * window Handling/ switch frame switch alert handling - auth popup wait
		 * handling javascript executors Actions keyboard simulation
		 * 
		 * 
		 */
	}
}
