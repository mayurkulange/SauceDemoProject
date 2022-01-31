package Ijmeet;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignIn {
	RemoteWebDriver driver;

	@BeforeSuite
	public void OpenBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.ijmeet.com");
		driver.manage().window().maximize();

	}

	@BeforeMethod
	public void signIn() {
		driver.findElement(By.xpath("//a[contains(text(),'Sign In')]")).click();
		driver.findElement(By.id("email")).sendKeys("mak@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Mak@12345");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}

	@Test
	public void joinMeeting() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//div[@id=\"j_meeting_tab\"]")).click();
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Larkspur21A");
		driver.findElement(By.xpath("//input[@id=\"meetingid\"]")).sendKeys("43164165413");
		driver.findElement(By.xpath("//button[@id=\"before_start\"]")).click();
		Thread.sleep(2000);
		// WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		// w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@class=\"bootbox-close-button
		// close\"]"))));
		driver.findElement(By.xpath("//button[@class=\"bootbox-close-button close\"]")).click();

		// Join Personal meeting
		driver.findElement(By.xpath("//a[@id=\"pills-personal-meeting-tab\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"username_p\"]")).sendKeys("LarkspurManual");
		driver.findElement(By.xpath("//input[@name=\"meeting_id_p\"]")).sendKeys("156415633413");
		driver.findElement(By.xpath("//a[@class=\"btn submit_from11\"]")).click();
		Thread.sleep(1500);
		driver.findElement(By.xpath("//button[@class=\"bootbox-close-button close\"]")).click();
	}
	@Test
	public void myMeeting() throws InterruptedException {
		driver.findElement(By.xpath("//div[@id=\"My_Meetingsapps_tab\"]")).click();
		driver.findElement(By.xpath("//input[@placeholder=\" Enter search value \"]")).sendKeys("31354353");
		driver.findElement(By.xpath("//input[@id=\"upcoming_meeting_start_date\"]")).click();
		Thread.sleep(1500);
		WebElement m =driver.findElement(By.xpath("//select[@class=\"monthselect\"]"));
		Select month =new Select(m);
		month.selectByValue("4");
		
		Thread.sleep(1500);
		WebElement y =driver.findElement(By.xpath("//select[@class=\"yearselect\"]"));
		Select year =new Select(y);
		year.selectByValue("2023");
		driver.findElement(By.xpath("//td[contains(text(),'27')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name=\"upcoming_meeting_end_date\"]")).click();
		WebElement mo =driver.findElement(By.xpath("//body[1]/div[5]/div[2]/div[1]/table[1]/thead[1]/tr[1]/th[2]/select[1]"));
		Select mon = new Select(mo);
		mon.selectByValue("5");
		WebElement ye =driver.findElement(By.xpath("/html/body/div[5]/div[2]/div[1]/table/thead/tr[1]/th[2]/select[2]"));
		Select yea = new Select(ye);
		yea.selectByVisibleText("2025");
		driver.findElement(By.xpath("//td[contains(text(),'27')]")).click();
		driver.findElement(By.xpath("//a[@class=\"btn btn-default mbtn search_value_past_meeting\"]")).click();
		
		driver.findElement(By.xpath("//button[@onclick=\"openMeetings(event, 'Previous')\"]")).click();
	}
}
