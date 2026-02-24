package practice.hometest;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageverificationTest {
	
	
	@Test
	public void homePageTest(Method mtd) {
		System.out.println(mtd.getName()+" Test Start  ");
		String expectedPage="HomePage";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		String actTitle=driver.findElement(By.xpath("//a[contains(text(),'Home')]")).getText();
		
//		if(actTitle.equals(expectedPage)) {
//			System.out.println(expectedPage+" Page is Verified==PASS");
//		}
//		else {
//			System.out.println(expectedPage+" Page is not verified==FAIL");
//		}
		Assert.assertEquals(actTitle, expectedPage);
		System.out.println(mtd.getName()+" Test End  ");
		driver.quit();
		
	}
	@Test
	public void verifyLogoHomePage(Method mtd) {
		String expectedPage="Home";
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://49.249.28.218:8888/index.php?action=Login&module=Users");
		
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		boolean status=driver.findElement(By.xpath("//img[@title='vtiger-crm-logo.gif']")).isEnabled();
		
	 Assert.assertTrue(status);
		System.out.println(mtd.getName()+" Test End  ");
		driver.quit();
	}

}
