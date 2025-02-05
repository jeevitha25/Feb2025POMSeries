package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtil eleutil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By successMessg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}
	
	
	public boolean userRegisteration(String firstName, String lastName,  String email, String telephone,  String password, String subscribe ) {
		 eleutil.waitForelementVisible(this.firstName, AppConstants.Default_medium_time_out).sendKeys(firstName);;
		    eleutil.doSendKeys(this.lastName, lastName);
		    eleutil.doSendKeys(this.email, email);
		    eleutil.doSendKeys(this.telephone, telephone);
		    eleutil.doSendKeys(this.password, password);
		    eleutil.doSendKeys(this.confirmpassword, password);
		    
		    if(subscribe.equals(subscribeYes)) {
		    	eleutil.doClick(subscribeYes);
		    }else
		    {
		    	eleutil.doClick(subscribeNo);
		    }
		    
		    eleutil.doClick(agreeCheckBox);
		    eleutil.doClick(continueButton);
		    
		    String successMsg= eleutil.waitForElementVisible(successMessg, AppConstants.Default_medium_time_out).getText();
		    System.out.println(successMsg);
		    
		    if(successMsg.contains(AppConstants.user_register_successMsg)) {
		    	//eleutil.doClick(logoutLink);
		    	return true;
		    }else {
		    	return false;
		    }
		    

	}
}
