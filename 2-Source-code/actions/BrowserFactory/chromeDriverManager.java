package BrowserFactory;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chromeDriverManager extends DriverManager{
	
	@Override
	void createDriver() {
		// TODO Auto-generated method stub
//		System.setProperty("webdriver.chrome.driver", ".\\BrowserDriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

}
