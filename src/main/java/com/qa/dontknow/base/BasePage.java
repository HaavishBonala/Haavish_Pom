package com.qa.dontknow.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.dontknow.utilities.OptionsManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public OptionsManager optionsManager;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	/**
	 * this method is used to initialise the driver on the bases of given browser
	 * name
	 * 
	 * @param prop
	 * @return init_driver
	 */
	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser").trim();
		System.out.println("browser name :" + browserName);
		optionsManager = new OptionsManager(prop);

		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			// driver = new ChromeDriver(optionsManager.ChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.ChromeOptions()));
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			// driver = new FirefoxDriver(optionsManager.FireFoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.FireFoxOptions()));
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.getInstance(SafariDriver.class).setup();
			//driver = new SafariDriver();
			tlDriver.set(new SafariDriver());
		} else {
			System.out.println("no such browser found");
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);

		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	
	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

	/**
	 * this method is used to initialise the properties from config.properties file
	 * 
	 * @return prop
	 */
	public Properties init_prop() {
		prop = new Properties();
		String path = null;
		String env = null;
		
		try {
			env = System.getProperty("env");
			System.out.println("Running on Environment: ---->" + env);
			if(env == null){
				path = "C:\\Users\\pawan\\Desktop\\Haavish\\POM\\src\\main\\java\\com\\qa\\dontknow\\config\\config.properties";
			}
			else{
				switch (env) {
				case "qa":
					path = "C:\\Users\\pawan\\Desktop\\Haavish\\POM\\src\\main\\java\\com\\qa\\dontknow\\config\\qa.config.properties";
					break;
				case "dev":
					path = "C:\\Users\\pawan\\Desktop\\Haavish\\POM\\src\\main\\java\\com\\qa\\dontknow\\config\\dev.config.properties";
					break;
				case "stage":
					path = "C:\\Users\\pawan\\Desktop\\Haavish\\POM\\src\\main\\java\\com\\qa\\dontknow\\config\\stage.config.properties";
					break;
				default:
					System.out.println("Please pass the correct env value....");
					break;
				}
			}
			FileInputStream ip = new FileInputStream(path);
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop;
	}
	
	//take screenshot:
	public String getScreenshot(){
		File src  = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+"/screenshots/"+System.currentTimeMillis()+".png";
		File destination = new File(path);
		try {
			FileUtils.copyFile(src, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}

}
