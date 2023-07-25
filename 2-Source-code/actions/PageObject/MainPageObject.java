package PageObject;

import org.openqa.selenium.WebDriver;

import PageUI.BankGuru.MainPageUI;
import commons.AbstractPage;
import commons.PageGeneratoManager;

public class MainPageObject extends AbstractPage {
	WebDriver driver;
	public MainPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		System.out.println("Main PageObject:----  "+driver.toString()+"----");
		}
	
	public String getWelcomeMessageText() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, MainPageUI.STRING_WELCOME);
		return getElementText(driver, MainPageUI.STRING_WELCOME);
	}
	
	public NewCustomerPageObject openNewCustomerPage() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, MainPageUI.NEW_CUSTOMER_LINK);
		clickToElement(driver, MainPageUI.NEW_CUSTOMER_LINK);
		return PageGeneratoManager.getNewCustomerPage(driver);
		
	}

}
