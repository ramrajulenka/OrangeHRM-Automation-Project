package TestCase;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.HRMHomePage;
import utility.BaseClass;
import utility.ExcelUtility;

public class LoginTestCases extends BaseClass {
	@DataProvider
	Object readData() throws IOException {
		String location = ".\\resources\\Exceldata.xlsx";
		ExcelUtility excelData = new ExcelUtility(location);
		int rows = excelData.getRowCount("LogData");
		int cols = excelData.getCellCount("LogData", rows);
		Object[][] data = new Object[rows][cols];
		for (int i=1; i <= rows; i++) {
			for (int j = 0; j < cols; j++) {

				data[i-1][j] = excelData.getCellData("LogData", i, j);
            }
		}
		return data;
	}
	
//Data Driven for Null Values	
	@DataProvider
	Object readNullData() throws IOException {
		
		Object[][] data = new Object[3][2];

		
		  data[0][0]="Admin"; data[0][1]="";
		  data[1][0]=""; data[1][1]="admin123"; 
		  data[2][0]=""; data[2][1]="";
	
		return data;
	}	
	
@Test(dataProvider ="readData" ,description = "Login Negative Test case by usind data driven excell sheet")
void verifyLogInvalidCrediantial(String userName,String password) {
	driver.manage().window().maximize();
	HRMHomePage log=new HRMHomePage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	log.setUsername(userName);
	logger.info("Entering username as "+userName);   
	log.setPassword(password);
	logger.info("Entering password as "+password);
	log.clickButton();
	logger.info("click login button");
	log.verifyInvalidCredential();
}
@Test(description = "Login End to End Test Cases")
void Login_end_to_End() {
	driver.manage().window().maximize();
	HRMHomePage log=new HRMHomePage(driver);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(url);
	log.setUsername(global_userName);
	logger.info("Entering username as "+global_userName);	
	log.setPassword(global_password);
	logger.info("Entering password as "+global_password);
	log.clickButton();
	logger.info("click login button");
	log.verifyHomePage();
	logger.info("Verifying Home Page");
	log.logOut();
	log.verifyLogOut();
}

	@Test(dataProvider ="readNullData" ,description = "Login Negative Test case by usind data driven Passing Null Values")
	void verifyLogWithNullValues(String userName,String password) {
		driver.manage().window().maximize();
		HRMHomePage log=new HRMHomePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		log.setUsername(userName);
		logger.info("Entering username as "+userName);   
		log.setPassword(password);
		logger.info("Entering password as "+password);
		log.clickButton();
		logger.info("click login button");
        log.verifyingRequirdMsg();
		logger.info("verifying Requird Massage");
		
	}
}
