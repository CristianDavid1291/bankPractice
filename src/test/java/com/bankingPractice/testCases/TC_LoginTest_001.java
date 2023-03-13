package com.bankingPractice.testCases;

import org.testng.annotations.Test;

import com.bankingPractice.pageObjects.LoginPage;
import com.bankingPractice.utilities.Base;

public class TC_LoginTest_001 extends Base {
	
	@Test
	public void test_001() {
		
		LoginPage lp = new LoginPage(driver);
		lp.setName(user);
		lp.setPassword(password);
		lp.clickLoginButton();
	}
	
}
