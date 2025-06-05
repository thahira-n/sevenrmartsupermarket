package com.sevenrmartsupermarket.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class CaptureScreenShots {
	TakesScreenshot takesscreenshot;// interface to capture screenshots

	public void takeScreenShot(WebDriver driver, String imageName) {
		try {
			takesscreenshot = (TakesScreenshot) driver;
			File screenShot = takesscreenshot.getScreenshotAs(OutputType.FILE);
			String timeStamp = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss").format(new Date());
			String path = Constants.SCREENSHOT_FILEPATH + imageName + "_" + timeStamp + ".png";// location to move the
																								// screenshot.png
			File destination = new File(path);
			FileHandler.copy(screenShot, destination);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
