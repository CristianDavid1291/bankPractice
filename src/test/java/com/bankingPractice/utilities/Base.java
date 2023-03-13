package com.bankingPractice.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.bankingPractice.browsers.Chrome;

public class Base {
	
	protected WebDriver driver;
	protected ReadProperties rp = new ReadProperties();
	protected String url = rp.getUrl();
	protected String browser = rp.getBrowser();
	protected String timeOut = rp.getTimeOut();
	protected String user = rp.getUser();
	protected String password = rp.getPassword();
	
	@BeforeClass
	public void setUp() {
		
		switch (browser) {
		case "chrome":
			Chrome ch = new Chrome();
			driver = ch.initBrowser();
			break;

		default:
			break;
		}
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(timeOut)));
		
	}
	
	
	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
	
	
}