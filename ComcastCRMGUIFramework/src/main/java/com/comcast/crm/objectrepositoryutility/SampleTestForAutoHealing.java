package com.comcast.crm.objectrepositoryutility;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SampleTestForAutoHealing {
	
	WebDriver driver;
	
    public SampleTestForAutoHealing(WebDriver driver) {
 	   this.driver=driver;
		    PageFactory.initElements(driver, this);
	    }
    
    @FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindAll({@FindBy(id="submitButton1"),@FindBy(xpath="//input[@value='Login']")})
	private WebElement loginBtn;
	
	@Test
	public void test1() {
		driver =new ChromeDriver();
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		usernameEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		loginBtn.click();
	}

}
