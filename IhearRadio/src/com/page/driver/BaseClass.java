package com.page.driver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.page.locators.LoginPageEnum;
import com.test.utils.PropertyUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BaseClass {
	
	public static AppiumDriver<?> appiumDriver;
	private final static String DEVICENAME =  "deviceName";	
	private final static String PLATFORMVERSION =  "platformversion";
	private final static String APPPACKAGE =  "appPackage";
	private final static String APP =  "app";
	private final static String PLATFORMNAME =  "platformName";
	private final static String APPACTIVITY =  "appActivity";
	private final static String APKFILENAME =  "apkFileName";
	private final static String URL =  "url";
	DesiredCapabilities capablities;
	Properties p;
	private  By ok = By.name(LoginPageEnum.OK_NAME.toString());
	
	public AppiumDriver<?> startDriverForApp(String fileName) throws Exception {
		p = PropertyUtil.getPropertiesFromFile(fileName);
		File f = new File(System.getProperty("user.dir")+"\\app\\"+p.getProperty(APKFILENAME));
		capablities = new DesiredCapabilities();
		capablities.setCapability(DEVICENAME,p.getProperty(DEVICENAME));
		capablities.setCapability(PLATFORMNAME, p.getProperty(PLATFORMNAME));
		capablities.setCapability(PLATFORMVERSION, p.get(PLATFORMVERSION));
		capablities.setCapability(APP, f.getAbsolutePath());
		appiumDriver = new AndroidDriver<>(new URL(p.getProperty(URL)), capablities);
		appiumDriver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
		return appiumDriver;
	}
	
	public  AppiumDriver<?> startChromeBrowser(String fileName) throws Exception {
		p = PropertyUtil.getPropertiesFromFile(fileName);
		capablities = new DesiredCapabilities();
		capablities.setCapability("BROWSER_NAME", "chrome");
		capablities.setCapability("VERSION", "5.1.1"); 
		capablities.setCapability(DEVICENAME,p.getProperty(DEVICENAME));
		capablities.setCapability(PLATFORMNAME, p.getProperty(PLATFORMNAME));
		capablities.setCapability(APPPACKAGE, p.getProperty(APPPACKAGE));
		capablities.setCapability(APPACTIVITY, p.getProperty(APPACTIVITY));
		appiumDriver = new AndroidDriver<>(new URL(p.getProperty(URL)), capablities);
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return appiumDriver;
	}

	
	public AppiumDriver<?> startDriverForNativeApp(String fileName) throws Exception {
 		Properties p = PropertyUtil.getPropertiesFromFile(fileName);
		DesiredCapabilities capablities = new DesiredCapabilities();
		capablities.setCapability(DEVICENAME,p.getProperty(DEVICENAME));
		capablities.setCapability(PLATFORMNAME, p.getProperty(PLATFORMNAME));
		capablities.setCapability(APPPACKAGE, p.getProperty(APPPACKAGE));
		capablities.setCapability(PLATFORMVERSION, p.get(PLATFORMVERSION));
		capablities.setCapability(APPACTIVITY, p.getProperty(APPACTIVITY));
		appiumDriver = new AndroidDriver<>(new URL(p.getProperty(URL)), capablities);
		appiumDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return appiumDriver;
	}
	
	
	protected static WebElement element(By locator){
		return appiumDriver.findElement(locator);
	}
	
	protected static String getText(By locator) {
		 return element(locator).getText();
	}
	
	protected static List<WebElement> elements(By locator) {
		return (List<WebElement>) appiumDriver.findElements(locator);
	}
	
	public static boolean elementisDisplayed(By locator) {
		try {
			return element(locator).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	protected  static void closeApp() {
		appiumDriver.navigate().back();
		appiumDriver.navigate().back();
	}
	
	protected static void resetApp() {
		appiumDriver.resetApp();
	}
	
	protected static int getSize(By locator) {
		return appiumDriver.findElements(locator).size();
	}
	
	
	protected static void removeApplication(String bundleId) {
		appiumDriver.resetApp();
	}
	
	protected void acceptNotifications() {
		element(ok).click();
	}
	
	
	protected void swipeUp() {
		int starty = (int) (appiumDriver.manage().window().getSize().getHeight()*0.7);
		int endy = (int) (appiumDriver.manage().window().getSize().getHeight()*0.1);
		int startx = (int) (appiumDriver.manage().window().getSize().getWidth()*0.2);
		appiumDriver.swipe(startx, starty, startx, endy, 1000);
		
	}
	
	
	protected static void takeScreenShot() {
		  String destDir = "outputScreenshots";
		  File scrFile = appiumDriver.getScreenshotAs(OutputType.FILE);
		  String destFile =System.getProperty("user.dir").replace("\\", "/")+
				  "/"+destDir + "/" + System.currentTimeMillis()+".jpg";
		  try {
			  System.out.println();
		   FileUtils.copyFile(scrFile, new File(destFile));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	 }
	
	protected static void takeScreenShot(String filename) {
		  String destDir = "outputScreenshots";
		  File scrFile = appiumDriver.getScreenshotAs(OutputType.FILE);
		  String destFile =System.getProperty("user.dir").replace("\\", "/")+
				  "/"+destDir + "/" + filename+System.currentTimeMillis()+".jpg";
		  try {
			  System.out.println();
		   FileUtils.copyFile(scrFile, new File(destFile));
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
	 }
	
	protected void changeContext(String context) {
		appiumDriver.context(context);
	}
	protected static void loadPage(String url) {
		
		appiumDriver.get(url);
	}
	

}