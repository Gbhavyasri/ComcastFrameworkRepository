package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {
WebDriver driver;
	
    public CreateNewContactPage(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    
    @FindBy(xpath="//input[@name='lastname']")
    private WebElement lastNameEdt;
    
    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

    @FindBy(xpath="//input[@name='support_start_date']")
    WebElement startDateEdt;
    
    @FindBy(xpath="//input[@name='support_end_date']")
    WebElement endDateEdt;
    @FindBy(xpath="//input[@name='account_id']/following-sibling::img[@src='themes/softed/images/select.gif']")
    private WebElement selectOrgEdt;
    
    @FindBy(name="search_text")
    private WebElement serachField;
    
    @FindBy(name="search")
    private WebElement searchBtn;
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getSelectOrgEdt() {
		return selectOrgEdt;
	}

	public WebElement getSerachField() {
		return serachField;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
    
	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		
		saveBtn.click();
	}
	public void createContact(String lastName,String startDate,String endDate) {
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}
	public void createContactwithOrg(String lastName) {
		lastNameEdt.sendKeys(lastName);
		selectOrgEdt.click();
		 
	}
}
