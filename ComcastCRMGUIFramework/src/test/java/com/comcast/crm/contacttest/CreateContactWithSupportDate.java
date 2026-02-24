package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithSupportDate {

	public static void main(String[] args) throws IOException {
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
		
	
		
		
		
	
		
		
		String lastName=eLib.getDataFromExcel("Contact",1,2)+number;
		

		
		
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
       
//       Setting the date
       String startDate=jLib.getSystemDateYYYYDDMM();
       String endDate=jLib.getRequiredDateYYYYDDMM(30);
      webLib.waitForPageLoad(driver);
       driver.manage().window().maximize();
       driver.get(url);
       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
       driver.findElement(By.xpath("//input[@id='submitButton']")).click();
       
       driver.findElement(By.xpath("//a[text()='Contacts']")).click();
       
       driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
       
       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
       driver.findElement(By.xpath("//input[@name='support_start_date']")).clear();
       driver.findElement(By.xpath("//input[@name='support_start_date']")).sendKeys(startDate);
       
       driver.findElement(By.xpath("//input[@name='support_end_date']")).clear();
       driver.findElement(By.xpath("//input[@name='support_end_date']")).sendKeys(endDate);
       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
       
       
//       Verify Header Message Expected Result
       
     
       
//       Verify orgname info Expected result
      
      String actLastName=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
      
      if(actLastName.equals(lastName)) {
    	  System.out.println(lastName+" is Created===PASS");
      }
      else {
    	  System.out.println(lastName+" is not Created===FAIL");
      }
       
      String actualStartDate=driver.findElement(By.xpath("//span[@id='dtlview_Support Start Date']")).getText();
      
      if(actualStartDate.equals(startDate)) {
    	  System.out.println(startDate+" is Verified");
      }
      else {
    	  System.out.println(startDate+" is not Verified");
      }
	   
      String actualEndDate=driver.findElement(By.xpath("//span[@id='dtlview_Support End Date']")).getText();	
      if(actualEndDate.equals(endDate)) {
    	  System.out.println(endDate+" is Verified");
      }
      else {
    	  System.out.println(endDate+" is not Verified");
      }
	   
		//Step 5: Log OUT
      driver.quit();


	}

}
