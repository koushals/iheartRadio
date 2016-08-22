package com.page.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.page.driver.BaseClass;
import com.page.locators.MySuggestionEnum;

public class MySuggestionsPage extends BaseClass{

	static By titles = By.id(MySuggestionEnum.STATIONS_TITLE_ID.toString());
	
	List<WebElement> list;
	

	public static void selectFromStations(int index){
		elements(titles).get(index).click();
	}

	
	
	
}
