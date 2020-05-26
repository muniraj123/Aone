package com.Aone.utilities;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	//---------- Constructor to Load the Config.properties file when this class is instantiated.  	
	Properties pro ;	
	public ReadConfig() {		
		File src = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);	
		}catch(Exception e){
			System.out.println("File Not found : " + e.getMessage());
		}
	}

	//------------- Common methods to get the values from properties file.
	
	public String getApplicationURL() {		
		String url = pro.getProperty("baseURL");
		return url;
	}	
	public String getUsername() {
		String usern = pro.getProperty("username");
		return usern;
	}	
	public String getPassword() {
		String passw = pro.getProperty("password");
		return passw;
	}	
	public String getChromeDriverPath() {
		String chropath = pro.getProperty("chropath");
		return chropath;
	}	
	public String getFireFoxDriverPath() {
		String firep = pro.getProperty("firefoxpath");
		return firep;
	}	
	public String getIEDriverPath() {
		String iep= pro.getProperty("iepath");
		return iep;
	}
	
	public String getXLSfilePath() {
		String xl= pro.getProperty("logindata");
		return xl;
	}
	
	
}
