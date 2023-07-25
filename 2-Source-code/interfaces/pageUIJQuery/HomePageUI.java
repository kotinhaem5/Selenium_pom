package pageUIJQuery;

public class HomePageUI {
public static final String DYNAMIC_TEXT_BY_COLUMN_NAME = "//div[text()='%s']/parent::div/following-sibling::input";
public static final String DYNAMIC_PAGE_BY_PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link' and text()='%s']";
public static final String DYNAMIC_PAGE_ACTIVE_BY_PAGE_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
public static final String DYNAMIC_DELETE_ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'remove')]";
public static final String DYNAMIC_EDIT_ICON_BY_COUNTRY_NAME = "//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']/button[contains(@class,'edit')]";
public static final String DYNAMIC_INDEX_BY_COLUMN_NAME = "//th[text()='%s']/preceding-sibling::th";
public static final String DYNAMIC_TEXTBOX_BY_COLUMN_INDEX = "//tr[%s]/td[%s]/input";
}