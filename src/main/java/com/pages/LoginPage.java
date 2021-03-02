package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;

public class LoginPage {

	private WebDriver driver;
	WebDriverWait loader = new WebDriverWait(DriverFactory.getDriver(), 10);

	// Constructors
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	// Webelements locators
	By loginlink = By.xpath("//*[@id='login2']");
	By username = By.xpath("//*[@id='loginusername']");
	By password = By.xpath("//*[@id='loginpassword']");
	By loginbutton = By.xpath("((//*[@class='modal-footer'])[3]/button)[2]");
	By postloginusername = By.xpath("//*[@id='nameofuser']");

	By popup = By.xpath("(//*[@class='modal-content'])[3]/div/H5");

	// Page Actions
	public String landingpagetitle() {
		return driver.getTitle();
	}

	public void hitloginlink() {
		driver.findElement(loginlink).click();

	}

	public void enterusername(String uname) {
		loader.until(ExpectedConditions.visibilityOf(driver.findElement(username)));
		driver.findElement(username).sendKeys(uname);

	}

	public void enterpassword(String pword) {
		driver.findElement(password).sendKeys(pword);
	}

	public void loginbutton() {
		driver.findElement(loginbutton).click();
	}

	public void validateheader() {
		loader.until(ExpectedConditions.visibilityOf(driver.findElement(postloginusername)));
		driver.findElement(postloginusername).getText();

	}

	public boolean popupverifier() {
		loader.until(ExpectedConditions.visibilityOf(driver.findElement(popup)));
		return driver.findElement(popup).isDisplayed();

	}

}
