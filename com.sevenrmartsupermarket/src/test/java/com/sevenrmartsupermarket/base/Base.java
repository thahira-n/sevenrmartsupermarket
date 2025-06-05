package com.sevenrmartsupermarket.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.CaptureScreenShots;
import org.testng.annotations.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base {
	public WebDriver driver;
	Properties properties = new Properties();
	CaptureScreenShots capturescreenshots=new CaptureScreenShots();

	public Base() {
		try {
			FileInputStream fi = new FileInputStream(Constants.CONFIG_FILEPATH);
			properties.load(fi);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** initializing Browser **/
	public void initialize(String browser, String url) {
		if (browser.contains("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.contains("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browser.contains("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
	}
	@Parameters("browser")

	@BeforeMethod(enabled=false)
	public void launchBrowser(String browser) {
		String url = properties.getProperty("url");
		
		initialize(browser, url);
	}
	@BeforeMethod(enabled=true,alwaysRun = true)
	public void launchBrowser() {
		String url = properties.getProperty("url");
		String browser = properties.getProperty("browser");
		initialize(browser, url);
	}
	@AfterMethod(alwaysRun = true)
	public void terminateBrowser(ITestResult itestresult) {//interface to get the results of test case execution.also is a listener
		if(itestresult.getStatus()==ITestResult.FAILURE)
		{
			capturescreenshots.takeScreenShot(driver, itestresult.getName());//
		}
		
	}
}




