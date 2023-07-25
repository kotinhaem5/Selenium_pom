package com.bankguru.user;

public class Part_12_Dynamic_Locator {
static String DYNAMIC_ROW_VALUE = "//td[text()='%s']/following-sibling::td[@data-key='males' and text = '%s']" + " %s";

public static void main(String[] args) {
	clickToMenu(DYNAMIC_ROW_VALUE, "test", "222","check");
}
public static void clickToMenu(String locator, String... value) {
	locator = String.format(locator,(Object[]) value);
	System.out.println(locator);
}

}

