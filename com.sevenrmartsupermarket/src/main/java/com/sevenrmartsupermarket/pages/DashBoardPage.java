package com.sevenrmartsupermarket.pages;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;


public class DashBoardPage {
	WebDriver driver;
	ManageContactPage managecontactpage;
	AdminUsersPage adminuserspage;
	GeneralUtility generalutilty;
	LoginPage loginpage=new LoginPage(driver);
	@FindBy(xpath="//a[@class='d-block']")
	private WebElement	profileNameElement;	
	@FindBy(xpath="//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminMoreinfo;
	@FindBy(xpath="//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']")
	private WebElement manageContactMoreinfo;
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getProfileName() {
		return profileNameElement.getText();
	}
	
	public boolean adminUsersTableDisplayed() {
	 adminuserspage=clickOnAdminMoreInfo1();
		return adminuserspage.adminUsersTableDisplayed();
		
	}
	
	public AdminUsersPage clickOnAdminMoreInfo1()
	{ 
		WaitUtility waitutility=new WaitUtility(driver);
		waitutility.elementtoBeClickable(adminMoreinfo, 10);
		adminMoreinfo.click();
		return new AdminUsersPage(driver);
	}
	
	public ManageContactPage clickOnManageContactMoreInfo() {
		manageContactMoreinfo.click();
		return new ManageContactPage(driver); 
		
	}
	
	public boolean contactDetailsTableDisplayed() {
		managecontactpage=clickOnManageContactMoreInfo();
		return managecontactpage.contactDetailsTableDisplayed();
	}

}
