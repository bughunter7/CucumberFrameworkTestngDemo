package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.factory.DriverFactory;



public class CartPage {

	private WebDriver driver;

	public CartPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	private WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	By cartlink = By.xpath("//*[@id='navbarExample']/ul/li[4]");

	By cartproductname = By.xpath("//*[@id='tbodyid']/tr/td[2]");

	By cartproductprice = By.xpath("//*[@id='tbodyid']/tr/td[3]");

	public void clickcart() {
		driver.findElement(cartlink).click();
	}

	public String cartname() {

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(cartproductname)));

		return driver.findElement(cartproductname).getText();
	}

	public String cartprice() {
		return driver.findElement(cartproductprice).getText();
	}

}
