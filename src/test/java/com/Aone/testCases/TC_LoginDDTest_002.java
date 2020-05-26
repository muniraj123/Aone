package com.Aone.testCases;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.Aone.pageObject.LoginPage;
import com.Aone.utilities.XLUtils;

public class TC_LoginDDTest_002 extends BaseClass {
		

	@Test(dataProvider="LoginData")
	public void LoginDDT(String usr, String pass) throws Exception {
		LoginPage lp = new LoginPage(driver);
		/*lp.setUserName(usr);
		logger.info("username is entered");
		lp.setPassword(pass);
		logger.info("password is entered");
		lp.clicSubmit();
		logger.info("Submit button clicked");
		Thread.sleep(10000);*/
		
		// ----------all the statements are combined in this below statement.
		lp.loginToBank(username, password);
		
		if (isAlertShown()==true) {
			captureScreenShot(driver,"LoginDDT");
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Thread.sleep(3000);
			logger.info("Login failed due to wrong credentials., Accepted the Alert ");			
			Assert.assertTrue(false);
			
		}else {
			lp.clickLogout();
			Thread.sleep(5000);
			driver.switchTo().alert().accept(); //--------- log out alert
			driver.switchTo().defaultContent();
			logger.info("Logged out and accepted the alert. ");
			captureScreenShot(driver,"LoginDDT");
			Assert.assertTrue(true);
		}
		
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws Exception{		
		String path = System.getProperty("user.dir") + readconfig.getXLSfilePath();
		int rownnum= XLUtils.getRowCount(path, "Sheet1");
		int colcount= XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]= new String [rownnum][colcount];
		
		for (int i=1; i<=rownnum; i++) {
			for(int j=0; j<colcount; j++ ) {
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);				
			}			
		}
	return logindata;	
	}
	
	
}
