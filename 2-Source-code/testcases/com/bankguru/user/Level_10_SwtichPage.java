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
import PageObject.DeposittPageObject;
import PageObject.EditCustomerPageObject;
import PageObject.FundTransferPageObject;
import PageObject.LoginPageObject;
import PageObject.MainPageObject;
import PageObject.NewCustomerPageObject;
import PageObject.RegisterPageObject;
import commons.AbstractTest;
import commons.PageGeneratoManager;

public class Level_10_SwtichPage extends AbstractTest {

	WebDriver driver;
	String loginPageUrl, userID, password;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	MainPageObject mainPage;
	NewCustomerPageObject newCustomerPage;
	DriverManager driverManager;
	DeposittPageObject depositPage;
	
	EditCustomerPageObject editCustomerPage;
	FundTransferPageObject FundTrasferPage;

	@Parameters ("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		System.out.println("Browser Name =: " +browserName);
		driverManager = DriverManagerFactory.getBrowserDriver(browserName);
		driver = driverManager.getDriver();
//		driver = getBrowserDriver(browserName);
//		loginPage = new LoginPageObject(driver);
		loginPage =PageGeneratoManager.getLoginPage(driver);
//		mainPage = new MainPageObject(driver);
//		newCustomerPage = new NewCustomerPageObject(driver);

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
		registerPage = loginPage.clickToHereLink();	  
		
		
//		  registerPage.inputToEmailTextBox("vandang916@gamil.com");
//		  registerPage.clickToSubmitButton();
//		  userID = registerPage.getUserIDText();
//		  password = registerPage.getPasswordText();
	}

	@Test
	public void TC_02_Login_Page() {
//		registerPage = new RegisterPageObject(driver);
		System.out.println("TC_02_Login_Page");
		loginPage = registerPage.openLoginPage(loginPageUrl);
		loginPage.inputToUserIDTextbox("mngr485930");
		loginPage.inputPassworkTextbox("tYpydYh");
		mainPage=loginPage.clickToLoginButton();
		Assert.assertEquals(mainPage.getWelcomeMessageText(), "Welcome To Manager's Page of Guru99 Bank");

	}

	@Test
	public void TC_03_New_Customer() {
		newCustomerPage = mainPage.openNewCustomerPage(driver);
//		Switch page
//	  newCustomerPage.clickToSubmitButton();
//	  Assert.assertEquals(newCustomerPage.getSuccessMessage(), "Customer Register Successfully!!!");
//		New customer -> Deposit
		depositPage = newCustomerPage.openDepositPage(driver);
//		Deposit -> Edit customer
		editCustomerPage = depositPage.openEditCustomerPage(driver);
//		Edit customer -> Fund transfer
		FundTrasferPage=editCustomerPage.openFundTrasferPage(driver);
		
//		fund -> logout
	}

	@Test
	public void TC_04_Logout() {
		System.out.println("TC_04_Logout");
		loginPage= FundTrasferPage.clickToLogoutLink(driver);
		Assert.assertTrue(loginPage.isLoginFormDisplay());

	}

	public int randomNumber() {
		Random random = new Random();
		return random.nextInt(999);
	}
}
