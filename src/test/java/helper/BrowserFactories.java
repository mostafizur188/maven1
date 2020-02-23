package helper;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactories {


	
	 public static WebDriver startBrowser(String browserNa, String url){
		
			 WebDriver driver = null;
			
		if(browserNa.equalsIgnoreCase("firefox")){
			driver = new FirefoxDriver();
			
		}
		
		else if(browserNa.equalsIgnoreCase("chrome")){
			
			//  /Users/mostafizurrahman/Documents/workspace/sample/drivers
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			 
			System.setProperty("webdriver.chrome.driver", "/Users/mostafizurrahman/Documents/chromedriver");
			driver = new ChromeDriver();
		}
		
		else if (browserNa.equalsIgnoreCase("IE")){
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
}
