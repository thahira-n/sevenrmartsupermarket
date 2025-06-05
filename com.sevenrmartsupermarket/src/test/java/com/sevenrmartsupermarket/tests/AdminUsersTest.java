package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.AdminUsersPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class AdminUsersTest extends Base {
	DashBoardPage dashboardpage;
	AdminUsersPage adminuserspage;
	LoginPage loginpage;
	
	@Test(groups={"smoke","regression"})
	public void verifyNewUserCreation()
	{
		adminuserspage=new AdminUsersPage(driver);
		dashboardpage=new DashBoardPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.clickOnAdminMoreInfo1();
		String actualResult=adminuserspage.create_NewUser("ThahiraNasar","asdfg","Admin");
		
		String expectedResult="×\n"+"Alert!\n"+"User Created Successfully";
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	@Test
	public void verifyUserSearch() {
		adminuserspage=new AdminUsersPage(driver);
		dashboardpage=new DashBoardPage(driver);
		loginpage=new LoginPage(driver);
		loginpage.login("admin", "admin");
		dashboardpage.clickOnAdminMoreInfo1();
		adminuserspage.search_User("Nihar","Admin");
	}
	

}
