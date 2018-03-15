package com.anshul.selenium.testsuite.main;

import com.anshul.selenium.testsuite.testcases.LogOutTestCase;
import com.anshul.selenium.testsuite.testcases.LoginTestCase;
import com.anshul.selenium.testsuite.util.CommonUtil;
import com.anshul.selenium.testsuite.util.ReadFromExcelUtil;

public class TestSuiteExecute {

	public static void main(String[] args) {
		ReadFromExcelUtil.readFromExcel(CommonUtil.TEST_CASE_PATH);
	}

	public static void RunTestCase(final String testCaseString) {
		if (testCaseString.equals("Login to Frontoffice")) {
			LoginTestCase testCase = new LoginTestCase();
			testCase.loginToSystem(testCaseString);
		}
		if (testCaseString.equals("Logout")) {
			LogOutTestCase testCase = new LogOutTestCase();
			// testCase.logOut(testCaseString);
		}
	}

}
