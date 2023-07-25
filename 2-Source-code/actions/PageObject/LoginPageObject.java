package PageObject;

import org.openqa.selenium.WebDriver;

import PageUI.BankGuru.LoginPageUI;
import commons.AbstractPage;
import commons.PageGeneratoManager;

public class LoginPageObject extends AbstractPage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		System.out.println("Login PageObject:----  "+driver.toString()+"----");
	}
//	Constructor 
//	1: goi dau tien khi class ddc khoi tao
//	2: ham khoi tao khong co kieu tra ve
//	3: ham khopi tao  cung ten class
//	4: 1 class co the co nhieu ham khoi tao, khac nhau tham so hoac kieu du lieu
	
//	MUC DICH: Tinh sa hinh
	public String getLoginPageUrl() {
		// TODO Auto-generated method stub
		return getCurrentPageUrl(driver);
	}

	public RegisterPageObject clickToHereLink() {
		// TODO Auto-generated method stub
		System.out.println("done");
		waitToElementClickable(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
		return PageGeneratoManager.getRegisterPage(driver);
	}

	public void inputToUserIDTextbox(String userID) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.USER_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_TEXTBOX, userID);
		
	}

	public void inputPassworkTextbox(String password) {
		// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
		
	}

	public MainPageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		// TODO Auto-generated method stub
		return PageGeneratoManager.getMainPage(driver);
		
	}

	public boolean isLoginFormDisplay() {
		
	// TODO Auto-generated method stub
		waitToElementVisible(driver, LoginPageUI.LOGIN_FORM);
		
		return isControlDisplay(driver, LoginPageUI.LOGIN_FORM);
	}


	}
