package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageContactPage {

	WebDriver driver;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']")
	public WebElement contactDetailsTable;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[6]//a[@role='button']")
	public WebElement contactDetailsEditingButton;

	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public boolean contactDetailsTableDisplayed() {
		return contactDetailsTable.isDisplayed();
	}

	public void clickOnContactDetailsEditButton() {
		contactDetailsEditingButton.click();

	}

}
