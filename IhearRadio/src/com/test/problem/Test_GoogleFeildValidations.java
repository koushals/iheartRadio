package com.test.problem;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.action.GoogleSearch;
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
		Assert.assertTrue(GoogleSearch.searchIconIsDisplayed());
		Assert.assertTrue(GoogleSearch.searchTextFieldIsDisplayed());
	}
	
	@Test
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
		
		Assert.assertEquals(GoogleSearch.getLinkText(), p.getPropertiesFromParameter("expectedLink"));
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
