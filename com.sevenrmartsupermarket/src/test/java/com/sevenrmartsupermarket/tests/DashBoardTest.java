package com.sevenrmartsupermarket.tests;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class DashBoardTest extends Base {
	DashBoardPage dashboardpage; 
	LoginPage loginpage;
	AdminUsersPage adminuserspage;
	Properties properties = new Properties();
	
	@Test(groups="smoke")
	public void verifyClickonAdminMoreInfo() {
		dashboardpage=new DashBoardPage(driver);
		loginpage=new LoginPage(driver);
		adminuserspage=new AdminUsersPage(driver);
		loginpage.login("admin", "admin");
		boolean actualresult=dashboardpage.clickOnAdminMoreInfo();
		//boolean expectedresult=true;
		Assert.assertTrue(actualresult);
	}
}
