package com.Aone.testCases;



import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Aone.utilities.ReadConfig;

import org.testng.annotations.AfterClass;


public class BaseClass {
	
	public static WebDriver driver;		
	public Logger logger;
	
	//-------- reading the ReadConfig java file to get the property values in runtime. 
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();			
	public String username =readconfig.getUsername();			
	public String password =readconfig.getPassword();		
	
	//------------- setup method to launch browser, get Logger handle before starting any test case.
	//-------------- run the test cases on desired browser. 
	@Parameters("browser")
	@BeforeClass
	public void setup(String brw) {
					
		logger = Logger.getLogger("Aone Banking");
		PropertyConfigurator.configure("Log4j.properties");

		if(brw.equals("chrome")) {				
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+readconfig.getChromeDriverPath());
			driver = new ChromeDriver();		
		}
		else if (brw.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+ readconfig.getFireFoxDriverPath());
			driver = new FirefoxDriver();
		}
		else if (brw.equals("ie")) {
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ readconfig.getIEDriverPath());
			driver = new InternetExplorerDriver();
		}		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		logger.info("URL is launched");
		
	}
	
	// ------------- method to to closing activities after running the test	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	//---------------- Capture screenshot and copy to Screenshots folder. 
	public void captureScreenShot(WebDriver driver, String testCaseName) throws Exception {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testCaseName + ".png" );
		FileUtils.copyFile(source, target);				
	}
	
	
	// ------------check if Alert is shown
	public boolean isAlertShown() {		
		try {
			driver.switchTo().alert();
			return true;
		}catch(Exception e)
		{
			return false;			
		}
	}
	
	// --------generate random data
	public String randomestring() {
		String rand= RandomStringUtils.randomAlphabetic(5);
		return rand;
		
	}
	
	
	
}










