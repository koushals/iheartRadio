package com.page.asserts;

import com.page.action.GoogleSearch;
import com.page.driver.BaseClass;

public class GoogleSearchAssert  extends BaseClass{
	
	public static String searchForElementsInGooglePage() {
		StringBuffer buffer = new StringBuffer();
		try {
			myAssert(GoogleSearch.searchIconIsDisplayed(), buffer, "Search Icon");
			myAssert(GoogleSearch.searchTextFieldIsDisplayed(), buffer, "Search box");
		} catch (Exception e) {
			buffer.append("catch exception");
		}
		return buffer.toString();
	}
	
	
	public static String assertLink(String expected) {
		StringBuffer buffer = new StringBuffer();
		try {
			myAssert(GoogleSearch.getLinkText().equals(expected), buffer, expected);
		} catch (Exception e) {
			buffer.append("catch exception");
		}
		return buffer.toString(); 
	}
	
	
	

}
