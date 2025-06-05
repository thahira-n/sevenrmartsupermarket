package com.sevenrmartsupermarket.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class DashBoardPage {
	WebDriver driver;
	AdminUsersPage adminuserspage;
	GeneralUtility generalutilty;
	@FindBy(xpath="//a[@class='d-block']")
	LoginPage loginpage=new LoginPage(driver);
	private WebElement	profileNameElement;	
	@FindBy(xpath="//div[@class='small-box bg-info']//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']")
	private WebElement adminMoreinfo;
	
	public DashBoardPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public String getProfileName() {
		return profileNameElement.getText();
	}
	
	public boolean clickOnAdminMoreInfo() {
		adminuserspage=new AdminUsersPage(driver);
		adminMoreinfo.click();
		boolean b=adminuserspage.adminUsersTableDisplayed();
		return b;
	}
	
	public void clickOnAdminMoreInfo1()
	{
		
		adminMoreinfo.click();
	}
	
	
	
	
	
	

}
