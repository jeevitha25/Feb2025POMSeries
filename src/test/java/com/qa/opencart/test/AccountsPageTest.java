package com.qa.opencart.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.util.Objects;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class AccountsPageTest extends BaseTest {

    @BeforeClass
	
    public void setup() {
//        System.out.println("🔍 Debug: Checking `prop` in AccountsPageTest: " + prop);
//
//        if (prop == null) {
//            throw new RuntimeException("❌ ERROR: `prop` is NULL in AccountsPageTest! BaseTest setup failed.");
//        }
//
//        accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
//        System.out.println("✅ AccountsPageTest setup completed.");
    	accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void accPageTitleTest() {
        String actTitle = accPage.getAccountsPageTitle();
        Assert.assertEquals(actTitle, AppConstants.AccountsPageTitle, "Account page title mismatch.");
    }

    @Test
    public void isLogoutLinkExistTest() {
        Assert.assertTrue(accPage.isLogoutLinkExist(), "Logout link is missing.");
    }
    
    
    @DataProvider
    public Object[][] getSearchKey() {
    	return new Object[][] {
    		{"macbook", 3},
    		{"imac", 1},
    		{"samsung", 1}
    	};
    	
    }
    @Test(dataProvider= "getSearchKey")
    public void searchCountTest(String searchKey, int searchCount) {
      	resultsPage = accPage.doSearch(searchKey);
      	Assert.assertEquals(resultsPage.getResultsCount(), searchCount);
    }
    @DataProvider
	public Object[][] getSearcExcelData() {
		return ExcelUtil.getTestData(AppConstants.SEARCH_SHEET_NAME);
	}
    
    
//    @Test
//    public void searchTest() {
//    	resultsPage = accPage.doSearch("macbook");
//    	resultsPage.selectProductLink("MackBook Pro");
//    	//resultsPage.getsearchHeader();
//    	Assert.assertEquals(resultsPage.getsearchHeader(), "MackBook Pro");
//    	
//    }
    
	@Test(dataProvider = "getSearcExcelData")
	public void searchTest(String searchKey, String productName) {
		resultsPage = accPage.doSearch(searchKey);
		productInfoPage = resultsPage.selectProduct(productName);
		Assert.assertEquals(productInfoPage.getProductHeader(), productName);
	}

}
