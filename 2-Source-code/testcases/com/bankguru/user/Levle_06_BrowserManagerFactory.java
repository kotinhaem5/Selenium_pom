package com.bankguru.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserFactory.DriverManager;
import BrowserFactory.DriverManagerFactory;
import PageObject.LoginPageObject;
import PageObject.MainPageObject;
import PageObject.NewCustomerPageObject;
import PageObject.RegisterPageObject;
import commons.AbstractTest;

public class Levle_06_BrowserManagerFactory extends AbstractTest {

	WebDriver driver;
	String loginPageUrl, userID, password;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPage;
	DriverManager driverManager;

	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser Name =: " +browserName);
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
//		driver = getBrowserDriver(browserName);
		loginPage = new LoginPageObject(driver);
		mainPage = new MainPageObject(driver);
		newCustomerPage = new NewCustomerPageObject(driver);

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_Register_To_System() {

		System.out.println("TC_01_Register_To_System");
		loginPageUrl = loginPage.getLoginPageUrl();
		System.out.println(loginPageUrl);
//	  loginPage.clickToHereLink();	  
//	  registerPage.inputToEmailTextBox("vandang916@gamil.com");
//	  registerPage.clickToSubmitButton();
//	  userID = registerPage.getUserIDText();
//	  password = registerPage.getPasswordText();
	}

	@Test
	public void TC_02_Login_Page() {
		registerPage = new RegisterPageObject(driver);
		System.out.println("TC_02_Login_Page");
		registerPage.openLoginPage(loginPageUrl);
		loginPage.inputToUserIDTextbox("mngr480374");
		loginPage.inputPassworkTextbox("vupetud");
		loginPage.clickToLoginButton();
		Assert.assertEquals(mainPage.getWelcomeMessageText(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_03_New_Customer() {
		System.out.println("TC_03_New_Customer");
		mainPage.openNewCustomerPage();
		newCustomerPage.inputToNameTextbox("van dang");

		System.out.println("input date of birth");
		newCustomerPage.inputToDateOfBirthTextbox("01/02/1996");
		newCustomerPage.inputToAddessTextbox("La galaxy");
		newCustomerPage.inputToCityTextbox("califonia");
		newCustomerPage.inputToStateTextbox("NA");
		newCustomerPage.inputToPinTextbox("123455");
		newCustomerPage.inputToPhoneTextbox("0985222" + randomNumber());
		newCustomerPage.inputToEmailTextbox("dang22" + randomNumber() + "@gmail.com");
		newCustomerPage.inputToPasswordTextbox("134");

//	  newCustomerPage.clickToSubmitButton();
//	  Assert.assertEquals(newCustomerPage.getSuccessMessage(), "Customer Register Successfully!!!");
	}

	@Test
	public void TC_04_Logout() {
		System.out.println("TC_04_Logout");
		newCustomerPage.clickToLogoutLink();
		Assert.assertTrue(loginPage.isLoginFormDisplay());

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999);
	}
}
