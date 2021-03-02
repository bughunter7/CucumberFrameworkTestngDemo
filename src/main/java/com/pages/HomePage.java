package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By productname = By.xpath("(//*[@id='tbodyid']/div)[1]/div/div/h4");
	By productprice = By.xpath("(//*[@id='tbodyid']/div)[1]/div/div/h5");

	By pdpprice = By.xpath("//*[text()='$360']");

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	public WebElement proname() {
		return driver.findElement(productname);
	}

	public WebElement proprice() {
		return driver.findElement(productprice);
	}

	public String getproductname() {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(productname)));

		return driver.findElement(productname).getText();

	}

	public String getproductprice() {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(productprice)));
		return driver.findElement(productprice).getText();
	}

	public void productclick() {
		driver.findElement(productname).click();
	}

	public String redirectpdp() {
		return driver.getCurrentUrl();
	}

	public String getpdpprice() {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(pdpprice)));
		String pdp = driver.findElement(pdpprice).getText();

		String substring = (String) pdp.subSequence(0, 4);
		return substring;
	}
}
