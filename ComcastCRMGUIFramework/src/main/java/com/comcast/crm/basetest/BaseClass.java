package com.comcast.crm.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	
	public  FileUtility fLib=new FileUtility();
    public ExcelUtility eLib=new ExcelUtility();
    public  JavaUtility jLib=new JavaUtility();
    public WebDriverUtility webLib=new WebDriverUtility();
	public  WebDriver driver=null;
	public static WebDriver sdriver=null;
	    @BeforeSuite
	    public void configBS() {
		   System.out.println("===Connect To DB====,Report Config");
	    }
//	   @Parameters("Browser")
		@BeforeClass
		public void configBC(/*String browser*/) throws IOException {
			System.out.println("Launch The Browser");
			String BROWSER=fLib.getDataFromProperiesFile("browser");
			
//		String BROWSER=browser;
		       if(BROWSER.equals("chrome"))		{
		    	   driver=new ChromeDriver();
		       }
		       else if(BROWSER.equals("firefox")) {
		    	   driver=new FirefoxDriver();
		       }
		       else if(BROWSER.equals("edge")) {
		    	   driver=new EdgeDriver();
		       }
		       else {
		    	   driver=new ChromeDriver();
		       }
			sdriver=driver;
		}
		
		@BeforeMethod
		public void configBM() throws IOException {
			System.out.println("====LogIn====");
		
			String url=fLib.getDataFromProperiesFile("url");
			String username=fLib.getDataFromProperiesFile("username");
			String password=fLib.getDataFromProperiesFile("password");
			LoginPage lp=new LoginPage(driver);
			lp.loginToApp(url, username, password);
			
			
		}
		@AfterMethod
		public void configAM() {
			System.out.println("====LogOut====");
			HomePage hp=new HomePage(driver);
			hp.logout();
		}
		@AfterClass
		public void configAC() {
			System.out.println("Close the Browser");
			driver.quit();
		}
		 @AfterSuite
		 public void configAS() {
			   System.out.println("Close the DB,Report BackUp");
		}

}
