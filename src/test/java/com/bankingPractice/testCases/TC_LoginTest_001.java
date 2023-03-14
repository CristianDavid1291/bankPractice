package com.bankingPractice.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.bankingPractice.pageObjects.HomePage;
import com.bankingPractice.pageObjects.LoginPage;
import com.bankingPractice.utilities.Base;
import com.bankingPractice.utilities.Provider;

public class TC_LoginTest_001 extends Base {

	@Test(dataProvider = "getData", dataProviderClass = Provider.class)
	public void test_001(String userP, String passwordP, String expectationP) {

		logger.info("URL is opened");

		LoginPage lp = new LoginPage(driver);
		lp.setName(userP);
		logger.info("user name entered" + userP);
		lp.setPassword(passwordP);
		logger.info("password entered" + passwordP);
		lp.clickLoginButton();
		logger.info("Login button clicked");
		logger.info("Validating page tittle");

		if (expectationP.equals("valid")) {
			String title = driver.getTitle();
			Assert.assertEquals(title, "Guru99 Bank Manager HomePage");
			HomePage hm = lp.logOut();

			if (hm == null) {
				logger.warn("Alert not found");
				Assert.assertTrue(false, " Alert not found");

			}
			
		} else {

			String message = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.info(message);
			Assert.assertEquals(message,"User is not valid");

		}

	}

}
