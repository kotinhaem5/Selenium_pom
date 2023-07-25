package PageObject;

import org.openqa.selenium.WebDriver;

import PageUI.BankGuru.EditCustomerPageUI;
import PageUI.BankGuru.NewCustomerPageUI;
import commons.AbstractPage;
import commons.PageGeneratoManager;

public class DeposittPageObject extends AbstractPage {

	WebDriver driver;

	public DeposittPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EditCustomerPageObject openEditCustomerPage() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, EditCustomerPageUI.EDIT_CUSTOMER_LINK);
		clickToElement(driver, EditCustomerPageUI.EDIT_CUSTOMER_LINK);
		return PageGeneratoManager.getEditCustomerPage(driver);
	}

}
