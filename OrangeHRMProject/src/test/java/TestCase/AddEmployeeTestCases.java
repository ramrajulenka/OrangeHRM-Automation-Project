package TestCase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Pages.HRMAddEmployeePage;
import Pages.HRMHomePage;
import utility.BaseClass;
import utility.ExcelUtility;


public class AddEmployeeTestCases extends BaseClass{
	
	@DataProvider
	Object readData() throws IOException {
	String loc=".\\resources\\Exceldata.xlsx";
	ExcelUtility data=new ExcelUtility(loc);
	int rows=data.getRowCount("AddEmp");
	int cols=data.getCellCount("AddEmp", rows);
	
	Object [][] dataRead=new Object[rows][cols];
	for (int i = 1; i <= rows; i++) {
        for (int j = 0; j < cols; j++) {
        	
        	dataRead[i-1][j]=data.getCellData("AddEmp", i, j);
}		
	}
	
	return dataRead;
	
	}
	
	@Test(description ="Add Employee By using Data Driven Basic flow",dataProvider = "readData")
	void addEmpDataDriven(String firstName,String middleName,String lastName) {
		try {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		logger.info("Login");
		HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
		add.clickPim();
		add.clickAddEmp();
		logger.info("Land On Add Employee Page");
		add.verifyAddEmpPage();
		logger.info("verify Add Employee Page lable");
		add.enterEmpData(firstName,middleName,lastName);
		logger.info("Fill Fist Name As "+firstName);
		logger.info("Fill Middle Name As "+middleName);
		logger.info("Fill Last Name As "+lastName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()=\"Save\"]")));
	    add.saveBtn(); 
	    add.verifySuccesFullLable();
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			 HRMHomePage LogInPageElement=new HRMHomePage(driver);
				LogInPageElement.logOut();	
		}
		
	   
	} 
	@Test(description = "Add Employee End To End Test Case Alternet Flow")
	void addEmpEndToEnd() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		logger.info("Login");
		HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
		add.clickPim();
		add.clickAddEmp();
		logger.info("Land On Add Employee Page");
		add.enterEmpData("Varun","Dhawan","Sing");
		logger.info("Fill the Data");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()=\"Save\"]")));
		 add.saveBtn(); 
		logger.info("Click Save Button");
		add.verifySuccesFullLable();
		logger.info("Verifying successFully Saved or Not");
		add.employeeList(); 
		logger.info("Land On employee List Page");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@placeholder='Type for hints...'])[1]")));
		add.searchEmployee("Varun Dhawan Sing");
		logger.info("Fill The Data in The Search Box");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Search']")));
		add.clickSearchBtn();
		logger.info("Click on Search");
		add.verifySearchEmployee();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//i[@class='oxd-icon bi-trash'])[1]")));
		add.deleteEmp();
		logger.info("Select and click on delete icon");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()=\"Yes, Delete\"]")));
		add.conformDelete();
		logger.info("Delete the Searched Employee");
		add.verifySuccesFullLable();
	} catch (Exception e) {
		System.out.println(e);
	}
		finally {
			 HRMHomePage LogInPageElement=new HRMHomePage(driver);
				LogInPageElement.logOut();	
				
		}
		
	} 
	@Test(description = "Delete Multiple Employees")
	void deleteMitipleEmp() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
		driver.manage().window().maximize();
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		logger.info("Login");
		HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
		add.clickPim();
		add.clickAddEmp();
		logger.info("Land On Add Employee Page");
		add.enterEmpData("Stive","Jhon","Sing");
		logger.info("Fill the Data");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()=\"Save\"]")));
		 add.saveBtn(); 
		logger.info("Click Save Button");
		add.verifySuccesFullLable();
		logger.info("Verifying successFully Saved or Not");
		add.employeeList();  
		logger.info("Land On employee List Page");
		add.deleteMultipleEmp();
		logger.info("Select and delete multiple Employees");
		add.verifySuccesFullLable();
		logger.info("Verifying Succesfully deleted msg");
	} catch (Exception e) {
		System.out.println(e);
	}
		finally {
			 HRMHomePage LogInPageElement=new HRMHomePage(driver);
				LogInPageElement.logOut();	
				
		}
		

	}
	@Test(description ="Employee First Name And Last Name Should Not Empty")
	void addEmptyValues() {
		WebDriverWait wait=new WebDriverWait(driver, 30);
		try {
			
		
		CommanLogIn login=new CommanLogIn();
		login.LogInForAllPage(driver);
		logger.info("Login");
		HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
		add.clickPim();
		add.clickAddEmp();
		logger.info("Land On Add Employee Page");
		add.enterEmpData("","","");
		logger.info("Fill the Data");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()=\"Save\"]")));
	    add.saveBtn();
	    logger.info("Click Save Button");
	    add.verifyNameRequrdMassage();
	    logger.info("verify Name fieds values Requird");
		} catch (Exception e) {
			System.out.println(e);
		}
		finally {
			 HRMHomePage LogInPageElement=new HRMHomePage(driver);
				LogInPageElement.logOut();
				
		}
	}
		@Test(description ="Verift The Admin Able to Create Login Details of an Employee")
		void createLoginDetails() throws InterruptedException  {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		    WebDriverWait wait=new WebDriverWait(driver, 10);
		    try {
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
			driver.manage().window().maximize();
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.setUsername(global_userName);
			LogInPageElement.setPassword(global_password);
		    LogInPageElement.clickButton();
			HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
			add.verifyAddEmpPage();
			add.enterEmpData("i","am","kira");
		    add.clickCreateLogInSetails();
		    add.setUserName("ramaraju");
		    add.setPassword("Ramaraju@134","Ramaraju@134");
			add.saveBtn();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h6[normalize-space()=\"Personal Details\"]")));
		//	add.verifyPersonalDetailsLable();
			LogInPageElement.logOut();
			LogInPageElement.setUsername("ramaraju");
			LogInPageElement.setPassword("Ramaraju@134");
			LogInPageElement.clickButton();
			add.verifyPersonalDetailsLable();
		    } catch (Exception e) {
				System.out.println(e);
			}
			finally {
				 HRMHomePage LogInPageElement=new HRMHomePage(driver);
					LogInPageElement.logOut();
					
			}
		}
		@Test(description ="Verift The username and password ")
		void verifyUserPasswordLessChar() throws InterruptedException{
			try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 10);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
			driver.manage().window().maximize();
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.setUsername(global_userName);
			LogInPageElement.setPassword(global_password);
		    LogInPageElement.clickButton();
			HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"oxd-text oxd-text--p user-form-header-text\"]")));
		    add.clickCreateLogInSetails();
		    add.setUserName("amaa");
		    add.setPassword("Ram@1","");
		   add.verifyUserAndPassNameLessChar();

		 } catch (Exception e) {
				System.out.println(e);
			}
			finally {
				 HRMHomePage LogInPageElement=new HRMHomePage(driver);
					LogInPageElement.logOut();
					
			}
		}
		@Test(description ="Verify The username and password does not having more then ")
		void verifyUserPasswordMoreChar() throws InterruptedException{
			try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait wait=new WebDriverWait(driver, 10);
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/addEmployee");
			driver.manage().window().maximize();
			HRMHomePage LogInPageElement=new HRMHomePage(driver);
			LogInPageElement.setUsername("Admin");
			LogInPageElement.setPassword("admin123");
		    LogInPageElement.clickButton();
			HRMAddEmployeePage add=new HRMAddEmployeePage(driver);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[@class=\"oxd-text oxd-text--p user-form-header-text\"]")));
		    add.clickCreateLogInSetails();
		    add.setUserName("amaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		    add.setPassword("Ram@1aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa","");
		   add.verifyUserAndPassMoreChar();
			 } catch (Exception e) {
					System.out.println(e);
				}
				finally {
					 HRMHomePage LogInPageElement=new HRMHomePage(driver);
						LogInPageElement.logOut();
						
				}
		}
		
}

