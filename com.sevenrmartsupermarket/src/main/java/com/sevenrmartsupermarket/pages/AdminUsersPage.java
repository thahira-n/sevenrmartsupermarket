package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sevenrmartsupermarket.utilities.PageUtility;

public class AdminUsersPage {
	WebDriver driver;
	LoginPage loginpage=new LoginPage(driver);
	DashBoardPage dashboardpage;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']")
	private WebElement adminUsersTable;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")
	private WebElement newButton;
	@FindBy(xpath="//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath="//input[@name='password']")
	private WebElement passWordField;
	@FindBy(xpath="//select [@id='user_type']")
	private WebElement typeField;
	@FindBy(xpath="//button[@name='Create']")
	private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement successfulUserCreationAlert;
	@FindBy(xpath="//a[contains(text(),' Search')]")
	private WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")
	private WebElement searchUsername;
	@FindBy(xpath="//select[@id='ut']")
	private WebElement searchUserType;
	@FindBy(xpath="//button[@name='Search']")
	private WebElement searchUserSearch;
	public AdminUsersPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	public boolean adminUsersTableDisplayed() {
		return adminUsersTable.isDisplayed();
	}
	
	public String create_NewUser(String userName,String passWord,String type) {
		PageUtility pageutility=new PageUtility(driver);
		Select select=new Select(typeField);
		dashboardpage=new DashBoardPage(driver);
		
		newButton.click();
		userNameField.click();
		userNameField.sendKeys(userName);
		passWordField.sendKeys(passWord);
		pageutility.selectByVisibleText(typeField,type);
		saveButton.click();
		return successfulUserCreationAlert.getText();
	
	}
	
	public void search_User(String userName,String type) {
		PageUtility pageutility=new PageUtility(driver);
		Select select=new Select(searchUserType);
		searchButton.click();
		searchUsername.sendKeys(userName);
		pageutility.selectByVisibleText(searchUserType,type);
		searchUserSearch.click();
		
	}

}
