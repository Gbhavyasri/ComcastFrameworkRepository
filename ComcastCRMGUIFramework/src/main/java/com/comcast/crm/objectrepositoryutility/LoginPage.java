package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
/**
 * Author Bhavya Sri Gandepally
 * By the following loginPage one can login to application
 * 
 **/
public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	
       public LoginPage(WebDriver driver) {
    	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }


//	RULE 1: CREATE A SEPARATE JAVA CLASS
//	RULE 2: OBJECT CREATION
	
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login']")})
	private WebElement loginBtn;

	

	
	
//	RULE 4: OBJECT ECAPSULATION
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	
//	RULE 5: PROVIDE ACTION this below is called the business method
	
	public void loginToApp(String url,String username,String password) {
		waitForPageLoad(driver);
		driver.get(url);
		driver.manage().window().maximize();
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}
     
}
