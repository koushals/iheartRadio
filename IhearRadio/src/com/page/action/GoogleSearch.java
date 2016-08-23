package com.page.action;

import org.openqa.selenium.By;

import com.page.driver.BaseClass;
import com.page.locators.GoogleSearchEnum;

public class GoogleSearch extends BaseClass {
	
	private static By searchTextField= By.xpath(GoogleSearchEnum.SEARCH_BAR_XPATH.toString());
	private static By searchIcon= By.xpath(GoogleSearchEnum.SEARCH_ICON_XPATH.toString());
	private static By getLinktext= By.xpath(GoogleSearchEnum.LINK_XPATH.toString());
	private static By allow= By.name(GoogleSearchEnum.ALLOW_ID.toString());
	
	public static boolean searchTextFieldIsDisplayed() {
		return elementisDisplayed(searchTextField);
	}

	public static boolean searchIconIsDisplayed() {
		return elementisDisplayed(searchIcon);
	}
	
	public static void allowNotification() {
		try {
			element(allow).click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void searchText(String text) throws InterruptedException {
		element(searchTextField).sendKeys(text);
		Thread.sleep(3000);	
		element(searchIcon).click();
	}
	
	public static String getLinkText() {
		return getText(getLinktext);
	}
	

}
