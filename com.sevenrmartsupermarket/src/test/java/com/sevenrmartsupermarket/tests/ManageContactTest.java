package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class ManageContactTest extends Base {
	DashBoardPage dashboardpage;
	LoginPage loginpage;

	@Test
	public void verifyContactDetailstableDisplayed() {
		loginpage = new LoginPage(driver);
		dashboardpage = new DashBoardPage(driver);
		loginpage.login();
		boolean actualResult = dashboardpage.contactDetailsTableDisplayed();
		Assert.assertTrue(actualResult);
	}

}
