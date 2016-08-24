package com.test.problem;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.action.GoogleSearch;
import com.page.asserts.GoogleSearchAssert;
import com.page.driver.BaseClass;
import com.test.utils.PropertyUtil;

import io.appium.java_client.AppiumDriver;

public class Test_GoogleFeildValidations extends BaseClass {
	
	AppiumDriver<WebElement> driver;
	private final static String fileName= "chrome.properties";
	PropertyUtil p = new PropertyUtil(fileName);
	
	@BeforeTest
	public void	createTheInstance() throws Exception{
		startChromeBrowser(fileName);
	}
	
	
	@Test
	public void	loadGoogle() throws Exception{
		changeContext(p.getPropertiesFromParameter("context"));
		loadPage(p.getPropertiesFromParameter("browserurl"));
		String result = GoogleSearchAssert.searchForElementsInGooglePage();
		Assert.assertEquals(result.length(), 0,"there are fields missing");
	}
	
	@Test(alwaysRun = true)
	public void	searchGoogle() throws Exception{
		loadPage(p.getPropertiesFromParameter("browserurl"));
		changeContext(p.getPropertiesFromParameter("context1"));
		GoogleSearch.allowNotification();
		changeContext(p.getPropertiesFromParameter("context"));
		GoogleSearch.searchText(p.getPropertiesFromParameter("search"));
		changeContext(p.getPropertiesFromParameter("context1"));
		GoogleSearch.allowNotification();
		swipeUp();
		changeContext(p.getPropertiesFromParameter("context"));
		String result = GoogleSearchAssert.assertLink(p.getPropertiesFromParameter("expectedLink"));
		Assert.assertEquals(result.length(), 0, "there are fields missing");
	}
	
	@AfterMethod
	public void	takescreenshots(){
		takeScreenShot();	
	}
	
	@AfterTest
	public void	closeApplication(){
	closeApp();
	}

}
