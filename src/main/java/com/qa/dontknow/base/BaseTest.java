package com.qa.dontknow.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.dontknow.page.UsingDataFromExcel;

public class BaseTest {
	public BasePage bp;
	public Properties prop;
	public WebDriver driver;
	public UsingDataFromExcel UDFE;
	
	@BeforeTest
	public void setUp() {
		bp = new BasePage();
		prop = bp.init_prop();
		driver = bp.init_driver(prop);
		UDFE = new UsingDataFromExcel(driver);
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
