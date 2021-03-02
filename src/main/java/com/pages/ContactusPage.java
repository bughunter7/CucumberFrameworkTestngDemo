package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactusPage {

	private WebDriver driver;

	public ContactusPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By contactuslink = By.xpath("//*[text()='Contact']");

	By contactheader = By.xpath("//*[@id='exampleModalLabel']");

	By sendmessage = By.xpath("//*[text()='Send message']");

	By email = By.xpath("//*[@id='recipient-email']");
	By name = By.xpath("//*[@id='recipient-name']");
	By message = By.xpath("//*[@id='message-text']");

	public void clickcontact() {
		driver.findElement(contactuslink).click();
	}

	public String contactpopup() {

		return driver.findElement(contactheader).getText();

	}

	public void sendmessagebutton() {
		driver.findElement(sendmessage).click();
	}

	public WebElement email() {
		return driver.findElement(email);
	}

	public WebElement name() {
		return driver.findElement(name);
	}

	public WebElement message() {
		return driver.findElement(message);
	}
}
