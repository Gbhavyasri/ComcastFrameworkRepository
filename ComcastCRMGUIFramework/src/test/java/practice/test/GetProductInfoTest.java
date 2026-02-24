package practice.test;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoTest {
	
	@Test(dataProvider="getData")
	public void getproductInfoTest(String brand,String pathName) {
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(brand);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		System.out.println(driver.findElement(By.xpath("//span[text()='"+pathName+"']/../../../..//span[@class='a-price']")).getText());
		driver.quit();
		
	}
	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, IOException {
		ExcelUtility eLib=new ExcelUtility();
		int count=eLib.getRowCount("Sheet1");
		
		
		Object[][] dataObj=new Object[count][2];
		for(int i=0;i<=count;i++) {
			dataObj[i][0]=eLib.getDataFromExcel("Sheet1", i, 0);
			dataObj[i][1]=eLib.getDataFromExcel("Sheet1", i, 1);
		}
//		dataObj[0][0]="mobiles";
//		dataObj[0][1]="iPhone 17 Pro 512 GB: 15.93 cm (6.3″) Display with Promotion up to 120Hz, A19 Pro Chip, Breakthrough Battery Life, Pro Fusion Camera System with Center Stage Front Camera; Cosmic Orange";
//		dataObj[1][0]="mobiles";
//		dataObj[1][1]="iPhone 17 Pro Max 256 GB: 17.42 cm (6.9″) Display with Promotion, A19 Pro Chip, Best Battery Life in Any iPhone Ever, Pro Fusion Camera System, Center Stage Front Camera; Deep Blue";
//		dataObj[2][0]="mobiles";
//		dataObj[2][1]="Redmi A4 5G (Sparkle Purple, 4GB RAM, 128GB Storage) | Segment Largest 6.88in 120Hz | 50MP Dual Camera | 18W Fast Charging | Charger in The Box";
	   return dataObj;
	}
	

}
