package com.qa.dontknow.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.dontknow.page.UsingDataFromExcel;

public class BaseTest {
	public BasePage bp;
	public Properties prop;
	public WebDriver driver;
	public UsingDataFromExcel UDFE;
	
	@Parameters("browser")
	@BeforeTest
	public void setUp(String browserName) {
		bp = new BasePage();
		prop = bp.init_prop();
		prop.setProperty("browser", browserName);
		driver = bp.init_driver(prop);
		UDFE = new UsingDataFromExcel(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
