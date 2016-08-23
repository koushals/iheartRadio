package com.page.asserts;

import com.page.action.MusicPlayerPage;
import com.page.driver.BaseClass;

public class MusicPlayerAssert extends BaseClass{

	public static String elementsAreDisplayedInMusicPage() {
		StringBuffer buffer = new StringBuffer();
		try {
			myAssert(MusicPlayerPage.likeisDisplayed(), buffer, "like ");
			myAssert(MusicPlayerPage.nextisDisplayed(), buffer, "next ");
			myAssert(MusicPlayerPage.loveisDisplayed(), buffer, "love ");
			myAssert(MusicPlayerPage.dislikeisDisplayed(), buffer, "dislike");
		} catch (Exception e) {
			buffer.append("catch exception");
		}
		return buffer.toString();
	}
	
	
}
