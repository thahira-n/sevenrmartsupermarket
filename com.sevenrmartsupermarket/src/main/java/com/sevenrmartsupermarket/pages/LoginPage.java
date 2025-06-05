package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class LoginPage {
	WebDriver driver;
	Properties properties = new Properties();
	@FindBy(xpath = "//input[@name='username']")
	private WebElement userNameField;
	@FindBy(xpath = "//input[@name='password']")
	private WebElement passWordField;
	@FindBy(xpath = "//button[contains(text(),'Sign In')]")
	private WebElement signInButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement alertBox;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILEPATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void enterUserName(String userName) {
		userNameField.sendKeys(userName);
	}

	public void enterPassWord(String passWord) {
		passWordField.sendKeys(passWord);
	}

	public void clickOnSignIn() {
		WaitUtility waitutility = new WaitUtility(driver);
		waitutility.elementtoBeClickable(signInButton, 60);

		signInButton.click();
	}

	public void login(String userName, String passWord) {
		enterUserName(userName);
		enterPassWord(passWord);
		clickOnSignIn();
	}

	public void login() {// reads from config
		String userName = properties.getProperty("username");
		String passWord = properties.getProperty("password");
		enterUserName(userName);
		enterPassWord(passWord);
		clickOnSignIn();

	}
	
	public boolean isAlertBoxPresent() {
		return alertBox.isDisplayed();
		 
		 
	}
	
	public String get_TextOfAlertOfInvalidUserNameOrPassword() {
		 String alertText=alertBox.getText();
		 return alertText;
		
	}

}
