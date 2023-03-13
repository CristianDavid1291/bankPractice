package com.bankingPractice.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperties {

	Properties prop;

	public ReadProperties() {
		prop = new Properties();
		try {
			FileInputStream flio = new FileInputStream(System.getProperty("user.dir")+"//Configuration//configuration.properties");
			prop.load(flio);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	public String getUrl() {
		return prop.getProperty("url");
	}
	
	public String getBrowser() {
		return prop.getProperty("browser");
	}
	
	public String getUser() {
		return prop.getProperty("user");
	}
	
	public String getPassword() {
		return prop.getProperty("password");
	}
	
	public String getTimeOut() {
		return prop.getProperty("time_out");
	}

}
