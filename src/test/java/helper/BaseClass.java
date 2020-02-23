package helper;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import dataProviderFactory.DataProviderFactory;

public class BaseClass {
	// we are creating object so we can reference back to them
	//instead of calling the jar files everytime
	
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupReport()
	{
		System.out.println("Log In- Before Suite Running- Setting up Report");
		//ap is the staritng of the report that we are going to generated
		//.html is the file formatconfig.properties
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/AP_"+Utility.getTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(reporter);
		System.out.println("Log In- After Suite Running- Reports are ready to use");
	}
		@BeforeClass
		public void setupBrowser()
		{		
			System.out.println("LOG:INFO: Creating Browser Session");
			driver=BrowserFactories.startBrowser(	// we need to use the broswerfactories to open the application either IE or chrome or firefox
					DataProviderFactory.getConfig().getBrowser()
					,DataProviderFactory.getConfig().getStagingURL());
					System.out.println("LOG:INFO: Browser Session Created");
		}
		
		@AfterMethod
		public void appendReport(ITestResult result)//calling independenci Itestresult from the testng result
		{
			System.out.println("Test Name "+ result.getName());
			System.out.println("LOG:INFO- After method Running - Generating test Report");
			int status = result.getStatus();// the reason why we use the int, its bc result will be in integer
			if(status==ITestResult.SUCCESS)
			{
				try
				{							//mediaentitymodelprovide is from the java . and we need build at the end bcause this is the action
					logger.pass("Test Scenario Passed ",MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
	
				}catch(IOException e)
				{
					System.out.println("NOT able to to attach Screenshot "+e.getMessage());
				}
			}
			else if(status==ITestResult.FAILURE)
			{
				try
				{						//getthrowable means the script is running, but is not running bc of some reason
					logger.fail("Test Failed "+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenShot(driver)).build());
				}
				catch(IOException e)
				{
					System.out.println("NOT able to to attach Screenshot "+e.getMessage());
				}
				
			}
			else if(status==ITestResult.SKIP)
			{
				logger.skip("TestScenario Skipper");
			}
			report.flush();
			System.out.println("LOG:INFO- After method Executed- Test Result appended to report");
		}
		@AfterClass
		public void closeSessions()
		{
			System.out.println("LOG:INFO: Closing Browser Sessions");
			driver.quit();
			System.out.println("LOG:INFO: Browser session Closed");
		}
		
		
	}



/*
package helper;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	
	/*
	 * we are creating object so we can reference back to them
	 * instead of calling the jar files every time
	 * 
	 */
	/*
	public WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupReport(){
		System.out.println("LOG: INFO- Before Suit Running- Setting up Report");
		
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(new File(System.setProperty("user.dir") + "/Reports/AP_" + Utility.getTime() + ".html"));
	
		report = new ExtentReports();
		report.attachReporter(reporter);
		System.out.println("LOG: INFO- After Suite Running - Reports are ready to use");
		
	}
		@BeforeClass
		public void setupBrowser(){
			System.out.println("LOG: INFO - Creating Browser Session");
			
			driver = BrowserFactories.startBrowser(
					DataProviderFactory.getConfig().getBrowser()
					, DataProviderFactory.getConfig().getStagingURL());
			System.out.println("LOG: INFO - Browser Session Created");
	
	}
		
		@AfterMethod
		public void appendReport(ITestResult result){
			System.out.println("Test Name " + result.getName());
			
			System.out.println("LOG: INFO - After method Running - Generating test Report");
			
			int status = result.getStatus();
			
			if(status == ITestResult.SUCCESS){
				try{
					logger.pass("Test Scenario Passed " , MediaEntityModelProvider.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
				
				}catch(IOException e){
					System.out.println("Not able to attach screenshot " + e.getMessage());
				}
			}
			
			else if(status == ITestResult.FAILURE){
				
				try{
					logger.fail("Test Failed " + result.getThrowable().getMessage());
				}catch(IOException e){
					System.out.println("Not able to attach screenshot" + e.getMessage());
				}
			}else if(status == ITestResult.SKIP){
					logger.skip("Test Scenario skipper");
				}
			report.flush();
			System.out.println("LOG: INFO- After method Executed- Test Result appended to report ");
			}
		
		@AfterClass
		public void closeSessions(){
			System.out.println("LOG: INFO - closing Browser Sessios ");
			driver.quit();
			System.out.println("LOG: INFO - Browser session Closed");
		}
			
		}
*/

