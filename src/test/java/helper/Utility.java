package helper;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//utility
//using meethodoverridding because same 
//we arecreating more methods
public class Utility {
	
	
			public static WebElement waitForWebElement(WebDriver driver, By element)
		{
			
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return driver.findElement(element);
			
		}
		public static WebElement waitForWebElement(WebDriver driver, WebElement element)
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			return element;
		}
		public static void validatemsg(WebElement element,String msg)
		{
			
			Assert.assertEquals(element.getText(), msg);
		}
		public static void validatPartialatext(WebElement element,String msg)
		{
			Assert.assertTrue(element.getText().contains(msg));
		}
		public static void valideTitle(WebDriver driver,String title)
		{
			
		 boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.titleIs(title));
		 Assert.assertTrue(status);
		} 
	
		public static void validatecontainsTitle(WebDriver driver,String URL)
		{
			 boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.titleContains(URL));
			 Assert.assertTrue(status);
	    }
		
		public static void validateContainsTitle(WebDriver driver, String title){
			boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.titleContains(title));
			Assert.assertTrue(status);
		}
		
		public static void verifyCurrentURL(WebDriver driver,String Url)
		{
			
			 boolean status = new WebDriverWait(driver,30).until(ExpectedConditions.urlContains(Url));
			 Assert.assertTrue(status);
		}
		
		public void dismissAlert(WebDriver driver)
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent()).dismiss();
		}
		public void AcceptAlert(WebDriver driver)
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.alertIsPresent()).accept();
			
		}
	public void VerifyAlert(WebDriver driver,String alert)
		{

	        }
		//4 ways to handle frame
		
		////1st way to handle frame using int
		public void handleFrame(WebDriver driver,int index)
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
		}
		//2nd way to handle frame using String
		public void handleframew(WebDriver driver,String call)
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(call));
		}
		//3rd way to handle frame using Webelement
		public void handleframe3(WebDriver driver,WebElement ele )
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(ele));
		}
		//4th way to handle frame using locator
		public void handleframe4(WebDriver driver,By locator)
		{
			new WebDriverWait(driver,30).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
		}
		public static String captureScreenShot(WebDriver driver)
		{
			String Time = getTime();
			String dest = System.getProperty("User.dir")+"/Screenshots/AP"+Time+".png";
					TakesScreenshot ts =(TakesScreenshot)driver;
					
					File src =ts.getScreenshotAs(OutputType.FILE);
			
					try{
						FileHandler.copy(src, new File(dest));
					} catch (IOException e)
					{
						System.out.println("screenshot failed"+e.getMessage());
					}
					return dest;
					}
		
			public static String getTime()
			{
				DateFormat dateFormat = new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
						return dateFormat.format(new Date());
			}
		}

