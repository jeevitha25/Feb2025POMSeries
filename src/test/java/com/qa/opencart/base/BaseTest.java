package com.qa.opencart.base;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;

public abstract class BaseTest {

    protected WebDriver driver;
    protected DriverFactory df;
    protected Properties prop;
    protected LoginPage loginPage;
    protected AccountsPage accPage;
    protected ResultsPage resultsPage;
    protected RegisterPage registerPage;
    protected ProductInfoPage productInfoPage;

   // @BeforeSuite
    @BeforeTest 
    public void setup() {
        System.out.println("🔄 BaseTest: Starting setup...");

        df = new DriverFactory();
        prop = df.initProp();  // Load properties first

        // Check if properties are loaded correctly
        if (prop == null || prop.isEmpty()) {
            throw new RuntimeException("❌ ERROR: Properties file NOT loaded properly in BaseTest.");
        }

        System.out.println("🔑 Properties loaded: " + prop);  // Log properties for verification

        driver = df.initDriver(prop);  // Initialize WebDriver
        loginPage = new LoginPage(driver);

        System.out.println("✅ BaseTest setup completed. Browser launched.");
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}
