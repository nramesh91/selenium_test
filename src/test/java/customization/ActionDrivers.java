package customization;

import org.openqa.selenium.By;

import conf.LaunchBrowser;
import or.Login_Page;

public class ActionDrivers extends LaunchBrowser
{
	public static void textField(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	public static void button(By locator)
	{
		driver.findElement(locator).click();
	}
	public static void checkbox(By locator)
	{
		driver.findElement(locator).click();
	}
	public static void link(By locator)
	{
		driver.findElement(locator).click();
	}
}
