package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ResultsPage {
	WebDriver driver;
	ElementUtil eleUtil;
	private By searchLocator = By.cssSelector("div#content h1");
	private By results = By.cssSelector("div.product-thumb");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	public String getsearchHeader() {
		String searchHeaderValue = eleUtil.waitForelementVisible(searchLocator, AppConstants.Default_short_time_out)
				.getText();
		return searchHeaderValue;

	}
	
	public int getResultsCount() {
		int resultsCount = eleUtil.waitForElementsVisible(results, AppConstants.Default_short_time_out).size();
		System.out.println("Results Count is " + resultsCount);
		return resultsCount;
				
	}
	
	public ProductInfoPage selectProductLink(String productName) {
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
		
	}

	public ProductInfoPage selectProduct(String productName) {
		System.out.println("selecting product: " + productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}
	
	
	
	
	
}
