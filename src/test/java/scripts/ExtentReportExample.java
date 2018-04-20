package scripts;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportExample 
{
	ExtentReports  extent;
	ExtentTest	test;
	WebDriver driver;
	@BeforeTest
	public void startReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir") + "\\Reports\\TestReport.html", true);
		extent.addSystemInfo("Host Name", "SoftwareTestingMaterial");
		extent.addSystemInfo("Environment", "Automation Testing");
		extent.addSystemInfo("User Name", "Ramesh");
		extent.loadConfig(new File("C:\\Users\\rnapa\\workspace\\JAR\\extentreports-java-2.41.2\\extent-config.xml"));
	}
	
	@BeforeMethod
	public void initilizeBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rnapa\\workspace\\JAR\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void test1()
	{
		test = extent.startTest("passTest");
		driver.get("https://accounts.google.com");
		Assert.assertEquals("Sign in - Google Accounts", driver.getTitle());
		//To generate the log when the test case is passed
		test.log(LogStatus.PASS, "Test Case Passed");
	}
	
	@Test(enabled=false)
	public void test2()
	{
		test = extent.startTest("passTest");
		driver.get("https://www.facebook.com/");
		Assert.assertEquals("Facebook", driver.getTitle());
		//To generate the log when the test case is passed
		test.log(LogStatus.PASS, "Test Case Passed");
	}
	
	@Test
	public void skipTest(){
		test = extent.startTest("skipTest");
		throw new SkipException("Skipping - This is not ready for testing ");
	}
	
	@AfterMethod
	public void closeBrowser(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
			test.log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
		}
		extent.endTest(test);
		driver.quit();
	}
	
	@AfterTest
	public void endReport()
	{
		extent.flush();
		extent.close();
	}
}
