package com.sevenrmartsupermarket.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;


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
	
	public AdminUsersPage clickOnAdminMoreInfo1()
	{
		
		adminMoreinfo.click();
		return new AdminUsersPage(driver);
	}

}
