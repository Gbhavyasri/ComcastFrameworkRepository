package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
      public void waitForPageLoad(WebDriver driver) {
    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      }
      public void waitForElementPresent(WebDriver driver,WebElement ele) {
    	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
    	  wait.until(ExpectedConditions.visibilityOf(ele));
      }
      public void switchNewBrowserTab(WebDriver driver,String partialUrl) {
    	  Set<String> set=driver.getWindowHandles();
    	  Iterator<String> itr=set.iterator();
    	  while(itr.hasNext()) {
    		  String windowId=itr.next();
    		  driver.switchTo().window(windowId);
    		  String actUrl=driver.getCurrentUrl();
    		  if(actUrl.contains(partialUrl)) {
    			  break;
    		  }
    	  }
      }
      public void switchToTabOnTitle(WebDriver driver,String partialTitle) {
    	  Set<String> set=driver.getWindowHandles();
    	  Iterator<String> itr=set.iterator();
    	  while(itr.hasNext()) {
    		  String windowId=itr.next();
    		  driver.switchTo().window(windowId);
    		  String actTitle=driver.getTitle();
    		  if(actTitle.contains(partialTitle)) {
    			  break;
    		  }
    	  }
      }
      public void switchToFrame(WebDriver driver,int index) {
    	  driver.switchTo().frame(index);
      }
      public void switchToFrame(WebDriver driver,String nameId) {
    	  driver.switchTo().frame(nameId);
      }
      public void switchToFrame(WebDriver driver,WebElement ele) {
    	  driver.switchTo().frame(ele);
      }
      public void switchToAlertAndAccept(WebDriver driver) {
    	  driver.switchTo().alert().accept();
      }
      public void switchToAlertAndCancel(WebDriver driver) {
    	  driver.switchTo().alert().dismiss();
      }
      public void select(WebElement ele,String text) {
    	  Select sel=new Select(ele);
    	  sel.selectByVisibleText(text);
      }
      public void select(WebElement ele,int index) {
    	  Select sel=new Select(ele);
    	  sel.selectByIndex(index);
      }
      public void mousemoveOnElement(WebDriver driver,WebElement element) {
    	  Actions action=new Actions(driver);
    	  action.moveToElement(element).perform();
      }

}
