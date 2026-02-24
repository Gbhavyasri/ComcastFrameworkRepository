package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
WebDriver driver;
	
    public ContactPage(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    
    @FindBy(xpath="//img[@title='Create Contact...']")
   private WebElement createContactLink;
    @FindBy(xpath="//span[@class='dvHeaderText']")
    private WebElement headerText;
    public WebDriver getDriver() {
		return driver;
	}
	public WebElement getHeaderText() {
		return headerText;
	}
	public WebElement getCreateContactLink() {
		return createContactLink;
	}
}
