package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_01_CheckEnviroment {
	WebDriver driver;
	

//			WebDriver x = new ChromeDriver();

	@Test
	public void TC_01() {
	  driver.get("https://www.youtube.com/");
	  String title = driver.getTitle();
	  System.out.println(title);
	  final String dir = System.getProperty("user.dir");
	  System.out.println("current dir = " + dir);
//	  Assert.assertEquals(title, "YouTube");
		

	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", ".\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
