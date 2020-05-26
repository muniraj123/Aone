package com.Aone.testCases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.Aone.pageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws Exception
	{			
		LoginPage lp = new LoginPage(driver);
			
		/* lp.setUserName(username);
		logger.info("Username is entered ");
		
		lp.setPassword(password);
		logger.info("Password is entered");
		
		lp.clicSubmit();
		logger.info("Submit button clicked. "); */
		
		// ----------all the statements are combined in this below statment.
		lp.loginToBank(username, password);
		
		Thread.sleep(15000);		
		System.out.println(driver.getTitle());
		System.out.println(driver.getTitle());
		
		if (driver.getTitle().trim().equals("Guru99 Bank Manager HomePage"))
		{			
			Assert.assertTrue(true);
			Thread.sleep(10000);
			lp.clickLogout();
			logger.info("Login test is passed and Log out link clicked. ");
		}else
		{
			captureScreenShot(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login test is failed.");
		}
		
	}
	
}
