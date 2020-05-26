package com.Aone.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver){
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);		
	}	
	@FindBy(name="uid")	WebElement txtUserName;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="btnLogin") WebElement btnLogin;
	@FindBy(xpath="//a[contains(text(),'Log out')]") WebElement lnklogout;
	
	
	//Action methods
	
		/*public void setUserName(String uname) {		
			txtUserName.sendKeys(uname);
		}	
		public void setPassword(String pass) {
			txtPassword.sendKeys(pass);
		}	
		public void clicSubmit() {
			btnLogin.click();
		}	*/
	
	// ------------ all the above 3 methods are combined in to this method.
	public void loginToBank(String uname, String pass) {
		txtUserName.sendKeys(uname);
		txtPassword.sendKeys(pass);
		btnLogin.click();
	}
	
	public void clickLogout() {
		lnklogout.click();		
	}
	
	

}

















