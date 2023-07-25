package pageObjects.JQuery;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIJQuery.HomePageUI;

public class HomePageObject extends AbstractPage{
WebDriver driver;

public HomePageObject(WebDriver driver) {
	this.driver = driver;
}

public void inputToTextboxByColumnName(String columnName, String Value) {
	// TODO Auto-generated method stub
	waitToElementVisible(driver, HomePageUI.DYNAMIC_TEXT_BY_COLUMN_NAME, columnName);
	sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXT_BY_COLUMN_NAME, Value, columnName);
	
}

public void navigateToPageByPageNumber(String PageNumber) {
	// TODO Auto-generated method stub
	waitToElementClickable(driver, HomePageUI.DYNAMIC_PAGE_BY_PAGE_NUMBER, PageNumber);
	clickToElement(driver, HomePageUI.DYNAMIC_PAGE_BY_PAGE_NUMBER, PageNumber);
	
}

public boolean isPageActiveByPageNumber(String pageNumber) {
	waitToElementVisible(driver, HomePageUI.DYNAMIC_PAGE_ACTIVE_BY_PAGE_NUMBER, pageNumber);
	// TODO Auto-generated method stub
	return isControlDisplay(driver,HomePageUI.DYNAMIC_PAGE_ACTIVE_BY_PAGE_NUMBER, pageNumber);
}

public void clickToDeleteByCountryName(String countryName) {
	// TODO Auto-generated method stub
	waitToElementClickable(driver, HomePageUI.DYNAMIC_DELETE_ICON_BY_COUNTRY_NAME, countryName);
	clickToElement(driver, HomePageUI.DYNAMIC_DELETE_ICON_BY_COUNTRY_NAME, countryName);
}

public boolean isAllInforDisplay(String female, String country, String male, String total) {
	waitToElementVisible(driver, HomePageUI.DYNAMIC_PAGE_ACTIVE_BY_PAGE_NUMBER, female, country,male,total);
	// TODO Auto-generated method stub
	return isControlDisplay(driver,HomePageUI.DYNAMIC_PAGE_ACTIVE_BY_PAGE_NUMBER, female, country,male,total);
	// TODO Auto-generated method stub

}

public void clickToEditByCountryName(String countryName) {
	// TODO Auto-generated method stub
	
	waitToElementClickable(driver, HomePageUI.DYNAMIC_EDIT_ICON_BY_COUNTRY_NAME, countryName);
	clickToElement(driver, HomePageUI.DYNAMIC_EDIT_ICON_BY_COUNTRY_NAME, countryName);
}

public void inputToTextboxByColumnNameAtRowname(String columnName, String rowNumber, String value) {
	
	waitToElementVisible(driver, HomePageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName);
	String columnIndex =String.valueOf(countElementSize(driver, HomePageUI.DYNAMIC_INDEX_BY_COLUMN_NAME, columnName) + 1);
	waitToElementVisible(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_INDEX, rowNumber,columnIndex);
	sendKeyToElement(driver, HomePageUI.DYNAMIC_TEXTBOX_BY_COLUMN_INDEX, value, rowNumber,columnIndex);
}

}
