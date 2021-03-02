package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductdetailsPage {

	private WebDriver driver;

	public ProductdetailsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By addtocart = By.xpath("(//*[@class='row'])[2]/div/a");

	public void addtocart() {
		driver.findElement(addtocart).click();
	}

}
