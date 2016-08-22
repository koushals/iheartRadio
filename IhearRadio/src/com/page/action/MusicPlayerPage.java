package com.page.action;

import org.openqa.selenium.By;

import com.page.driver.BaseClass;
import com.page.locators.MusicPlayerEnum;

public class MusicPlayerPage extends BaseClass{
	
	static By time = By.id(MusicPlayerEnum.TIMEPLAYED_ID.toString());
	static By like = By.id(MusicPlayerEnum.LIKE_ID.toString());
	static By love = By.id(MusicPlayerEnum.LOVE_ID.toString());
	static By next = By.id(MusicPlayerEnum.NEXT_ID.toString());
	
	
	public static String getTime() {
		return getText(time);
	}
	
	
	public static boolean likeisDisplayed() {
		try {
			return element(like).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public static boolean nextisDisplayed() {
		try {
			return element(next).isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

}
