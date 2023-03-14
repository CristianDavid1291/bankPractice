package com.bankingPractice.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingPractice.pageObjects.HomePage;
import com.bankingPractice.pageObjects.LoginPage;
import com.bankingPractice.utilities.Base;
import com.bankingPractice.utilities.Provider;

public class TC_LoginTest_001 extends Base {

	@Test(dataProvider = "getData", dataProviderClass = Provider.class)
	public void test_001(String userP,String passwordP, String expectationP) {
		
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		lp.setName(userP);
		logger.info("user name entered" + userP);
		lp.setPassword(passwordP);
		logger.info("password entered"+ passwordP);
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
		HomePage hm = lp.logOut();
	}

}
