package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {

	private static WebDriver driver;
	private Actions act;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
	}

	public static WebElement getElement(By Locator) {
		return driver.findElement(Locator);
	}

	public void doSendKeys(By locator, String value) {
		WebElement element = getElement(locator);
		element.clear();
		element.sendKeys(value);
	}

	public void doSendKeys(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}

	public void doSendKeys(By locator, String value, int timeOut) {
		waitForElementVisible(locator, timeOut).sendKeys(value);
	}

	public void doSendKeys(By locator, CharSequence... value) {
		getElement(locator).sendKeys(value);
	}

	public static Alert waitforAlertPresent(int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.alertIsPresent());

	}

	public WebElement waitForElementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// checkElementHighlight(element);
		return element;
	}

	public WebElement waitForelementVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		// checkElementHighlight(element);
		return element;
	}
	public List<WebElement> waitForElementsPresence(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	

	public static String waitForTitleContainsAndReturn(String fractionTitle, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.titleContains(fractionTitle));
		return driver.getTitle();
	}

	public static void waitforFrameAndSwitchToItByIdOrName(String idOrName, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(idOrName));
	}

	public static void waitforFrameAndSwitchToItByIndex(int index, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}

	public static void waitforFrameAndSwitchToItByFrameElement(int timeout, WebElement frameElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
	}

	public static void waitforFrameAndSwitchToItByFrameLocator(int timeout, By frameLocator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
	}

	public static List<WebElement> waitforElementsVisible(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}

	public static void waitforElementVisible(By locator, int timeout) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public List<WebElement> waitForElementsVisible(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

//	public WebElement waitForelementVisible(By locator, int timeOut) {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
//		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//		return element;
//	}

	public static String getAlertText(int timeout) {

		return waitforAlertPresent(timeout).getText();

	}

	public static void acceptAlert(int timeout) {
		waitforAlertPresent(timeout).accept();

	}

	public static void dismissAlert(int timeout) {
		waitforAlertPresent(timeout).dismiss();

	}

	public static void alertSendkeys(int timeout, String value) {
		waitforAlertPresent(timeout).sendKeys(value);
	}

	public void doActionSendKeys(By locator, String value) {
		Actions act = new Actions(driver);
		act.sendKeys(getElement(locator), value).build().perform();
	}

	public void doClick(By locator) {
		Actions act = new Actions(driver);
		act.click(getElement(locator)).build().perform();
	}

	public void doClick(By locator, int timeOut) {
		waitForElementVisible(locator, timeOut).click();
	}

	public WebElement waitForElementAndClick(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
		return null;
	}

	public boolean doElementIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}

	public void getElementsAttribute(By locator, String attrName) {
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String attrVal = e.getAttribute(attrName);
			System.out.println(attrVal);
		}

	}

	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	public int getTotalElementsCount(By locator) {
		int eleCount = getElements(locator).size();
		System.out.println("Total Elements :" + locator + "--->" + eleCount);
		return eleCount;
	}

	public static List<String> getElementsTextList(By locator) {
		List<String> eleTextList = new ArrayList<String>();
		List<WebElement> eleList = getElements(locator);
		for (WebElement e : eleList) {
			String text = e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}

	public static void doSelectByIndex(By locator, int index) {
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);

	}

	public static void doSelectByValue(By locator, String value) {
		Select select = new Select(getElement(locator));
		select.selectByValue(value);

	}

	public static List<WebElement> getDropdownOptions(By locator) {
		Select select = new Select(getElement(locator));
		return select.getOptions();

	}

	public static List<String> getDropdownOptionsTextList(By locator) {
		List<WebElement> optionsList = getDropdownOptions(locator);
		List<String> optionstextList = new ArrayList<String>();
		for (WebElement e : optionsList) {
			String text = e.getText();
			optionstextList.add(text);
		}
		return optionstextList;

	}

	public static int totalDropdownOptionsCount(By locator) {
		int optionsCount = getDropdownOptionsTextList(locator).size();
		System.out.println("Total dropdown values count" + "--->" + optionsCount);
		return optionsCount;
	}

	public static WebElement waitforElementPresenceWithFluenceWait(int timeout, int pollingTime, By locator) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
				.pollingEvery(Duration.ofSeconds(pollingTime)).withMessage("element not found");

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public String waitForURLContainsAndReturn(String fractionUrl, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		wait.until(ExpectedConditions.urlContains(fractionUrl));
		return driver.getCurrentUrl();
	}

	public static void selectDropdownValue(By locator, String expValue) {
		List<WebElement> optionsList = getDropdownOptions(locator);
		for (WebElement e : optionsList) {
			String text = e.getText();
			if (text.contains(expValue)) {
				e.click();
				break;
			}
		}
	}

	public static void doSearch(By suggListLocator, String suggName) throws InterruptedException {
		Thread.sleep(1000);

		List<WebElement> suggList = driver.findElements(suggListLocator);
		System.out.println(suggList.size());
		for (WebElement e : suggList) {
			String text = e.getText();
			System.out.println(text);
			if (text.contains(suggName)) {
				e.click();
				break;
			}
		}

	}
}
