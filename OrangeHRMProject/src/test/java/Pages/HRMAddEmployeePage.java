package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;


public class HRMAddEmployeePage {
public static WebDriver ldriver;
	public HRMAddEmployeePage(WebDriver driver) {
		ldriver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[normalize-space()=\"PIM\"]")
	WebElement clickPim;
	@FindBy(xpath="//a[normalize-space()='Add Employee']")
	WebElement clickAddEmp;
	@FindBy(xpath="//h6[normalize-space()=\"Add Employee\"]")
	WebElement addEmpLableElmt;
	@FindBy(xpath="//input[@placeholder='First Name']")
	WebElement firstNameField;
	@FindBy(xpath="//input[@placeholder='Middle Name']")
	WebElement middleNameField;
	@FindBy(xpath="//input[@placeholder='Last Name']")
	WebElement lastNameField;
	@FindBy(xpath="/html[1]/body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[2]/button[2]")
	WebElement clickSaveBtn;
	@FindBy(xpath="//i[@class=\"oxd-icon bi-plus\"]")
	WebElement imageUpload;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/label[1]/span[1]")
	WebElement createLoginDetailsElement;
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[3]")
	WebElement userNameElement;
	@FindBy(xpath="(//input[@type='password'])[1]")
	WebElement passwordElement;
	@FindBy(xpath="(//input[@type='password'])[2]")
	WebElement conformPassElement;
	@FindBy(xpath="//a[normalize-space()='Employee List']")
	WebElement employeeListElement;
	@FindBy(xpath="//div[@id='oxd-toaster_1']")
	WebElement verifyLableElmt; 
    @FindBy(xpath="//button[normalize-space()='Search']")
	WebElement searchBtn;
    @FindBy(xpath="(//i[@class='oxd-icon bi-trash'])[1]")
	WebElement deleteIcon;
    @FindBy(xpath="//button[normalize-space()='Yes, Delete']")
   	WebElement conformDelete;
    @FindBy(xpath="//h6[normalize-space()=\"Personal Details\"]")
   	WebElement addEmpLandPageMsg;
    @FindBy(xpath="//div[@role=\"columnheader\"]//i[@class=\"oxd-icon bi-check oxd-checkbox-input-icon\"]")
	WebElement selectMultipleEmp;
	@FindBy(xpath="//button[normalize-space()=\"Delete Selected\"]")
	WebElement clickYesDelete;
	@FindBy(xpath="(//input[@placeholder='Type for hints...'])[1]")
	WebElement employeeNameSearch;
	@FindBy(xpath="//div[@class=\"oxd-input-group\"]//div[1]//span[1]")
	WebElement firstNameRequirdMsg;
	@FindBy(xpath="//div[3]//span[1]")
	WebElement lastNameRequirdMsg;
	@FindBy(xpath="//span[normalize-space()=\"Should be at least 5 characters\"]")
	WebElement crateLogLessUserChar;
	@FindBy(xpath="//span[normalize-space()=\"Should have at least 8 characters\"]")
	WebElement crateLogLessPassChar;
	@FindBy(xpath="//span[normalize-space()=\"Should not exceed 40 characters\"]")
	WebElement crateLogMoreUserChar;
	@FindBy(xpath="//span[normalize-space()=\"Should not exceed 64 characters\"]")
	WebElement crateLogMorePassChar;
	@FindBy(xpath="//div[contains(text(),\"Varun Dhawan\")]")
	WebElement searchEmpLableElmnt;
	
	
	public void clickPim() {
		   clickPim.click();
		
	}
   public void clickAddEmp() {
	
	   clickAddEmp.click();
		
	}
   public void verifyAddEmpPage() {
	   String addEmp=addEmpLableElmt.getText();
	   Assert.assertEquals("Add Employee", addEmp);
	   
	
}
   public void enterEmpData(String firstName,String middleName,String lastName) {
	   firstNameField.sendKeys(firstName);
	   middleNameField.sendKeys(middleName);
	   lastNameField.sendKeys(lastName);	
}
   public void saveBtn() {
	   clickSaveBtn.click();
	
}

   public void clickCreateLogInSetails() {
	   createLoginDetailsElement.click();
}
 
   public void setUserName(String username) {
	   userNameElement.sendKeys(username);
}
   public void setPassword(String password ,String conformPass) {
	 passwordElement.sendKeys(password);
	 conformPassElement.sendKeys(conformPass);
	   
}
   public void employeeList() {
	   employeeListElement.click();	
} 
 public void clickSearchBtn() {
	 searchBtn.click();
	
}

 public void deleteEmp() {
	 deleteIcon.click();
	
	
}
 public void conformDelete() {
	 conformDelete.click();	
}
 public void verifySuccesFullLable() {
	 String elemnt=verifyLableElmt.getText();
	 Assert.assertNotNull(elemnt);
	
}
 public void verifyPersonalDetailsLable() {
	 String landingMsg=addEmpLandPageMsg.getText();
	 Assert.assertEquals("Personal Details", landingMsg);
	
}
 public void clearEmpData() {
	 firstNameField.clear();
	 middleNameField.clear();
	 lastNameField.clear();
	
}
 public void deleteMultipleEmp() {
		selectMultipleEmp.click();
		clickYesDelete.click();
		conformDelete.click();
		
	}
 public void searchEmployee(String empName) {
	 employeeNameSearch.sendKeys(empName);
	
}
 public void verifyNameRequrdMassage() {
	 String firstNameRqd=firstNameRequirdMsg.getText();
	 String lastNameRqd=lastNameRequirdMsg.getText();
	 Assert.assertEquals("Required",firstNameRqd);
	 Assert.assertEquals("Required", lastNameRqd);
	
}
 public void verifyUserAndPassNameLessChar() {
	 String lessCharPassVerfMsg=crateLogLessPassChar.getText();
     String lessCharuserNameVerfMsg=crateLogLessUserChar.getText();				
	 Assert.assertEquals("Should have at least 8 characters", lessCharPassVerfMsg);
     Assert.assertEquals("Should be at least 5 characters", lessCharuserNameVerfMsg);
	
}
 public void verifyUserAndPassMoreChar() {
	    String moreCharuserNameVerfMsg=crateLogMoreUserChar.getText();
		String moreCharPassVerfMsg= crateLogMorePassChar.getText();
		Assert.assertEquals("Should not exceed 40 characters", moreCharuserNameVerfMsg);
		Assert.assertEquals("Should not exceed 64 characters", moreCharPassVerfMsg);
}
 public void verifySearchEmployee() {
	 String searchEmp=searchEmpLableElmnt.getText();
	 Assert.assertEquals("Varun Dhawan", searchEmp);
	 
	
}
}
