package com.anshul.selenium.testsuite.testcases;

import org.openqa.selenium.WebDriver;

import com.anshul.selenium.testsuite.util.CommonUtil;

public class LoginTestCase {
	public void loginToSystem(final String testCaseString) {
		final WebDriver webDriver = CommonUtil.getWebDriver();
		if (testCaseString.equals("Login to Backoffice")) {

			webDriver.get(CommonUtil.WEB_URL);

		}
		if (testCaseString.equals("Login to Frontoffice")) {
			webDriver.get(CommonUtil.WEB_URL);
		}
	}
}
