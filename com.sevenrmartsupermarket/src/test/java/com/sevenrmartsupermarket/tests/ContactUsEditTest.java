package com.sevenrmartsupermarket.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.ContactUsEditPage;
import com.sevenrmartsupermarket.pages.DashBoardPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageContactPage;

public class ContactUsEditTest extends Base {
	ContactUsEditPage contactuseditpage;
	DashBoardPage dashboardpage;
	LoginPage loginpage;
	ManageContactPage managecontactpage;
	
	@Test
	public void verifyContactNumberEditing() {
		contactuseditpage=new ContactUsEditPage(driver);
		loginpage=new LoginPage(driver);
		 dashboardpage=new DashBoardPage(driver);
		 managecontactpage=new ManageContactPage(driver); 
		 loginpage.login();
		 dashboardpage.clickOnManageContactMoreInfo();
		 managecontactpage.clickOnContactDetailsEditButton();
		 contactuseditpage.contactNumberEditing();
		 String actualText=contactuseditpage.get_textOfContactUpdationAlert();
		 String expectedText="×\n"+"Alert!\n"+"Contact Created Successfully";
		 Assert.assertEquals(actualText, expectedText);
		
	}

}
