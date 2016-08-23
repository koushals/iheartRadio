package com.test.problem;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.page.action.HomePage;
import com.page.action.LoginPage;
import com.page.action.MySuggestionsPage;
import com.page.asserts.MusicPlayerAssert;
import com.page.driver.BaseClass;
import com.test.utils.PropertyUtil;
import com.test.utils.ShellUtils;

import io.appium.java_client.AppiumDriver;


public class Test_iheartRadio extends BaseClass{
	
	AppiumDriver<WebElement> driver;
	private final static String fileName= "iHeartRadio.properties";
	PropertyUtil p = new PropertyUtil(fileName);
	
	@BeforeTest
	public void	createTheInstance() throws Exception{
		 startDriverForApp(fileName);
	}
	
	@Test
	public void	rigisterAnewUser() throws Exception{
		LoginPage.tapSkip();
		String email = p.getPropertiesFromFile(fileName).getProperty("email");
		String password = p.getPropertiesFromFile(fileName).getProperty("password");
		LoginPage.loginPage(email, password);
		HomePage.tapOnMySuggestion();
		MySuggestionsPage.selectFromStations(0);
		String result = MusicPlayerAssert.elementsAreDisplayedInMusicPage();
		Assert.assertEquals(result.length(), 0,"there are missing fields");
		Thread.sleep(50000);
	}
	
	@AfterTest
	public void closeTheDevice() throws Exception{
		takeScreenShot();
		closeApp();
		ShellUtils.uninstallApp(PropertyUtil.getPropertiesFromFile(fileName).getProperty("appPackage"));
		acceptNotifications();
	}


}
