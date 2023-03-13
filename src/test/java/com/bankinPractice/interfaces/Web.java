package com.bankinPractice.interfaces;

import org.openqa.selenium.WebDriver;

public abstract class Web implements Client,Browser {

	public abstract WebDriver initBrowser();

	public void initClient() {
		
		initBrowser();
		
	}

}
