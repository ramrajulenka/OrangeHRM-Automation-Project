package utility;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	
	ReadProperties read=new ReadProperties();
	public String global_userName=read.getUsername();
	public String global_password=read.getPassword();
	public String browserName=read.getBrowser();
	public String url=read.getUrl();
	
	protected static Logger logger;
	protected static WebDriver driver;
	@BeforeTest
	public void setUp() {
		
		if (browserName.equalsIgnoreCase("chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger=Logger.getLogger("OrangeHRMProject");
		PropertyConfigurator.configure("logfile.properties");
		System.out.println("Base Class Driver"+driver);
		
		} 
		if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver",".\\Drivers\\msedgedriver.exe");
			driver=new EdgeDriver();
			logger=Logger.getLogger("OrangeHRMProject");
			PropertyConfigurator.configure("logfile.properties");
			}
	}
	@AfterTest
	public void tear() {
		driver.quit();
	}

}
