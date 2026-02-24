package com.comcast.crm.contacttest;

import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
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

		
	


//				Reading the data from the Excel File
	
				
				String orgnizationPrefix=eLib.getDataFromExcel("Contact",9,2)+number;
				
				String lastName=eLib.getDataFromExcel("Contact",9,3)+number;
				
			
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
			  
		       //Step 1: login to the Application
		       
		       webLib.waitForPageLoad(driver);
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		       driver.manage().window().maximize();
		       driver.get(url);
		       driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(username);
		       driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(password);
		       driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		       Step 2: Navigate to the Organization Module
		       
		       driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		       
//		       Step 3:Click on the Create organization Button
		       driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		       
//		       Step4:Enter all the details and save the organization
		       driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgnizationPrefix);
		       driver.findElement(By.xpath("//textarea[@name='ship_street']")).sendKeys("hyderabad");
		       
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		       
		       Thread.sleep(2000);
//		       Verify Header Message Expected Result
		       
		      String headerText= driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		      if(headerText.contains(orgnizationPrefix)) {
		    	  System.out.println(orgnizationPrefix+" is created"+"====PASS");
		      }
		      else {
		    	  System.out.println("Header is verified"+"====FAIL");
		      }
		       
		     
				
				//Step 5: Navigate to Contact Module
		      driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		       
		      
		    //Step 6: Click on the create contact button
		       driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		       
            //Step 7: Enter all the details & create the new contacts       
		       driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);
		       
		       driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
		       Thread.sleep(2000);
//		        Switch to the child window
		       
		       webLib.switchNewBrowserTab(driver, "\"module=Accounts\"");
		      
		       Thread.sleep(2000);
		       driver.findElement(By.name("search_text")).sendKeys(orgnizationPrefix);
		       driver.findElement(By.name("search")).click();
		       Thread.sleep(2000);
		       driver.findElement(By.xpath("//a[text()='"+orgnizationPrefix+"']")).click();//----Dynamic-Xpath------
		       
		       
//		       Switch back to Parent Window
		       webLib.switchNewBrowserTab(driver,"Contacts&action");
		      
		       
		       driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		       
		       
		       
		       

		       
		     
		       
//		       Verify orgname info Expected result
		      
		      String actualContact=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		      
		      if(actualContact.equals(lastName)) {
		    	  System.out.println(lastName+" is Created===PASS");
		      }
		      else {
		    	  System.out.println(orgnizationPrefix+" is not Created===FAIL");
		      }

		       
		    
		       
		      driver.quit();
		

	}

}
