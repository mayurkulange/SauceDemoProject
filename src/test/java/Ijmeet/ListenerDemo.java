package Ijmeet;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Screenshots.ScreenshotDemo;
public class ListenerDemo implements ITestListener {
static WebDriver driver;
	@Override
	public void onTestFailure(ITestResult result){
		
		try {
			ScreenshotDemo.captureScreenshot(driver, "Ijmeet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Your test is failed.");
		ITestListener.super.onTestFailure(result);
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Your test is skipped.");
		try {
			ScreenshotDemo.captureScreenshot(driver, "Ijmeet");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ITestListener.super.onTestSkipped(result);
	}
	@Override
		public void onTestSuccess(ITestResult result) {
		System.out.println("Test run successfully");
			ITestListener.super.onTestSuccess(result);
		}
}
