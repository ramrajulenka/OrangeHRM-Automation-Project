package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HRMTerminationReasonsPage {
public static	WebDriver ldriver;
	public HRMTerminationReasonsPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
			
	}
	@FindBy(xpath="//span[normalize-space()=\"PIM\"]")
	WebElement clickPim;
	@FindBy(xpath="//span[@class=\"oxd-topbar-body-nav-tab-item\"]")
	WebElement configDropDown;
	@FindBy(linkText ="Termination Reasons")
	WebElement terminationReason;
	@FindBy(xpath="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement clickAddTermination;
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']")
    WebElement terminationNameElement;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")
    WebElement clickSaveBtn;
	@FindBy(xpath="//div[@id='oxd-toaster_1']")
	WebElement verifyMsg;
	@FindBy(xpath="//div[@role=\"table\"]//div[1]//div[1]//div[3]//div[1]//button[1]//i[1]")
    WebElement deleteElement;
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
	WebElement conformdelet;
	@FindBy(xpath="//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	WebElement verifyRequidMsg;
	@FindBy(xpath="//div[@role=\"columnheader\"]//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
	WebElement selectallUnusedTerminton;
	@FindBy(xpath="//button[normalize-space()=\"Delete Selected\"]")
	WebElement clickYesDelete;
	@FindBy(xpath="//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	WebElement alreadyExistedElement;
	
	public void landOnTerminationReasonPage() {
		clickPim.click();
		configDropDown.click();
		terminationReason.click();
	}
	public void clickAddNewTerminationReason() {
		clickAddTermination.click();
	}
	public void terminationReasonName(String name) {
		terminationNameElement.sendKeys(name);
	}
	public void saveButton() {
		clickSaveBtn.click();
		
	}
	 public void verifySuccesFullMsg() {
		 String elemnt=verifyMsg.getText();
		 Assert.assertNotNull(elemnt);
		
	}
	public void deleteTermination() {
		deleteElement.click();
		conformdelet.click();
		
	}
public void verifyEmptMsg() {
	String errorMsg=verifyRequidMsg.getText();
	Assert.assertEquals("Required", errorMsg);
		
	}
public void deleteAllUnUsedTermtio() {
	selectallUnusedTerminton.click();
	clickYesDelete.click();
	conformdelet.click();
	
}
public void verifyAlreadyExistedMsg() {
	String existedMsg=alreadyExistedElement.getText();
	Assert.assertEquals("Already exists", existedMsg);
}
}
