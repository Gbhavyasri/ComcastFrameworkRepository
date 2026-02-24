package com.comcast.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

import junit.framework.Assert;

public class CreateContactTest extends BaseClass{

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub

//		Generating the Random Number	
		int number=jLib.getRandomeNumber();
		
//		Reading the data from the Excel File
		String lastName=eLib.getDataFromExcel("Contact",1,2)+number;

//		Navigate to Contact Module     
       HomePage hp=new HomePage(driver);
       hp.getContactLink().click();
//       Click on the "create Contact" Button
       
       ContactPage cp=new ContactPage(driver);
       cp.getCreateContactLink().click();
       
       
//       Enter All the Details And Create New Contact
    
       CreateNewContactPage cnp=new CreateNewContactPage(driver);
       cnp.createContact(lastName);
      
       
       
//       Verify Header Message Expected Result    
      String actLastName=cp.getHeaderText().getText();//driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//      as it is dynamic data
     boolean status =actLastName.contains(lastName);
      Assert.assertTrue(status);
      
//      if(actLastName.equals(lastName)) {
//    	  System.out.println(lastName+" is Created===PASS");
//      }
//      else {
//    	  System.out.println(lastName+" is not Created===FAIL");
//      }
//       
	   
		
		

	}
	@Test
	public void createContactWithSupportDate() throws EncryptedDocumentException, IOException {
		int number=jLib.getRandomeNumber();
		String lastName=eLib.getDataFromExcel("Contact",1,2)+number;
		  String startDate=jLib.getSystemDateYYYYDDMM();
	       String endDate=jLib.getRequiredDateYYYYDDMM(30);
	       webLib.waitForPageLoad(driver);
	       
//			Navigate to Contact Module     
	       HomePage hp=new HomePage(driver);
	       hp.getContactLink().click();
	       
//	       Click on the "create Contact" Button
	       
	       ContactPage cp=new ContactPage(driver);
	       cp.getCreateContactLink().click();
	       
//	       Enter All the Details And Create New Contact
	       
	       CreateNewContactPage cnp=new CreateNewContactPage(driver);
	       cnp.createContact(lastName,startDate,endDate);
	       
//	       Verify Contact info info Expected result
	       
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
	       
	}
	@Test
	public void createContactWithOrgTest() throws EncryptedDocumentException, IOException, InterruptedException {
		int number=jLib.getRandomeNumber();

		String orgnizationPrefix=eLib.getDataFromExcel("Contact",9,2)+number;
		
		String lastName=eLib.getDataFromExcel("Contact",9,3)+number;
		  webLib.waitForPageLoad(driver);
		  
		  HomePage hp=new HomePage(driver);
		  hp.getOrgLink().click();
		  
		  OrganizationsPage orgPage=new OrganizationsPage(driver);
		  orgPage.getCreateOrgLink().click();
		  
		  CreatingNewOrganizationPage newOrgPage=new CreatingNewOrganizationPage(driver);
		  newOrgPage.createOrg(orgnizationPrefix,"hyderabad");
		  
		  OrganizationInfoPage infoPage=new OrganizationInfoPage(driver);
		  Thread.sleep(2000);
		infoPage.clickOnContact();
//		  hp.getContactLink().click();
		
//		  driver.findElement(By.linkText("Contacts")).click();
  
		  ContactPage cp=new ContactPage(driver);
		  cp.getCreateContactLink().click();
		  
		  CreateNewContactPage cnp=new CreateNewContactPage(driver);
		  cnp.createContactwithOrg(lastName);
		  String parentWin=driver.getWindowHandle();
		  webLib.switchNewBrowserTab(driver, "\"module=Accounts\"");
		 
		  cnp.getSerachField().sendKeys(orgnizationPrefix);
		  cnp.getSearchBtn().click();
		  driver.findElement(By.xpath("//a[text()='"+orgnizationPrefix+"']")).click();
		  Thread.sleep(2000);
		  cnp.getSaveBtn().click();
//	       Verify contact info Expected result
		
	      String actualContact=driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
	      
	      if(actualContact.equals(lastName)) {
	    	  System.out.println(lastName+" is Created===PASS");
	      }
	      else {
	    	  System.out.println(orgnizationPrefix+" is not Created===FAIL");
	      }

		  
	}

}
