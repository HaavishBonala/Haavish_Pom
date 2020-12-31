package com.qa.dontknow.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.dontknow.base.BaseTest;
import com.qa.dontknow.utilities.Constants;
import com.qa.dontknow.utilities.ExcelUtil;

public class UsingDataFromExcelTest extends BaseTest{
	@DataProvider
	public static Object[][] contactsTestData() {
		Object[][] data = ExcelUtil.getTestData(Constants.EXCEL_SHEET_NAME);
		return data;
	}
	
	@Test(dataProvider = "contactsTestData")
	public void loginWithData(String fname, String lname) {
		System.out.println(fname +"  :  "+ lname);
		System.out.println("--------");
		UDFE.login(fname, lname);
	}
}
