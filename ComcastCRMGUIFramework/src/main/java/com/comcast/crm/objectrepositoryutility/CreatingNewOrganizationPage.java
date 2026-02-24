package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	WebDriver driver;
	
    public CreatingNewOrganizationPage(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    
    
    @FindBy(xpath="//input[@name='accountname']")
    private WebElement orgnizationNameEdt;
    @FindBy(xpath="//textarea[@name='ship_street']")
    private WebElement shippingNameEdt;
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
    
    
    @FindBy(name="industry")
    WebElement industryDB;
    
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getOrgnizationNameEdt() {
		return orgnizationNameEdt;
	}
	public WebElement getShippingNameEdt() {
		return shippingNameEdt;
	}

	public void createOrg(String orgName,String shippingAddress) {
		orgnizationNameEdt.sendKeys(orgName);
		shippingNameEdt.sendKeys(shippingAddress);
		saveBtn.click();
	}
	
	public void createOrg(String orgName,String shippingAddress,String industry) {
		orgnizationNameEdt.sendKeys(orgName);
		shippingNameEdt.sendKeys(shippingAddress);
		Select sel=new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
   

	
    
}
