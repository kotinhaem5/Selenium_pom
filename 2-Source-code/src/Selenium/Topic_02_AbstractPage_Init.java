package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class Topic_02_AbstractPage_Init extends AbstractPage {
	WebDriver driver;
	AbstractPage abstractPage;
	

//			WebDriver x = new ChromeDriver();

	@Test
	public void TC_01() {
		 
		openUrl(driver, "https://www.youtube.com/");
	  abstractPage.openUrl(driver, "https://www.youtube.com/");
	  String title = abstractPage.getCurrentPageUrl(driver);
	  System.out.println(title);
	  final String dir = System.getProperty("user.dir");
	  System.out.println("current dir = " + dir);
//	  Assert.assertEquals(title, "YouTube");
		

	}

	@BeforeClass
	public void beforeClass() {
		
		System.setProperty("webdriver.chrome.driver", ".\\BrowserDriver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
