package com.page.action;

import org.openqa.selenium.By;

import com.page.driver.BaseClass;
import com.page.locators.MusicPlayerEnum;

public class MusicPlayerPage extends BaseClass{
	
	static By time = By.id(MusicPlayerEnum.TIMEPLAYED_ID.toString());
	static By like = By.id(MusicPlayerEnum.LIKE_ID.toString());
	static By dislike = By.id(MusicPlayerEnum.DISLIKE_ID.toString());
	static By love = By.id(MusicPlayerEnum.LOVE_ID.toString());
	static By next = By.id(MusicPlayerEnum.NEXT_ID.toString());
	
	
	public static String getTime() {
		return getText(time);
	}
	
	
	public static boolean likeisDisplayed() {
		return elementisDisplayed(like);
	}
	
	public static boolean dislikeisDisplayed() {
		return elementisDisplayed(dislike);
	}
	
	public static boolean loveisDisplayed() {
		return elementisDisplayed(love);
	}
	
	public static boolean nextisDisplayed() {
		return elementisDisplayed(next);
	}

}
