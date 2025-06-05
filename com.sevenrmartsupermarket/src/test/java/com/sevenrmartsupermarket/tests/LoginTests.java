package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.dataproviders.DataProviders;

import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

import com.sevenrmartsupermarket.utilities.ExcelReader;

public class LoginTests extends Base {
	LoginPage loginpage;
	DashBoardPage dashboardpage;
	ExcelReader excelreader = new ExcelReader();

	@Test(groups = { "smoke", "regression" })
	public void verifyLoginWithValidData() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login("admin", "admin");
		String actualProfileName = dashboardpage.getProfileName();
		String expectedProfileName = "Admin";
		Assert.assertEquals(actualProfileName, expectedProfileName);

	}

	@Test(dataProvider = "projectsitelogin", dataProviderClass = DataProviders.class)
	public void verifyLoginWithDataProviderData(String name, String value) {
		excelreader.setExcelFile("Sheet2");
		excelreader.getCellData(0, 0);

		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login(name, value);
		boolean actualvalue = loginpage.isAlertBoxPresent();
		boolean expectedvalue = true;
		Assert.assertEquals(actualvalue, expectedvalue);

	}

	@Test(groups = "smoke")
	public void verifyTextOfLoginFailAlert() {
		loginpage = new LoginPage(driver);
		loginpage.login("thahira", "1234");
		String actualTextOfAlert = loginpage.get_TextOfAlertOfInvalidUserNameOrPassword();
		String expectedTextOfAlert = "×\n" + "Alert!\n" + "Invalid Username/Password";
		System.out.println(actualTextOfAlert);
		Assert.assertEquals(actualTextOfAlert, expectedTextOfAlert);

	}

}
