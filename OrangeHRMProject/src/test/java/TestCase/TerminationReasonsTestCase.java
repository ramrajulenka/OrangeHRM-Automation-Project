package TestCase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HRMHomePage;
import Pages.HRMReportingMethodPage;
import Pages.HRMTerminationReasonsPage;
import utility.BaseClass;
import utility.ExcelUtility;

public class TerminationReasonsTestCase extends BaseClass {
	
	@DataProvider
	Object readData() throws IOException {
	String loc=".\\resources\\Exceldata.xlsx";
	ExcelUtility data=new ExcelUtility(loc);
	int rows=data.getRowCount("Termination");
	int cols=data.getCellCount("Termination", rows);
	
	Object [][] dataRead=new Object[rows][cols];
	for (int i = 1; i <= rows; i++) {
        for (int j = 0; j < cols; j++) {
        	
        	dataRead[i-1][j]=data.getCellData("Termination", i, j);
          }
	}
	
	return dataRead;
	
	}
   @Test(description = "Termination Reasons End to End Test Case Basic Flow",dataProvider = "readData")
	void terminationDataDriven(String terminationName) {
	   try {
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		HRMTerminationReasonsPage termReason=new HRMTerminationReasonsPage(driver); 
		termReason.landOnTerminationReasonPage();
		termReason.clickAddNewTerminationReason();
		termReason.terminationReasonName(terminationName);
		termReason.saveButton();
		termReason.verifySuccesFullMsg();
   } catch (Exception e) {
		System.out.println(e);
	}
		finally {
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
		}
	}
	@Test(description = "Termination Reasons End to End Test Case Alternet Flow")
	void terminationEndToEnd() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		HRMTerminationReasonsPage termReason=new HRMTerminationReasonsPage(driver);
		termReason.landOnTerminationReasonPage();
		termReason.clickAddNewTerminationReason();
		termReason.terminationReasonName("abc");
		termReason.saveButton();
		termReason.verifySuccesFullMsg();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")));
		termReason.deleteTermination();
		termReason.verifySuccesFullMsg();
	} catch (Exception e) {
		System.out.println(e);
	}
		finally {
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
				
		}
	} 
	@Test(description = "Verify Termination Reasons Name Should Not empty ")
	void terminationNotEmpty(){
		try {
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		HRMTerminationReasonsPage termReason=new HRMTerminationReasonsPage(driver);
		termReason.landOnTerminationReasonPage();
		termReason.clickAddNewTerminationReason();
		termReason.terminationReasonName("");
		termReason.saveButton();	
		termReason.verifyEmptMsg();
	} catch (Exception e) {
		System.out.println(e);
	}
		finally {
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
				
		}
	}
	
	@Test(description = "Verify Same Two  Termination Reasons Does not Exist ")
	public void sameReportNames() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		HRMTerminationReasonsPage termReason=new HRMTerminationReasonsPage(driver);
		termReason.landOnTerminationReasonPage();
		termReason.clickAddNewTerminationReason();
		termReason.terminationReasonName("TonyStark");
		termReason.saveButton();
		termReason.verifySuccesFullMsg();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")));
		termReason.clickAddNewTerminationReason();
		termReason.terminationReasonName("TonyStark");
		termReason.saveButton();
		termReason.verifyAlreadyExistedMsg();
	} catch (Exception e) {
		System.out.println(e);
	}
		finally {
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
				
		}

	}
	

@Test(description = "Verify Admin Able to delete all Un Used  Termination Reasons single click ")
void deleteAllUnUsedTerminations() {
	WebDriverWait wait=new WebDriverWait(driver, 30);
	try {
	CommanLogIn login=new CommanLogIn();
	login.LogInForAllPage(driver);
	HRMTerminationReasonsPage termReason=new HRMTerminationReasonsPage(driver);
	termReason.landOnTerminationReasonPage();
	termReason.clickAddNewTerminationReason();
	termReason.terminationReasonName("Incompetence");
	termReason.saveButton();
	termReason.verifySuccesFullMsg();
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class=\"oxd-text oxd-text--span\"]")));
	termReason.deleteAllUnUsedTermtio();
	termReason.verifySuccesFullMsg();
} catch (Exception e) {
	System.out.println(e);
}
	finally {
		 HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.logOut();	
			
	}
}
}