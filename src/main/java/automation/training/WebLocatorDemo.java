package automation.training;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebLocatorDemo {
	
	/*
	 * 1. ID   - attribute -80%
	 * 2. Name - attribute 
	 * 3. Css selector -95%  
	 * 4. xpath -95%
	 * 5. classname - attribute    1%
	 * 6. linktext   -   hyperlinks  <a>
	 * 7. partial linktext   - <a>
	 * 8. tagname    - iframes  1%
	 * 
	 * Relative locator 
	 * above
	 * below
	 * right of 
	 * left of
	 * near
	 * 
	 */

	
	
	/**
	 * 1.  ID  - 80%
	 * 
	 * <input id="customer.firstName" name="customer.firstName" class="input" type="text" value="">
	 * @throws InterruptedException 
	 */
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://parabank.parasoft.com/parabank/register.htm");
		
		WebElement firstnameEle = driver.findElement(By.id("customer.firstName"));
		firstnameEle.clear();
		firstnameEle.sendKeys("john");
		
		
		driver.findElement(By.id("customer.lastName")).sendKeys("test");
	
		
		/**
		 * 2. Name
		 */
		driver.findElement(By.name("customer.lastName")).clear();
		
		

		/**
		 * 3.xpath
		 */
		/*
		 * 1. absolute xpath - (forward slash /) traverse from root node 
		 * 
		 * 2. relative xpath (//)
		 */
		
		//1. tagname and attribute
		
		//<tagname>[@attribute-name="<value>"]
		
		driver.findElement(By.xpath("//form[@name='login']/div[3]/input")).sendKeys("john");
		
		// 2. any tag with attribute values 
		//*[@attribute-name="<value>"]
		
		
		//3. more than one attribute //*[@attribute-name="<value>"][@attribute-name="<value>"]
		/**
		 * AND  //input[@name='username'][@type='text']
		 * OR
		 */
		
		//4. text contains
		//tagname[contains(text(),'<value>')]
		
		//attribute contains
		//input[contains(@name,'zipCode')]
		
		//5. text()#
		
		//a[text()='Register']   --> exact match of given text value
		
	
		//xpath Axes
		/*
		 * 1. following
		 * 2.ancestor
		 * 3. child  /
		 * 4.parent
		 * 5. preceding
		 * 6. following-sibling
		 * 7. self
		 * 9.descendant  //
		 * 
		 */
		
		
		
		Thread.sleep(5000);
		driver.quit();
		
		//d934c426-abf1-7e77-4f96-9adc60351c66
		//22476379-b75a-c8dd-4fa9-96b05888ab65
		
		
	}
}
