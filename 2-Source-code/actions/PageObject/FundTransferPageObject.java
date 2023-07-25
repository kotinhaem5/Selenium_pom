package PageObject;

import org.openqa.selenium.WebDriver;

import PageUI.BankGuru.FundTransferPageUI;
import PageUI.BankGuru.NewCustomerPageUI;
import commons.AbstractPage;
import commons.PageGeneratoManager;

public class FundTransferPageObject extends AbstractPage {
	WebDriver driver;
	public FundTransferPageObject(WebDriver driver) {
		this.driver =driver;
	}
	public LoginPageObject clickToLogoutLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, FundTransferPageUI.LOGOUT_LINK);
		clickToElement(driver, FundTransferPageUI.LOGOUT_LINK);
		waitToAlertPresence(driver);
		acceptAlert(driver);
//		return new LoginPageObject(driver);
		return PageGeneratoManager.getLoginPage(driver);	
		}	

}
