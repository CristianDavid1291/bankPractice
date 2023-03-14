package com.bankingPractice.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.bankinPractice.interfaces.Web;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome extends Web {

	@Override
	public WebDriver initBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	@Override
	public WebDriver initBrowser(ChromeOptions co) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver(co);
		return driver;
		
	}
	

}
