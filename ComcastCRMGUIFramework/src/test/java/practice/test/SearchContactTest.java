package practice.test;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
     @Test
     public void searchContactTest() {
    	 /*Step 1: Login to the application*/
    	 LoginPage lp=new LoginPage(driver);
    	 lp.loginToApp("url", "username", "password");
     }
}
