package conf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser 
{
	public static WebDriver driver;
	public void firefox(String url)
	{
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\rnapa\\workspace\\JAR\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	public void chrome(String url)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rnapa\\workspace\\JAR\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	public void ie(String url)
	{
		System.setProperty("webdriver.ie.driver", "C:\\Users\\rnapa\\workspace\\JAR\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
}
