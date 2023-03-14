package com.bankingPractice.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingPractice.pageObjects.LoginPage;
import com.bankingPractice.utilities.Base;

public class TC_LoginTest_001 extends Base {

	@Test
	public void test_001() {
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setName(user);
		logger.info("user name entered");
		lp.setPassword(password);
		logger.info("password entered");
		lp.clickLoginButton();
		logger.info("Login button clicked");
		logger.info("Validating page tittle");
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login test passed");
		} else {
			Assert.assertTrue(false);
			logger.info("Login test failed");
		}
	}

}
