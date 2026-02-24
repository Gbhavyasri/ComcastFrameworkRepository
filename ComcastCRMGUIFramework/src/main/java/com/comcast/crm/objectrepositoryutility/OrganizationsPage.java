package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
WebDriver driver;
	
    public OrganizationsPage(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    
    
    @FindBy(xpath="//img[@title='Create Organization...']")
    private WebElement createOrgLink;
    
    @FindBy(name="search_text")
    private WebElement searchEdt;
    
    @FindBy(name="search_field")
    private WebElement searchDD;
    
    @FindBy(name="submit")
    private WebElement searchbtn;
	public WebElement getSearchbtn() {
		return searchbtn;
	}


	public WebElement getSearchEdt() {
		return searchEdt;
	}


	public WebElement getSearchDD() {
		return searchDD;
	}


	public WebDriver getDriver() {
		return driver;
	}


	public WebElement getCreateOrgLink() {
		return createOrgLink;
	}
}
