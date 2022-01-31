package Ijmeet;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ijmeet {
	RemoteWebDriver driver;
	@BeforeMethod
	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://www.ijmeet.com");
		driver.manage().window().maximize();

	}
	@Test
	public void JoinMeeting() {
		driver.findElement(By.xpath("//*[@id=\"navbarContent\"]/ul/li[1]/a")).click();
		driver.findElement(By.id("username")).sendKeys("51463");
		driver.findElement(By.xpath("//input[@placeholder=\"Enter Meeting Id\"]")).sendKeys("-152");
		driver.findElement(By.id("before_start")).click();
	}

	@Test
	public void SignUp() {
		
		driver.findElement(By.xpath("//*[@id=\"navbarContent\"]/ul/li[5]/a")).click();
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys("Mayur");
		driver.findElement(By.id("company_name")).sendKeys("Resonantia");
		driver.findElement(By.name("email")).sendKeys("mayurkulange@gmail.com");
		driver.findElement(By.xpath("//input[@id=\"contact\"]")).sendKeys("8605674997");
		driver.findElement(By.id("password")).sendKeys("Mayur1234");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		// sign in with google
		driver.findElement(By.xpath("//a[@class=\"social-login-button social-login-button-google\"]")).click();
		driver.navigate().back();
		// sign in with facebook
		driver.findElement(By.xpath("//a[@class=\"social-login-button social-login-button-facebook\"]")).click();
		driver.navigate().back();
		// sign in with federation
		driver.findElement(By.xpath("//a[@class=\"social-login-button social-login-button-sso\"]")).click();
		driver.navigate().back();

		driver.findElement(By.xpath("//span[contains(text(),'Log in')]")).click();// to click on Log In
	}

	@Test
	public void ContactSales() {
		
		driver.findElement(By.linkText("Contact sales")).click();
		driver.findElement(By.xpath("//input[@placeholder=\"Enter your name \"]")).sendKeys("16316");
		driver.findElement(By.xpath("//input[@name=\"user_email\"]")).sendKeys("16@316.com");
		driver.findElement(By.xpath("//textarea[@name=\"user_message\"]")).sendKeys("Please enter valid details");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
