package com.Aone.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import com.Aone.utilities.ReadConfig;

public class test {
		
	@FindBy(name="uid")	WebElement txtUserName;
	@FindBy(name="password") WebElement txtPassword;
	@FindBy(name="btnLogin") WebElement btnLogin;
	
	public static void main(String[] args) throws InterruptedException {
		ReadConfig readconfig = new ReadConfig();
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+readconfig.getChromeDriverPath());
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://demo.guru99.com/V4/");
		
		driver.findElement(By.name("uid")).sendKeys("mngr253137");
		
		driver.findElement(By.name("password")).sendKeys("ybenEzE");
		
		driver.findElement(By.name("btnLogin")).click();
		
		Thread.sleep(10000);
		
		System.out.println(driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[15]/a")).getText());
		
		driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
		
		
		
		
		
	}

}
