package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeleteOrg {
	public static void main(String [] args) throws EncryptedDocumentException, IOException, InterruptedException {
	/*Create Object*/
	FileUtility fLib=new FileUtility();
    ExcelUtility eLib=new ExcelUtility();
    JavaUtility jLib=new JavaUtility();
    WebDriverUtility webLib=new WebDriverUtility();
    

	String browser=fLib.getDataFromProperiesFile("browser");
	String url=fLib.getDataFromProperiesFile("url");
	String username=fLib.getDataFromProperiesFile("username");
	String password=fLib.getDataFromProperiesFile("password");
	
//	Generating the Random Number

	
	int number=jLib.getRandomeNumber();
//	Reading the data from the Excel File
	String orgnizationPrefix= eLib.getDataFromExcel("org", 12, 2)+number;
	
	

	WebDriver driver=null;
   if(browser.equals("chrome"))		{
	   driver=new ChromeDriver();
   }
   else if(browser.equals("firefox")) {
	   driver=new FirefoxDriver();
   }
   else if(browser.equals("edge")) {
	   driver=new EdgeDriver();
   }
   else {
	   driver=new ChromeDriver();
   }
  
   webLib.waitForPageLoad(driver);
   driver.manage().window().maximize();
   
   
//   LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);--->Instead of this we can we initialize the webelements inside the POM class itself
   LoginPage loginPage=new LoginPage(driver);
  

//   Instead of the above findElements we have used the below way to perform the login operation
   
//   loginPage.getUsernameEdt().sendKeys("admin");
//   loginPage.getPasswordEdt().sendKeys("admin");
//   loginPage.getLoginBtn().click();
   
   
//   the above was done by using the getters
// 1.  LOGIN TO THE APPLICATION
   loginPage.loginToApp(url,username, password);
//   The above one is using the business method present in the LoginPage POM class
//   2 .CLICK ON THE ORGANIZATION MODULE
 
   
   HomePage homePage=new HomePage(driver);
   
   homePage.getOrgLink().click();
   
   
   
//   3. CLICK ON THE CREATE NEW ORGNIZATION BUTTON
   OrganizationsPage orgPage=new OrganizationsPage(driver);
   orgPage.getCreateOrgLink().click();
 
//  4. Enter valid details
   
   CreatingNewOrganizationPage createnewOrg=new CreatingNewOrganizationPage(driver);
   
     createnewOrg.createOrg(orgnizationPrefix, "hyderabad");
 
   
   
//   Verify Header Message Expected Result
   
     
     OrganizationInfoPage orgInfo=new OrganizationInfoPage(driver);
     
   String headerText= orgInfo.getHeaderMsg().getText();
     
     

  if(headerText.contains(orgnizationPrefix)) {
	  System.out.println(orgnizationPrefix+" is created"+"====PASS");
  }
  else {
	  System.out.println("Header is verified"+"====FAIL");
  }
   
//   Verify orgname info Expected result
  
  String actOrgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
  
  if(actOrgName.equals(orgnizationPrefix)) {
	  System.out.println(orgnizationPrefix+" is Created===PASS");
  }
  else {
	  System.out.println(orgnizationPrefix+" is not Created===FAIL");
  }
   
//   5. GO BACK TO ORGANIZATION PAGE
  
  homePage.getOrgLink().click();
  
//  6.sEARCH FOR THE ORGANIZATION
  orgPage.getSearchEdt().sendKeys(orgnizationPrefix);
  
  webLib.select(orgPage.getSearchDD(), "Organization Name");
  
  orgPage.getSearchbtn().click();
  
  driver.findElement(By.xpath("//a[text()='"+orgnizationPrefix+"' and @title='Organizations']/../../td[8]/a[text()='del']")).click();
  
  Thread.sleep(2000);
  webLib.switchToAlertAndAccept(driver);
	//Step 5: Log OUT
  homePage.logout();
  driver.quit();
}
}
