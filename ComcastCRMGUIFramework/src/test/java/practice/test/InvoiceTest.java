package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
@Listeners(com.comcast.listenerutilitypac.ListImpClass.class)//-->Without this we can even declare the Listener inside the xml file
public class InvoiceTest extends BaseClass{
	@Test
	public void createInvoiceTest() {
		System.out.println("Execute createInvoiceTest");
		String actTitle=driver.getTitle();
		Assert.assertEquals(actTitle, "LogIn123");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void createInvoicewithContact() {
		System.out.println("Execute createInvoicewithContact");
	}
	

}
