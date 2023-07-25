package BrowserFactory;

public class DriverManagerFactory {
	enum BrowserNAME {
		CHROME,FIREFOX;
	}
	public static DriverManager getBrowserDriver(String browserName) {
		DriverManager driverManager;
		BrowserNAME browser = BrowserNAME.valueOf(browserName.toUpperCase());
		switch (browser) {
		case CHROME:
			driverManager = new chromeDriverManager();
			break;
//		case FIREFOX:
//			driverManager = new firefoxDriverManager();
		default:
			throw new RuntimeException("Please choose browser name");
			
		}
		return driverManager;
	}
}
