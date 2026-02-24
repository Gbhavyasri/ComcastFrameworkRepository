package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class DemoWebShop_DP {
	@Test(dataProvider="getData")
	public void SearchTest(String productName) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://demowebshop.tricentis.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath("//div[@class='header-menu']//descendant::li/a[contains(text(),'Computers')]"));
		Actions action=new Actions(driver);
		action.moveToElement(ele).click(driver.findElement(By.xpath("//a[contains(text(),'Desktops')]"))).perform();
		action.scrollByAmount(0, 100).perform();
		String price=driver.findElement(By.xpath("//a[text()='"+productName+"']/../../..//span[@class='price actual-price']")).getText();
		System.out.println(price);
		driver.quit();
		
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
		
		
		ExcelUtility eLib=new ExcelUtility();
		int count=eLib.getRowCount("Sheet1");
		Object[][] obj=new Object[count+1][1];
		for(int i=0;i<=count;i++) {
			obj[i][0]=eLib.getDataFromExcel("Sheet1", i, 0);
		}
		return obj;
		
	}

}
