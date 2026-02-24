package practice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvoiceTestForRetry {
	@Test(retryAnalyzer=com.comcast.listenerutilitypac.RetryListenerImp.class)
	public void createInvoiceTest() {
		System.out.println("Execute createInvoiceTest");
//		String actTitle=driver.getTitle();
		Assert.assertEquals(" ", "LogIn");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
}
