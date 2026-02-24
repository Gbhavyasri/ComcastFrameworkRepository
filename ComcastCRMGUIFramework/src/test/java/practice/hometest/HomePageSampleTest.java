package practice.hometest;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class HomePageSampleTest {
	
	@Test
	public void homePageTest() {
		Reporter.log("step1",true);//If we pass the second arguement as the true then the the statements will get added in the console log also and html report also
		Reporter.log("step2");//it only displays on the html report only
		Reporter.log("step3");
		Reporter.log("step4");
	}

}
