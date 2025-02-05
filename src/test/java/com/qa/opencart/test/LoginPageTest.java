package com.qa.opencart.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest {

    @Test
    public void loginPageTitleTest() {
        String actTitle = loginPage.getLoginPageTitle();
        System.out.println("Actual Login Page Title: " + actTitle);
        assertEquals(actTitle, AppConstants.loginPageTitle, "Login page title mismatch.");
    }

    @Test
    public void loginPageUrlTest() {
        String actUrl = loginPage.getLoginPageUrl();
        System.out.println("Actual Login Page URL: " + actUrl);
        assertTrue(actUrl.contains(AppConstants.LoginPageUrl), "Login page URL is incorrect.");
    }

    @Test
    public void forgotPwdLinkExistTest() {
        assertTrue(loginPage.isForgotPwdLink(), "Forgot Password link is missing.");
    }

    @Test
    public void logoExistTest() {
        assertTrue(loginPage.isLogoDisplayed(), "Logo is not displayed.");
    }

    @Test(priority= Integer.MAX_VALUE)
    public void loginTest() {
    	
    	System.out.println("hi");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        if (username == null || password == null) {
            throw new RuntimeException("Username or password not found in properties file.");
        }

        accPage = loginPage.doLogin(username, password);
        assertEquals(accPage.getAccountsPageTitle(), AppConstants.AccountsPageTitle, "Account page title mismatch.");
    }
}
