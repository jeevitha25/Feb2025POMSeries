package com.qa.opencart.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.pages.LoginPage;

public class RegisterPageTest extends BaseTest {
	
	@BeforeClass
	public void regSetup() {
		registerPage = loginPage.navigateToRegisterPage();
		
	}
	
	@Test
	public String getRandomEmail() {
		return "uiautomation" + System.currentTimeMillis()+ "@gmail.com";
		
	}
	
	
	@Test
	public void userRegisterationTest() {
		Assert.assertTrue(
		registerPage.userRegisteration("Riya", "automation", getRandomEmail(), "9448181812", "password123", "yes"
	));}

}
