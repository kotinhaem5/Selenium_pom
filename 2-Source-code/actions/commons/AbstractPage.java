package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObject.DeposittPageObject;
import PageObject.EditCustomerPageObject;
import PageObject.FundTransferPageObject;
import PageObject.LoginPageObject;
import PageObject.NewCustomerPageObject;
import PageUI.BankGuru.AbstractPageUI;

public abstract class AbstractPage {
	
	private WebDriverWait explicitWait;
	private Alert alert;
	private Select select;
	private JavascriptExecutor jsExecutor;
	private Actions action;
	private WebElement element;
	private long timeout = 30;
	// AbstractPage : selenium api Wrapper < bao boc >cho pageobject
	// AbstractTest : ham dung ching cho test case
	// Constants: thong tin dung chung cho toan bo system
	public void openUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();

	}

	public void waitToAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.accept();
		// tuong tac voi alert
	}

	public void cancelAlert(WebDriver driver) {
		alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextinAlert(WebDriver driver, String text) {
		alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWin = driver.getTitle();
			if (currentWin.equals(title)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

//	Element
	public By byXpath(String locator) {
		return By.xpath(locator);
	}

	public WebElement find(WebDriver driver, String location) {
		return driver.findElement(byXpath(location));
	}
//
//	list element
	private List<WebElement> finds(WebDriver driver, String location) {
		return driver.findElements(byXpath(location));
	}
	public String castRestParameter(String locator, String... value) {
		locator = String.format(locator, (Object[])value);
		return locator;
	}
	public void clickToElement(WebDriver driver, String locator) {
		find(driver, locator).click();
	}
	public void clickToElement(WebDriver driver,String locator, String...value) {
		find(driver, castRestParameter(locator, value)).click();
	}
	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		find(driver, locator).clear();
		find(driver, locator).sendKeys(value);
	}
	
	public void sendKeyToElement(WebDriver driver, String locator, String value, String... values) {
		find(driver, castRestParameter(locator, values)).clear();
		find(driver, castRestParameter(locator, values)).sendKeys(value);
	}
	
	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		select = new Select(find(driver, locator));
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedItemInDropdown(WebDriver driver, String locator) {
		select = new Select(find(driver, locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		select = new Select(find(driver, locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator,
			String expectedItem) {
		find(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, 20);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(byXpath(childItemLocator)));

		List<WebElement> allItems = finds(driver, childItemLocator);
		for (WebElement item : allItems) {
			if (item.getText().trim().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public String getElementAttribute(WebDriver driver,String locator,String attribute) {
		return find(driver, locator).getAttribute(attribute);
	}
	
	public String getElementText(WebDriver driver,String locator) {
		return find(driver, locator).getText();
	}
	public int countElementSize(WebDriver driver,String locator) {
		return finds(driver, locator).size();
	}
	public int countElementSize(WebDriver driver,String locator, String... value) {
		return finds(driver, castRestParameter(locator, value)).size();
	}
	public void checkToCheckbox(WebDriver driver,String locator) {
		if (!find(driver, locator).isSelected()) {
			find(driver, locator).click();
		}
	}
	public void unCheckToCheckbox(WebDriver driver,String locator) {
		if (find(driver, locator).isSelected()) {
			find(driver, locator).click();
		}
	}
	public boolean isControlDisplay(WebDriver driver,String locator) {
		return find(driver, locator).isDisplayed();
	}
	
	public boolean isControlDisplay(WebDriver driver,String locator,String...values) {
		return find(driver, castRestParameter(locator, values)).isDisplayed();
	}
	public boolean isElementEnable(WebDriver driver,String locator) {
		return find(driver, locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver,String locator) {
		return find(driver, locator).isSelected();
	}
	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(find(driver, locator));
	}
	public void switchToDefaultPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	public void doubleClickToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		action.doubleClick(find(driver, locator)).perform();
	}
	public void hoverToElement(WebDriver driver,String locator) {
		action = new Actions(driver);
		action.moveToElement(find(driver, locator)).perform();
	
	}
	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(find(driver, locator)).perform();
	}
	public void dragAndDropElement(WebDriver driver,String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(find(driver, sourceLocator), find(driver, targetLocator));
	}
	public void sendKeyBroadToElement(WebDriver driver, String locator,Keys key) {	
		action = new Actions(driver);
		action.sendKeys(find(driver, locator),key).perform();
	}
	public Object executeForBrowser1(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText1(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText1(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage1(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS1(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement1(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		WebElement element = find(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", find(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", find(driver, locator));
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, locator));
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, locator));
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, timeout);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", find(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", find(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}


	public Object executeForBrowser(WebDriver driver, String javaScript) {
			return ((JavascriptExecutor) driver).executeScript(javaScript);
		}
	
		public String getInnerText(WebDriver driver) {
			return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
		}
	
		public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
			String textActual = (String) ((JavascriptExecutor) driver)
					.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
			return textActual.equals(textExpected);
		}
	
		public void scrollToBottomPage(WebDriver driver) {
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
		}
	
		public void navigateToUrlByJS(WebDriver driver, String url) {
			((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
		}
	
		public void highlightElement(WebDriver driver, String locator) {
			element = find(driver, locator);
			String originalStyle = element.getAttribute("style");
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style",
					"border: 2px solid red; border-style: dashed;");
			sleepInSecond(1);
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
		}
	
		public void clickToElementByJS1(WebDriver driver, String locator) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", find(driver, locator));
		}
	
		public void scrollToElement1(WebDriver driver, String locator) {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", find(driver, locator));
		}
	
		public void sendkeyToElementByJS1(WebDriver driver, String locator, String value) {
			((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", find(driver, locator));
		}
	
		public void removeAttributeInDOM1(WebDriver driver, String locator, String attributeRemove) {
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", find(driver, locator));
		}
	
		public boolean areJQueryAndJSLoadedSuccess1(WebDriver driver) {
			WebDriverWait explicitWait = new WebDriverWait(driver, 30);
			ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					try {
						return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
					} catch (Exception e) {
						return true;
					}
				}
			};
			ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
				@Override
				public Boolean apply(WebDriver driver) {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
				}
			};
			return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
		}
	
		public String getElementValidationMessage1(WebDriver driver, String locator) {
			return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", find(driver, locator));
		}
	
		public boolean isImageLoaded1(WebDriver driver, String locator) {
			boolean status = (boolean) ((JavascriptExecutor) driver).executeScript(
					"return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0",
					find(driver, locator));
			if (status) {
				return true;
			} else {
				return false;
			}
		}
		public void waitToElementPresence(WebDriver driver,String locator) {
			explicitWait = new WebDriverWait(driver, timeout);
			explicitWait.until(ExpectedConditions.presenceOfElementLocated(byXpath(locator)));
		}
		public void waitToElementVisible(WebDriver driver,String locator) {
			explicitWait = new WebDriverWait(driver, timeout);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(locator)));
		}
		public void waitToElementVisible(WebDriver driver,String locator,String...values) {
			explicitWait = new WebDriverWait(driver, timeout);
			explicitWait.until(ExpectedConditions.visibilityOfElementLocated(byXpath(castRestParameter(locator, values))));
		}
		public void waitToElementInVisible(WebDriver driver,String locator) {
			explicitWait = new WebDriverWait(driver, timeout);
			explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(byXpath(locator)));
		}
		public void waitToElementClickable(WebDriver driver,String locator) {
			explicitWait = new WebDriverWait(driver, timeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(locator)));
		}
		public void waitToElementClickable(WebDriver driver,String locator,String...values) {
			explicitWait = new WebDriverWait(driver, timeout);
			explicitWait.until(ExpectedConditions.elementToBeClickable(byXpath(castRestParameter(locator, values))));
		}
		
//		SWITCH PAGE
		public DeposittPageObject openDepositPage(WebDriver driver) {
			// TODO Auto-generated method stub
			waitToElementClickable(driver, AbstractPageUI.DEPOSIT_LINK);
			clickToElement(driver, AbstractPageUI.DEPOSIT_LINK);
			return PageGeneratoManager.getDeposittPage(driver);
		}
		public FundTransferPageObject openFundTrasferPage(WebDriver driver) {
			waitToElementClickable(driver, AbstractPageUI.FUND_TRANSFER_LINK);
			clickToElement(driver, AbstractPageUI.FUND_TRANSFER_LINK);
			// TODO Auto-generated method stub
			return PageGeneratoManager.getFundTransferPage(driver);
		}
		
		public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
			// TODO Auto-generated method stub
			waitToElementClickable(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
			clickToElement(driver, AbstractPageUI.EDIT_CUSTOMER_LINK);
			return PageGeneratoManager.getEditCustomerPage(driver);
		}
		public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
			// TODO Auto-generated method stub
			waitToElementClickable(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
			clickToElement(driver, AbstractPageUI.NEW_CUSTOMER_LINK);
			return PageGeneratoManager.getNewCustomerPage(driver);
			
		}
		public LoginPageObject clickToLogoutLink(WebDriver driver) {
			// TODO Auto-generated method stub
			waitToElementClickable(driver, AbstractPageUI.LOGOUT_LINK);
			clickToElement(driver, AbstractPageUI.LOGOUT_LINK);
			waitToAlertPresence(driver);
			acceptAlert(driver);
//			return new LoginPageObject(driver);
			return PageGeneratoManager.getLoginPage(driver);
		}
		
//		Open dynamic page
		/* so luong page nhieu*/
		public void openMenuPagesByName(WebDriver driver,String pageName) {
			waitToElementClickable(driver, AbstractPageUI.DYNAMIC_MENU,pageName);
			clickToElement(driver, AbstractPageUI.DYNAMIC_MENU, pageName);
			
	
		}
		
		

	}
