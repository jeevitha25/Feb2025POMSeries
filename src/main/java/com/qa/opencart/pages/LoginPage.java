package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;

	private By username = By.id("input-email");
	private By password = By.id("input-password");
	private By forgotPwd = By.linkText("Forgotten Password");
	private By loginbtn = By.xpath("//input[@type ='submit']");
	private By logoImg = By.xpath("//img[@alt='naveenopencart']");
	private By regesterLink = By.linkText("Register");
	
	private ElementUtil eleutil;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);

	}

	public String getLoginPageTitle() {

		String title = ElementUtil.waitForTitleContainsAndReturn(AppConstants.loginPageTitle,
				AppConstants.Default_short_time_out);

		System.out.println("LoginPage title is .." + title);
		return title;

	}

	public String getLoginPageUrl() {
		String url = eleutil.waitForURLContainsAndReturn(AppConstants.LoginPageUrl,
				AppConstants.Default_medium_time_out);
		System.out.println("LoginPage url is .." + url);
		return url;
	}

	public boolean isForgotPwdLink() {
		return eleutil.doElementIsDisplayed(forgotPwd);
		// return driver.findElement(forgotPwd).isDisplayed();
	}

	public boolean isLogoDisplayed() {
		return driver.findElement(logoImg).isDisplayed();

	}

//	public AccountsPage doLogin(String un, String pwd) {
//		System.out.println("Invalid creds are: " + username + " : " + pwd);
//		WebElement usernameElement = eleutil.waitForElementVisible(username, AppConstants.Default_medium_time_out);
//		eleutil.doSendKeys(usernameElement, un);
//		eleutil.doSendKeys(password, pwd);
//		eleutil.doClick(loginbtn);
//		return new AccountsPage(driver);
//	}
	public AccountsPage doLogin(String un, String pwd) {
	    System.out.println("Logging in with creds: " + un + " : " + pwd);
	    WebElement usernameElement = eleutil.waitForElementVisible(username, AppConstants.Default_medium_time_out);
	    eleutil.doSendKeys(usernameElement, un);

	    WebElement passwordElement = eleutil.waitForElementVisible(password, AppConstants.Default_medium_time_out);
	    eleutil.doSendKeys(passwordElement, pwd);

	    WebElement loginButton = eleutil.waitForElementAndClick(loginbtn, AppConstants.Default_medium_time_out);
	   // eleutil.doClick(loginbtn);

	    return new AccountsPage(driver);
	}
	
	public RegisterPage navigateToRegisterPage() {
		eleutil.doClick(regesterLink);
		return new RegisterPage(driver);
		
	}

}
