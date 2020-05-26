package com.Aone.testCases;

import com.Aone.pageObject.AddCustomerPage;
import com.Aone.pageObject.LoginPage;

import org.testng.Assert;
import org.testng.annotations.*;

public class TC_AddCustomerTest_003 extends BaseClass {
	
		
	@Test
	public void addCustomer() throws Exception {
	
		//--- login
		LoginPage lp = new LoginPage(driver);
		/*lp.setUserName(username);		
		logger.info("username provided ");
		lp.setPassword(password);
		logger.info("password provided ");
		lp.clicSubmit();
		logger.info("Clicked submit");
		Thread.sleep(5000);	*/
		
		
		lp.loginToBank(username, password);
		
		// add new customer
		AddCustomerPage ac = new AddCustomerPage(driver);
		ac.clickAddNewCustomer();		
		ac.custName("Customer "+randomestring());
		ac.custgender("male");		
		ac.custdob("10","15","1985");
		Thread.sleep(5000);		
		ac.custaddress("INDIA");
		ac.custcity("HYD");
		ac.custstate("AP");
		ac.custpinno("5000074");
		ac.custtelephoneno("987890091");		
		String email=randomestring()+"@gmail.com";
		ac.custemailid(email);		
		ac.custpassword("abcdef");		
		ac.custsubmit();
		
		Thread.sleep(10000);
		
		logger.info("validation started....");		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true){
			Assert.assertTrue(true);
			logger.info("test case passed....");			
		}else
		{
			logger.info("test case failed....");
			captureScreenShot(driver,"addCustomer");
			Assert.assertTrue(false);
		}
			
	}		
		
	}

