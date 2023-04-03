package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HRMOptionalFieldPage {
public static WebDriver ldriver;
public HRMOptionalFieldPage(WebDriver driver) {
	ldriver=driver;
	PageFactory.initElements(driver, this);
	
}
@FindBy(name="username")
WebElement usernameElement;
@FindBy(name="password")
WebElement passwordElement;
@FindBy(xpath="//button[@type='submit']")
WebElement loginButtonElement;
@FindBy(xpath="//span[normalize-space()=\"PIM\"]")
WebElement clickPim;
@FindBy(xpath="//span[@class=\"oxd-topbar-body-nav-tab-item\"]")
WebElement configDropDown;
@FindBy(xpath="//li[@class=\"--active oxd-topbar-body-nav-tab --parent\"]//li[1]")
WebElement optionalField;
@FindBy(xpath="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[1]")
WebElement deprecatedField;
@FindBy(xpath="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[2]")
WebElement SNNField;
@FindBy(xpath="(//span[@class='oxd-switch-input oxd-switch-input--active --label-right'])[3]")
WebElement SINField;
@FindBy(xpath="//div[3]//div[1]//label[1]//span[1]")
WebElement USTaxField;
@FindBy(xpath="//button[normalize-space()=\"Save\"]")
WebElement saveBtn;

public void setUsername(String username) {
	usernameElement.sendKeys(username);
}
public void setPassword(String password) {
	passwordElement.sendKeys(password);
}
public void clickButton() {
	loginButtonElement.click();
}
public void clickOptionalField() {
	clickPim.click();
	configDropDown.click();
	optionalField.click();
	
	
}
@FindBy(xpath="//div[@id='oxd-toaster_1']")
WebElement verifyMsg;
public void clickDeprecatedField() {
	deprecatedField.click();
}
public void clickSNNField() {
	SNNField.click();
}
public void clickSINField() {
	SINField.click();
}
public void clickUSTaxField() {
	USTaxField.click();
}
public void clickSaveBtn() {
	saveBtn.click();
}
public void verifySuccesFullMsg() {
	 String elemnt=verifyMsg.getText();
	 Assert.assertNotNull(elemnt);
	
}
}
