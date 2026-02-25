package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	
    public HomePage(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    @FindBy(linkText="Documents")
    private WebElement documentLink;
    @FindBy(linkText="Products")
    private WebElement productLink;
    @FindBy(xpath="//a[text()='Organizations']")
    private WebElement orgLink;
    @FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
    private WebElement adminImg;
    
    @FindBy(linkText="Sign Out")
    private WebElement signOutlink;

    @FindBy(xpath="//a[text()='Contacts']")
    WebElement contactLink;
	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getOrgLink() {
		return orgLink;
	}
	public WebElement getContactLink() {
		return contactLink;
	}
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		act.click(signOutlink).click().perform();
	}
	
	
    
}
