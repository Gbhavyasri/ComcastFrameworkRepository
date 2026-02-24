package com.comcast.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationPhoneNumberTest extends BaseClass{

	@Test
	public void createOrganizationPhoneNumberTest() throws EncryptedDocumentException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		/*Create Object*/
		FileUtility fLib=new FileUtility();
	    ExcelUtility eLib=new ExcelUtility();
	    JavaUtility jLib=new JavaUtility();
	    WebDriverUtility webLib=new WebDriverUtility();
	    
	
		String browser=fLib.getDataFromProperiesFile("browser");
		String url=fLib.getDataFromProperiesFile("url");
		String username=fLib.getDataFromProperiesFile("username");
		String password=fLib.getDataFromProperiesFile("password");
		
//		Generating the Random Number
		
		
		int number=jLib.getRandomeNumber();
//		Reading the data from the Excel File
		String orgnizationPrefix= eLib.getDataFromExcel("org", 9, 2)+number;
		
		
		String phoneNumber=eLib.getDataFromExcel("org", 9, 3)+number;
		
		
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
       driver.get(url);
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
       driver.findElement(By.xpath("//input[@id='submitButton']")).click();
       
       driver.findElement(By.xpath("//a[text()='Organizations']")).click();
       
       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
       
       driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgnizationPrefix);
       driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("hyderabad");
       
       driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phoneNumber);
       
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       
//       Verify Header Message Expected Result
       Thread.sleep(2000);
      String headerText= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
      if(headerText.contains(orgnizationPrefix)) {
    	  System.out.println(orgnizationPrefix+" is created"+"====PASS");
      }
      else {
    	  System.out.println("Header is verified"+"====FAIL");
      }
       
//       Verify orgname info Expected result
      
      String actOrgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
      
      if(actOrgName.equals(orgnizationPrefix)) {
    	  System.out.println(orgnizationPrefix+" is Created===PASS");
      }
      else {
    	  System.out.println(orgnizationPrefix+" is not Created===FAIL");
      }
//      Verify Phone Number
      String actPhoneNum=driver.findElement(By.xpath("//span[@id='dtlview_Phone']")).getText();
      
      if(actPhoneNum.equals(phoneNumber)) {
    	  System.out.println(phoneNumber+" is Verified===PASS");
      }
      else {
    	  System.out.println(phoneNumber+" is not Verified===FAIL");
      }
       
	   
		
		//Step 5: Log OUT
      driver.quit();

	}

}
