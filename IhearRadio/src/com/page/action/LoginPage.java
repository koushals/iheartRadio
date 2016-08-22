package com.page.action;

import org.openqa.selenium.By;

import com.page.driver.BaseClass;
import com.page.locators.LoginPageEnum;

public class LoginPage extends BaseClass {
	
	static By loginButton = By.name(LoginPageEnum.LOGIN_NAME.toString());
	static By email = By.id(LoginPageEnum.EMAIL_ID.toString());
	static By password = By.id(LoginPageEnum.PASSWORD_ID.toString());
	static By submitButton = By.id(LoginPageEnum.SUBMITBUTTON_ID.toString());
	static By skip = By.name(LoginPageEnum.SKIP_NAME.toString());
	static By ok = By.name(LoginPageEnum.OK_NAME.toString());
	
	private static void enterEmail(String emailString) {
		element(email).sendKeys(emailString);
	}
	
	private static void password(String passwordString) {
		element(password).sendKeys(passwordString);
	}
	
	private static void loginButton() {
		element(loginButton).click();
	}
	
	private static void submitUser() {
		element(submitButton).click();
	}
	
	
	
	public static void tapSkip() {
		element(skip).click();
		element(ok).click();
	}
	
	public static void loginPage(String e, String p) {
		loginButton();
		enterEmail(e);
		password(p);
		submitUser();
	}

}
