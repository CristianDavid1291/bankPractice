package com.bankinPractice.interfaces;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public interface Browser {
	
	public WebDriver initBrowser();

	public WebDriver initBrowser(ChromeOptions co);

}
