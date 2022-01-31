package DataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwagLab {
	RemoteWebDriver driver;
	@Test(dataProvider = "login" ,dataProviderClass = SwagData.class)
	public void loginPage(String username , String password) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@placeholder=\"Username\"]")).sendKeys(username);
		driver.findElement(By.xpath("//input[@placeholder=\"Password\"]")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();
	}
	@AfterMethod
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
	}
}
