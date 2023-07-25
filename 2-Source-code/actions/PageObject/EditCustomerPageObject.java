package PageObject;

import org.openqa.selenium.WebDriver;

import PageUI.BankGuru.FundTransferPageUI;
import commons.AbstractPage;
import commons.PageGeneratoManager;

public class EditCustomerPageObject extends AbstractPage {
	WebDriver driver;
	public EditCustomerPageObject(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	public FundTransferPageObject openFundTrasferPage() {
		waitToElementClickable(driver, FundTransferPageUI.FUND_TRANSFER_LINK);
		clickToElement(driver, FundTransferPageUI.FUND_TRANSFER_LINK);
		// TODO Auto-generated method stub
		return PageGeneratoManager.getFundTransferPage(driver);
	}

}
