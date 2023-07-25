package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.JQuery.HomePageObject;
import pageObjects.JQuery.PageGeneratorManager;

public class Level_12_DataTable extends AbstractTest {

	WebDriver driver;
	HomePageObject homePage;
	@Parameters ({"browser","url"})
	@BeforeClass
	public void beforeClass(String browser,String appUrl) {
		System.out.println("Browser Name =: " +browser);
		driver = getBrowserDriver(browser,appUrl);
		homePage = PageGeneratorManager.getHomePage(driver);
		

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	@Test
	public void TC_01_InputData() {
//		Input to text
		homePage.inputToTextboxByColumnName("Country","Singapor");
		homePage.inputToTextboxByColumnName("Females","38995");
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		homePage.sleepInSecond(10);



	}	
	public void TC_02_Navigate() {
//		Navigate to any space
		homePage.refreshCurrentPage(driver);
		homePage.navigateToPageByPageNumber("5");
//		Verify page navigate success
		Assert.assertTrue(homePage.isPageActiveByPageNumber("5"));
		homePage.sleepInSecond(10);
	}
//	@Test
	public void TC_03_Delete() {
		// delete
		homePage.sleepInSecond(2);
		homePage.clickToDeleteByCountryName("Afghanistan");
		homePage.sleepInSecond(10);
		homePage.refreshCurrentPage(driver);
//		homePage.clickToEditByCountryName("Singapor");
//		homePage.refreshCurrentPage(driver);
		
		
	}
//	@Test
	public void TC_04_Dispaly() {
				Assert.assertTrue(homePage.isAllInforDisplay("","","",""));
		
	}

//	@Test
	public void TC_05_Index() {
		homePage.openUrl(driver, "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/");
				homePage.inputToTextboxByColumnNameAtRowname("Contact Person","2","vandang");
				homePage.sleepInSecond(10);
		
	}

}
