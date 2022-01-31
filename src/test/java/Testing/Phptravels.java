package Testing;

import java.util.List;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Phptravels {
	ChromeDriver d;

	@BeforeClass
	public void LoginPage() {
		WebDriverManager.chromedriver().setup();
		d = new ChromeDriver();
		d.manage().window().maximize();
		d.get("https://www.phptravels.net/login");
		d.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("user@phptravels.com");
		d.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("demouser");
		d.findElement(
				By.xpath("//button[@class='btn btn-default btn-lg btn-block effect ladda-button waves-effect']"))
				.click();
		WebDriverWait w = new WebDriverWait(d, Duration.ofSeconds(10));
		w.withTimeout(Duration.ofSeconds(10));
	}

	@Test
	public void Dashboard() {
		d.findElement(By
				.xpath("//li[@class='page-active']/child::a[@href='https://www.phptravels.net/account/dashboard']"))
				.click();
		d.findElement(By.xpath("//div[@class='info-icon icon-element flex-shrink-0']")).click();
		d.findElement(By.xpath("//div[@class='info-icon icon-element bg-2 flex-shrink-0']")).click();
		d.findElement(By.xpath("//div[@class='info-icon icon-element bg-3 flex-shrink-0']")).click();
		d.findElement(By.xpath("//div[@class='info-icon icon-element bg-4 flex-shrink-0']")).click();

		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/account/bookings' and @class=' waves-effect']"))
				.click();

		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/account/add_funds' and @class=' waves-effect']"))
				.click();

		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/account/profile' and @class=' waves-effect']"))
				.click();
	}

	@Test
	public void Home() {
		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/' and @title='home']")).click();
	}

	@Test
	public void Hotels() throws InterruptedException {
		d.findElement(By.linkText("Hotels")).click();
		d.findElement(By.xpath("//span[@aria-labelledby='select2-hotels_city-container']")).click();
		d.findElement(By.xpath("//input[@role='searchbox']")).sendKeys("Del");
		List<WebElement> l = d.findElements(By.xpath("//ul[@role='listbox']"));
		for (int i = 0; i < l.size(); i++) {
			System.out.println(l.get(i).getText());
			if (l.get(i).getText().contains("Delhi,India")) {
				l.get(i).click();
				break;
			}
		}
		Thread.sleep(5000);

		d.findElement(By.xpath("//input[@id='checkin']")).click();
		String monthYear = d.findElement(By.xpath("//th[contains(text(),'December 2021')]")).getText();
		String month = monthYear.split(" ")[0].trim();
		String year = monthYear.split(" ")[1].trim();

		while (!(month.equals("January") && year.equals("2022"))) {
			d.findElement(By.xpath("//i[@class='icon mdi mdi-long-arrow-right']")).click();
			monthYear = d.findElement(By.xpath("//th[contains(text(),'December 2021')]")).getText();
			month = monthYear.split(" ")[0].trim();
			year = monthYear.split(" ")[1].trim();
		}
		d.findElement(By.xpath("//td[text()='23']")).click();
	}

	@Test
	public void Flight() {
		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/flights' and @title='home']")).click();
	}

	@Test
	public void Tours() {
		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/tours' and @title='home']")).click();
	}

	@Test
	public void Cars() {
		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/cars' and @title='home']")).click();
	}

	@Test
	public void Visa() {
		d.findElement(By.xpath("//a[@href='https://www.phptravels.net/visa' and @title='home']")).click();
	}

	@Test
	public void Blog() {
		d.findElement(By.linkText("Blog")).click();
	}

	@AfterClass
	public void CloseBrowser() {
		d.close();
	}

}
