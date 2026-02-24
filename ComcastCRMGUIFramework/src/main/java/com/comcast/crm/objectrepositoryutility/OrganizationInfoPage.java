package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
WebDriver driver;
	
    public OrganizationInfoPage(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    
    
    @FindBy(xpath="//span[@class='dvHeaderText']")
    WebElement headerMsg;
    @FindBy(xpath="//a[text()='Contacts']")
    private WebElement contactlink;

	public WebElement getContactlink() {
		return contactlink;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public void clickOnContact() {
		contactlink.click();
	}
    
}
