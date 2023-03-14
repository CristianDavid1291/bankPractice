package com.bankingPractice.pageObjects;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(css = "input[name='uid']")
	WebElement nameField;

	@FindBy(css = "input[name='password']")
	WebElement passwordField;

	@FindBy(css = "input[name='btnLogin']")
	WebElement loginButton;

	@FindBy(css = "input[name='btnLogin']")
	WebElement resetButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setName(String name) {
		nameField.sendKeys(name);
	}

	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		loginButton.click();
	}

	public void clickresetButton() {
		resetButton.click();
	}

	public HomePage logOut() {
		HomePage hm = new HomePage(driver);
		hm.clickLogOutButton();
		if (isAlertPresent()) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			return hm;
		} else {
			return null;
		}
	}

	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
