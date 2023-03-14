package com.bankingPractice.utilities;

import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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
	public static Logger logger;
	
	
	@BeforeClass
	public void setUp() {
		logger = Logger.getLogger("Banking Practice");
		PropertyConfigurator.configure("log4j.properties");
		
		switch (browser) {
		case "chrome":
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			Chrome ch = new Chrome();
			driver = ch.initBrowser(options);
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
