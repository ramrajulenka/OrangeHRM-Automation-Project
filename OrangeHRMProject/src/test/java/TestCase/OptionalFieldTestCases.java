package TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Pages.HRMHomePage;
import Pages.HRMOptionalFieldPage;
import utility.BaseClass;

public class OptionalFieldTestCases extends BaseClass {
@Test(description = "OptionalField End to End Test Case Basic flow")
void optionalEndToEndBasicFlow() {
	WebDriverWait wait=new WebDriverWait(driver, 10);
	try {
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	HRMOptionalFieldPage optnlFld=new HRMOptionalFieldPage(driver);
	optnlFld.clickOptionalField();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-main-title\"]")));
	optnlFld.clickDeprecatedField();
	optnlFld.clickSNNField();
	optnlFld.clickSaveBtn();
	optnlFld.verifySuccesFullMsg();
} catch (Exception e) {
	System.out.println(e);
}
	finally {
	HRMHomePage LogInPageElement=new HRMHomePage(driver);
	LogInPageElement.logOut();	
			
	}
}
@Test(description = "OptionalField End to End Test Case Alternet flow")
void optionalAlternetFlow() {
	WebDriverWait wait=new WebDriverWait(driver, 10);
	try {
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	HRMOptionalFieldPage optnlFld=new HRMOptionalFieldPage(driver);
	optnlFld.clickOptionalField();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"oxd-text oxd-text--p orangehrm-main-title\"]")));
	optnlFld.clickDeprecatedField();
	optnlFld.clickSINField();
	optnlFld.clickUSTaxField();
	optnlFld.clickSNNField();
	optnlFld.clickSaveBtn();
	optnlFld.verifySuccesFullMsg();
} catch (Exception e) {
	System.out.println(e);
}
	finally {
		 HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
			
	}
}
}
