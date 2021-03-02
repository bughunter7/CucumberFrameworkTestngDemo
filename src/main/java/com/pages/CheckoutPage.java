package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage {

	private WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By cartprice = By.xpath("//*[@id='totalp']");

	By placeorderbutton = By.xpath("//*[text()='Place Order']");

	By purchase = By.xpath("//*[text()='Purchase']");

	By name = By.xpath("//*[@id='name']");
	By country = By.xpath("//*[@id='country']");
	By city = By.xpath("//*[@id='city']");
	By card = By.xpath("//*[@id='card']");
	By month = By.xpath("//*[@id='month']");
	By year = By.xpath("//*[@id='year']");

	By thankyou = By.xpath("//*[text()='Thank you for your purchase!']");

	public String cartprice() {
		return driver.findElement(cartprice).getText();
	}

	public void clickplacrorder() {
		driver.findElement(placeorderbutton).click();
	}

	public void purchasebutton() {
		driver.findElement(purchase).click();
	}

	public String thankyou() {
		return driver.findElement(thankyou).getText();
	}

	public WebElement sendname() {
		return driver.findElement(name);

	}

	public WebElement sendcountry() {
		return driver.findElement(country);

	}

	public WebElement sendcity() {
		return driver.findElement(city);

	}

	public WebElement sendcard() {
		return driver.findElement(card);

	}

	public WebElement sendmonth() {
		return driver.findElement(month);

	}

	public WebElement sendyear() {
		return driver.findElement(year);

	}
}
