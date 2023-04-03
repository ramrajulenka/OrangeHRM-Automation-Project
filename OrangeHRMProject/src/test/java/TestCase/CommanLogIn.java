package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Pages.HRMHomePage;
import utility.BaseClass;

public class CommanLogIn extends BaseClass{
	@Test(description = "Login Positive Test case with valid username and password")
	public	void LogInForAllPage(WebDriver driver) {
		driver.manage().window().maximize();
			HRMHomePage log=new HRMHomePage(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get(url);
			log.setUsername(global_userName);
			log.setPassword(global_password);
			log.clickButton();
			
		}
}
