package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import PageUI.BankGuru.RegisterPageUI;
import commons.AbstractPage;
import commons.PageGeneratoManager;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void inputToEmailTextBox(String emailValue) {
		// TODO Auto-generated method stub
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		waitToElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailValue);
		
		
	}

	public void clickToSubmitButton() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
		
	}

	public String getUserIDText() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.USER_ID_TEXT);
		return getElementText(driver, RegisterPageUI.USER_ID_TEXT);
	}

	public String getPasswordText() {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, RegisterPageUI.PASSWORD_ID_TEXT);
		return getElementText(driver, RegisterPageUI.PASSWORD_ID_TEXT);

	}

	public LoginPageObject openLoginPage(String loginPageUrl) {
		// TODO Auto-generated method stub
		openUrl(driver, loginPageUrl);
		return PageGeneratoManager.getLoginPage(driver);
		
	}



}
