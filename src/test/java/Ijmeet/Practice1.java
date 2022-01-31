package Ijmeet;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(value = ListenerDemo.class)
public class Practice1 {
	@Test
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.cssSelector(".inputtext")).sendKeys("skanv ahwnv");
	}
}
