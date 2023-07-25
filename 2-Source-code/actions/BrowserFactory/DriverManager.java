package BrowserFactory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	WebDriver driver;
	abstract void createDriver();
	
	public void quitDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	public WebDriver getDriver() {
		if (driver == null) {
			createDriver();
		}
		driver.get("https://demo.guru99.com/v4");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}
	
}
