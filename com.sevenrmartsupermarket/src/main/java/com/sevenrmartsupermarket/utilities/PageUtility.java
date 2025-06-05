package com.sevenrmartsupermarket.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	WebDriver driver;
	Actions actions;
	JavascriptExecutor js;
	
	public PageUtility(WebDriver driver) {
		this.driver=driver;
		js= (JavascriptExecutor) driver;
		actions=new Actions(driver);
		
	}
	
	public void scrollAndClick(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView();", element);
		js.executeScript("arguments[0].click();",element);
	}
	
	public void selectByVisibleText(WebElement element,String text)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
		
	}
	
	public void enterByMouse(WebElement element,String text) {
		actions=new Actions(driver);
		actions.sendKeys(element,text).build().perform();
	}
	
	public void mouseHovering(WebElement element) {
		actions=new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public void rightClickAWebElement(WebElement element) {
		actions=new Actions(driver);
		actions.contextClick(element).build().perform();
	}
	
	public void doubleClickAWebElement(WebElement element) {
		actions=new Actions(driver);
		actions.doubleClick(element).build().perform();
	}
	
	

}
