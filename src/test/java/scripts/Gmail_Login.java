package scripts;

import org.testng.annotations.Test;

import conf.LaunchBrowser;
import customization.ActionDrivers;
import or.Compose_Page;
import or.Login_Page;
import or.Logout_Page;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Gmail_Login extends LaunchBrowser {
  @Test
  public void test1Login() throws InterruptedException 
  {
	  firefox("https://gmail.com");
	  Assert.assertEquals("Gmail", driver.getTitle());
	  ActionDrivers.textField(Login_Page.uname_tfield, "naparameshbabu@gmail.com");
	  ActionDrivers.button(Login_Page.next_btn);
	  Thread.sleep(1000);
	  ActionDrivers.textField(Login_Page.pwd_tfield, "9652461364");
	  ActionDrivers.checkbox(Login_Page.stay_signed_in_cbox);
	  ActionDrivers.button(Login_Page.sign_in_btn);
	  Assert.assertEquals("Gmail", driver.getTitle());
  }
  
  @Test
  public void test2Compose() throws InterruptedException
  {
	  ActionDrivers.button(Compose_Page.compose_btn);
	  ActionDrivers.textField(Compose_Page.to_tarea, "naparameshbabu@gmail.com");
	  ActionDrivers.textField(Compose_Page.subject_tarea, "Automation Email from Ramesh");
	  ActionDrivers.textField(Compose_Page.message_body_tarea, "This is a Automation Test mail from Ramesh");
	  ActionDrivers.button(Compose_Page.send_btn);
	  Thread.sleep(1000);
	  String expectrd_str = "Your message has been sent. View message";
	  String actual_str = driver.findElement(By.cssSelector(".vh")).getText();
	  System.out.println(actual_str);
	  if (expectrd_str.equals(actual_str))
	  {
		  System.out.println("Sent an email successfully");
	  }
	  else
	  {
		  System.out.println("Failed sending an email");
	  }
  }
  
  @Test
  public void test3Logout()
  {
	  ActionDrivers.button(Logout_Page.profile_btn);
	  ActionDrivers.link(Logout_Page.sign_out_link);
	  
  }
}
