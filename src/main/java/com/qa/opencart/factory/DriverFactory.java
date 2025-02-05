package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.opencart.exceptions.BrowserException;

public class DriverFactory {
    WebDriver driver;
    Properties prop;

    public WebDriver initDriver(Properties prop) {
        String browserName = prop.getProperty("browser");
        System.out.println("🔍 DriverFactory: Using browser: " + browserName);

        switch (browserName.toLowerCase().trim()) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("❌ Please pass the right browser name: " + browserName);
                throw new BrowserException("Invalid browser name specified: " + browserName);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));

        return driver;
    }

    public Properties initProp() {
        prop = new Properties();
        
        try {
            // Provide correct path to your properties file
            FileInputStream ip = new FileInputStream("./src/test/resources/config/config1.properties");
            prop.load(ip);
            System.out.println("✅ Properties loaded: " + prop);
        } catch (FileNotFoundException e) {
            System.out.println("❌ ERROR: Properties file not found!");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("❌ ERROR: Unable to load properties file!");
            e.printStackTrace();
        }
        return prop;
    } 

}
