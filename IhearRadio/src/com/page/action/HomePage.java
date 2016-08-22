package com.page.action;

import org.openqa.selenium.By;

import com.page.driver.BaseClass;
import com.page.locators.HomePageEnum;

public class HomePage extends BaseClass{
	
	static By nofitication = By.id(HomePageEnum.SUGGESTION_ID.toString());
	static By dismiss = By.id(HomePageEnum.DISMISS_ID.toString());
	static By mySuggestionTab = By.name(HomePageEnum.MY_STATIONS_NAME.toString());
	
	public static  void dismissNotifications() {
		try {
			element(nofitication);
			element(dismiss).click();			
		} catch (Exception e) {
		}
	}
	
	public static void tapOnMySuggestion() {
		element(mySuggestionTab).click();	
	}

}
