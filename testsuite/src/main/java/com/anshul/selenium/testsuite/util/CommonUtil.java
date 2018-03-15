package com.anshul.selenium.testsuite.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CommonUtil {

	public static final String TEST_CASE_PATH = "/Users/anshulgautam/EclipseWorkspaces/SeleniumProject/testsuite/src/main/resources/testcases.xlsx";
	public static final String WEB_URL = "https://qa1.qglobal.pearsonclinical.com/qg/login.seam";
	private static WebDriver webDriver;

	public static WebDriver getWebDriver() {
		if (isNullOrEmpty(CommonUtil.webDriver)) {
			System.setProperty("webdriver.chrome.driver", "/Softwares/chromedriver");
			CommonUtil.webDriver = new ChromeDriver();
		}
		return webDriver;
	}

	public static boolean isNullOrEmpty(Object obj) {
		if (null != obj) {
			return false;
		}
		return true;
	}
}
