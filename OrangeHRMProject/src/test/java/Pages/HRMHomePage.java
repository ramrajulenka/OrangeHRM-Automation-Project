 package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HRMHomePage {
	public static WebDriver ldriver;
	public HRMHomePage(WebDriver driver) {
		ldriver=driver;
	PageFactory.initElements(driver, this);
	
	}
	
	@FindBy(name="username")
	WebElement usernameElement;
	@FindBy(name="password")
	WebElement passwordElement;
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginButtonElement;
	@FindBy(xpath="//i[@class=\"oxd-icon bi-caret-down-fill oxd-userdropdown-icon\"]")
	WebElement dropDown;
	@FindBy(linkText="Logout")
	WebElement logOutButton;
	@FindBy(xpath="//p[@class=\"oxd-text oxd-text--p oxd-alert-content-text\"]")
	WebElement invalidCredentialMsg;
	@FindBy(xpath = "//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	WebElement requirdMsg;
	@FindBy(xpath = "//h6[normalize-space()=\"Dashboard\"]")
	WebElement homePageLable;
	@FindBy(xpath = "//h5[normalize-space()=\"Login\"]")
	WebElement verifyLogout;
	
	public void setUsername(String username) {
		usernameElement.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordElement.sendKeys(password);
	}
	public void clickButton() {
		loginButtonElement.click();
	}
	public void logOut() {
		dropDown.click();
		logOutButton.click();
		
	}
   public void verifyInvalidCredential() {
	   
	   String verifyMsg=invalidCredentialMsg.getText();
	   Assert.assertEquals("Invalid credentials", verifyMsg);
	
}
   public void verifyingRequirdMsg() {
	   
	   String verifyMsg=requirdMsg.getText();
	   Assert.assertEquals("Required", verifyMsg);
	
}
	public void verifyHomePage() {
		String VerifyHomePagemsg=homePageLable.getText();
		Assert.assertEquals("Dashboard", VerifyHomePagemsg);
		
	}
	public void verifyLogOut() {
		String VerifyLogout=verifyLogout.getText();
		Assert.assertEquals("Login", VerifyLogout);
		
	}
}

