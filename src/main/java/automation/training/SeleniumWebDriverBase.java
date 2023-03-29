package automation.training;

 
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumWebDriverBase {
	
	public static void main(String[] args) {
		
//		System.out.println(System.getProperty("user.dir"));
//		String worskspace=System.getProperty("user.dir");
//		
//		System.setProperty("webdriver.chrome.driver", worskspace+"/driver/chromedriver.exe");
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
//		Dimension d= new Dimension(2500, 1090);
//		driver.manage().window().setSize(d);
		
		driver.get("https://www.google.com/");
		driver.navigate().to("https://parabank.parasoft.com/parabank/index.htm");
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();

		driver.quit(); 
	}

}
