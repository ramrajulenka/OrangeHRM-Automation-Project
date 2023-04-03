package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HRMReportingMethodPage {
	
public static	WebDriver ldriver;
	public HRMReportingMethodPage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
			
			
	}
	@FindBy(xpath="//span[normalize-space()=\"PIM\"]")
	WebElement clickPim;
	@FindBy(xpath="(//span[@class='oxd-topbar-body-nav-tab-item'])[1]")
	WebElement configDropDown;
	@FindBy(linkText ="Reporting Methods")
	WebElement reportingMethod;
	@FindBy(xpath="//button[normalize-space()='Add']")
    WebElement clickAddReport;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
    WebElement reportingNameElement;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")
    WebElement clickSaveBtn;
	@FindBy(xpath="//div[@id=\"oxd-toaster_1\"]")
	WebElement verifyMsg;
	@FindBy(xpath="(//i[@class='oxd-icon bi-pencil-fill'])[1]")
	WebElement editIconElement;
	@FindBy(xpath="//div[@role='table']//div[1]//div[1]//div[3]//div[1]//button[1]//i[1]")
	WebElement deleteIcon;
	@FindBy(xpath="//button[normalize-space()='Yes, Delete']")
	WebElement conformdelet;
	@FindBy(xpath="//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	WebElement errorMsg;
	@FindBy(xpath="//div[@role=\"columnheader\"]//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
	WebElement selectUnusedNames;
	@FindBy(xpath="//button[normalize-space()=\"Delete Selected\"]")
	WebElement clickYesDelete;
	@FindBy(xpath="//span[@class=\"oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message\"]")
	WebElement alreadyExistedElement;
	
	public void landOnReportingMethodPage() {
		clickPim.click();
		configDropDown.click();
		reportingMethod.click();
	}
	public void clickAddNewReport() {
		clickAddReport.click();
	}
	public void reportMethodName(String name) {
		reportingNameElement.sendKeys(name);
	}
	public void saveButton() {
		clickSaveBtn.click();
		
	}
	 public void verifySuccesFullMsg() {
		 String elemnt=verifyMsg.getText();
		 Assert.assertNotNull(elemnt);
		
	}
	 public void clickEditIcon() {
			editIconElement.click();
			
		}
public void clearData() {
	reportingNameElement.clear();	
	}
public void deleteReportMthd() {
	deleteIcon.click();
	
}
public void conformDelete() {
	conformdelet.click();
	
}
public void verifyEmptyMsg() {
	String errorLableMsg=errorMsg.getText();
	Assert.assertEquals("Required", errorLableMsg);
	
}
public void deleteUnUsedRepotMethods() {
	selectUnusedNames.click();
	clickYesDelete.click();
}
public void verifyAlreadyExistedMsg() {
	String existedMsg=alreadyExistedElement.getText();
	Assert.assertEquals("Already exists", existedMsg);
}
}
