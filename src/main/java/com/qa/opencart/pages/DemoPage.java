package com.qa.opencart.pages;

import org.openqa.selenium.By;

public class DemoPage {
	static int i=15;
	public static void main(String[] args) {
		
		//updated the locator
		By userId= By.cssSelector("demo");
		//updated the existing class file
		System.out.println("the number is "+  i);
		
	}

}
