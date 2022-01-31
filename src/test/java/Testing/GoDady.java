package Testing;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoDady {
	ChromeDriver driver;
	@BeforeMethod
	public void Case1() {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		//driver.manage().window().setSize(new Dimension(600, 1000));
		driver.manage().window().setPosition(new Point(700, 300));
		//driver.manage().window().maximize();
		driver.get(" https://www.godaddy.com/");
		
	}
	@Test
	public void case2() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		String title = driver.getTitle();
		Assert.assertEquals(driver.getTitle(), title);
	}
	
	@AfterMethod
	public void CloseBrowser() {
		driver.close();
		
	}
}
