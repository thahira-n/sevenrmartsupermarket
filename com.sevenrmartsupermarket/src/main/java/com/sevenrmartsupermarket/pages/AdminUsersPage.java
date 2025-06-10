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
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]")
	private WebElement searchedUserNameDisplayField;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//i[@class='fas fa-edit']")
	private WebElement updateUserButton;
	@FindBy(xpath="//input[@id='username']")
	private WebElement updateUserNameField; 
	@FindBy(xpath="//input[@type='password']")
	private WebElement updatePassWordField;
	@FindBy(xpath="//select[@id='user_type']")
	private WebElement updateUserTypeField;
	@FindBy(xpath="//button[@name='Update']")
	private WebElement updateSubmitButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement updateAlertBox;
	@FindBy(xpath="//table[contains(@class, 'table')]//tr[td[1]]//a[contains(@class, 'btn-danger')]")
	private WebElement deletebButtonOfDeclan;
	
	
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
	
	public String search_User(String userName,String type) {
		PageUtility pageutility=new PageUtility(driver);
		Select select=new Select(searchUserType);
		searchButton.click();
		searchUsername.sendKeys(userName);
		pageutility.selectByVisibleText(searchUserType,type);
		searchUserSearch.click();
		return searchedUserNameDisplayField.getText();
		
	}
	
	public String update_User(String updatedUserName,String updatedPassWord,String updatedType) {
		PageUtility pageutility=new PageUtility(driver);
		Select select=new Select(updateUserTypeField);
		updateUserButton.click();
		updateUserNameField.clear();
		updateUserNameField.sendKeys(updatedUserName);
		updatePassWordField.clear();
		updatePassWordField.sendKeys(updatedPassWord);
		pageutility.selectByVisibleText(updateUserTypeField,updatedType );
		updateSubmitButton.click();
		return updateAlertBox.getText();
	}
	
	public void delete_User() {
		PageUtility pageutility=new PageUtility(driver);
		
		pageutility.alerts(deletebButtonOfDeclan);
		
	}
		
		
		
		
		
		
	

}
