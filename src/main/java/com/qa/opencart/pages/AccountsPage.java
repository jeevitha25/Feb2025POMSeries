package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {
	private WebDriver driver;
	private ElementUtil eleutil;
	
	
	private By logoutLink = By.linkText("Logout");
	private By headers = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("div#search button");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new ElementUtil(driver);
	}

	public String getAccountsPageTitle() {
		String title = ElementUtil.waitForTitleContainsAndReturn(AppConstants.AccountsPageTitle,
				AppConstants.Default_short_time_out);
		System.out.println("Accounts page title is .." + title);
		return title;

	}

	public boolean isLogoutLinkExist() {
		return eleutil.doElementIsDisplayed(logoutLink);
	}
	
	public int getTotalAccountsPageHeaderCount() {
		return ElementUtil.waitforElementsVisible(headers, AppConstants.Default_medium_time_out).size();
		
	}

	public List<String> getAccountsPageHeaders() {
		List<WebElement> headersList = ElementUtil.waitforElementsVisible(headers, AppConstants.Default_medium_time_out);
		List<String> headersValueList = new ArrayList<String>();
		for (WebElement e : headersList) {
			String header = e.getText();
			headersValueList.add(header);

		}
		return headersValueList;
	}
	
	public ResultsPage doSearch(String searchKey) {
		System.out.println("Search key is  " + searchKey);
		ElementUtil.waitforElementVisible(search, AppConstants.Default_short_time_out);
		eleutil.doSendKeys(search, searchKey);
		eleutil.doClick(searchIcon);
		return new ResultsPage(driver);
		
	}
}
