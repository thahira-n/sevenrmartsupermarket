package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactUsEditPage {
	
	WebDriver driver;
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement contactNumberEditfield;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement contactDetailsSubmitButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")
	private WebElement contactDetailsUpdateAlert;
	
	public ContactUsEditPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void contactNumberEditing() {
		contactNumberEditfield.clear();
		contactNumberEditfield.sendKeys("1234567890");
		contactDetailsSubmitButton.click();
		
	}
	
	public String get_textOfContactUpdationAlert()
	{
		return contactDetailsUpdateAlert.getText();
	}

}
