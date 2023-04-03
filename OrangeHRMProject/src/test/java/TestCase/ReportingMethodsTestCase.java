package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HRMHomePage;
import Pages.HRMReportingMethodPage;
import utility.BaseClass;
import utility.ExcelUtility;



public class ReportingMethodsTestCase extends BaseClass {
	@DataProvider
	Object readData() throws IOException {
	String loc=".\\resources\\Exceldata.xlsx";
	ExcelUtility data=new ExcelUtility(loc);
	int rows=data.getRowCount("ReportingMethod");
	int cols=data.getCellCount("ReportingMethod", rows);
	
	Object [][] dataRead=new Object[rows][cols];
	for (int i = 1; i <= rows; i++) {
        for (int j = 0; j < cols; j++) {
        	
        	dataRead[i-1][j]=data.getCellData("ReportingMethod", i, j);
}		
	}
	
	return dataRead;
	
	}
	
	@Test(description = "Reporting Methods End to End Test Case Basic  Flow",dataProvider = "readData")
	void reportinMethodDataDriven(String reportingMethodsName) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		logger.info("Login");
		HRMReportingMethodPage reptgMthds=new HRMReportingMethodPage(driver);
		reptgMthds.landOnReportingMethodPage();
		logger.info("Land on Reporting Methods Home Page");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']")));
		reptgMthds.clickAddNewReport();
		logger.info("Click on Add New Repoting Methods");
		reptgMthds.reportMethodName(reportingMethodsName);
		logger.info("Fill The Reporting Methods Name As "+reportingMethodsName);
		reptgMthds.saveButton();
		logger.info("Login");
		reptgMthds.verifySuccesFullMsg();
		logger.info("Verify successFull Saved Massage");
	} catch (Exception e) {
		System.out.println(e);
	}
		finally {
			 HRMHomePage LogInPageElement=new HRMHomePage(driver);
				LogInPageElement.logOut();	
				
		}
	}
	
	
@Test(description = "Reporting Methods End to End Test Case Alternet Flow")
void reportingMethodAlterFlow() throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
	
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	logger.info("LogIn");
	HRMReportingMethodPage reptgMthds=new HRMReportingMethodPage(driver);
	reptgMthds.landOnReportingMethodPage();
	logger.info("Land On Reporting Methods Page");
	reptgMthds.clickAddNewReport();
	logger.info("Click Add Btn");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']")));
	reptgMthds.reportMethodName("abcd");
	logger.info("Fill The Reporting Methods Name");
	reptgMthds.saveButton();
	logger.info("Click on Save Btn");
	reptgMthds.verifySuccesFullMsg();
	logger.info("Verifing SuccessFully Saved Massage");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")));
	reptgMthds.deleteReportMthd();
	logger.info("delete Reporting Methods");
	reptgMthds.conformDelete();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")));
	reptgMthds.verifySuccesFullMsg();
	logger.info("Verifying Succesfully deleted Msg");
} catch (Exception e) {
	System.out.println(e);
}
	finally {
		 HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
			
	}
} 
@Test(description = "Verify the Reporting Methods Name Should Not Empty")
void reportingMethodNotEmpty() {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {	
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	logger.info("LogIn");
	HRMReportingMethodPage reptgMthds=new HRMReportingMethodPage(driver);
	reptgMthds.landOnReportingMethodPage();
	logger.info("Land On Reporting Methods Page");
	reptgMthds.clickAddNewReport();
	logger.info("Click on Add New Reporting Methods");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']")));
	reptgMthds.reportMethodName("");
	logger.info("Pass The Reporting Methods Name Empty");
	reptgMthds.saveButton();
	logger.info("Click on Save Btn");
	reptgMthds.verifyEmptyMsg();
	logger.info("Verify Name Required Massage");
} catch (Exception e) {
	System.out.println(e);
}
	finally {
		 HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
			
	}
}

@Test(description = "Verify Admin Able to delete all Un Used  Reporting Methods in single click ")
public void deleteAllUnUsedReports() {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	logger.info("LogIn");
	HRMReportingMethodPage reptgMthds=new HRMReportingMethodPage(driver);
	reptgMthds.landOnReportingMethodPage();
	logger.info("Land on Reporting Methods page");
	reptgMthds.clickAddNewReport();
	logger.info("Click on Add ");
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']")));
	reptgMthds.reportMethodName("Illness");
	logger.info("Fill The name");
	reptgMthds.saveButton();
	logger.info("Click on Save");
	reptgMthds.deleteUnUsedRepotMethods();
	logger.info("Delete un Used Reporting Methods in Single click");
	reptgMthds.conformDelete();
	reptgMthds.verifySuccesFullMsg();
	logger.info("Verifying the SuccessFully deleted Massage");
} catch (Exception e) {
	System.out.println(e);
}
	finally {
		 HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
			
	}

}
@Test(description = "Verify Same Two  Reporting Methods Does not Exist ")
public void sameReportNames() {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	HRMReportingMethodPage reptgMthds=new HRMReportingMethodPage(driver);
	reptgMthds.landOnReportingMethodPage();
	reptgMthds.clickAddNewReport();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']")));
	reptgMthds.reportMethodName("TonyStark");
	reptgMthds.saveButton();
	reptgMthds.clickAddNewReport();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class='oxd-text oxd-text--p orangehrm-main-title']")));
	reptgMthds.reportMethodName("TonyStark");
	reptgMthds.saveButton();
	reptgMthds.verifyAlreadyExistedMsg();
} catch (Exception e) {
	System.out.println(e);
}
	finally {
		 HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
			
	}

}

}
