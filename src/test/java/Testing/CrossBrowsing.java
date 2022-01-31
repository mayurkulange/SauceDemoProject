package Testing;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CrossBrowsing {
	RemoteWebDriver driver;
	@Parameters("browser-Name")
	@BeforeMethod
	public void browser(String browserName) {
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {
			WebDriverManager.iedriver().setup();
			driver = new EdgeDriver();
		}
		else{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	@Test
	public void OpenSite() {
		driver.get("https://www.facebook.com");
	}
	@AfterMethod
	public void close() throws Exception {
		Thread.sleep(2000);
		driver.close();
	}
}
