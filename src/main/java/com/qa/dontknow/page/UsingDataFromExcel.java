package com.qa.dontknow.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.dontknow.base.BasePage;
import com.qa.dontknow.utilities.ElementUtil;

public class UsingDataFromExcel extends BasePage {
	
	private WebDriver driver;
	ElementUtil element;

	By usernameInput = By.xpath("//*[@id=\"username\"]");
	By passwordInput = By.xpath("//*[@id=\"password\"]");
	By button = By.xpath("//*[@id=\"login\"]/button");

	public UsingDataFromExcel(WebDriver driver) {
		this.driver = driver;
		element = new ElementUtil(this.driver);
	}

	public void login(String fname, String lname) {
		element.doSendKeys(usernameInput, fname);
		element.doSendKeys(passwordInput, lname);
		element.doClick(button);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
