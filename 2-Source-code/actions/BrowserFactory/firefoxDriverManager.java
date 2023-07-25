package BrowserFactory;

import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class firefoxDriverManager extends DriverManager{

	@Override
	void createDriver() {
		// TODO Auto-generated method stub
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

}
