package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CategoryPage {

	private WebDriver driver;

	public CategoryPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	By phone = By.xpath("(//*[@id='itemc'])[1]");

	By phonelist = By.xpath("//*[@class='col-lg-9']/div/div/div/div/h4");

	// //*[@class='col-lg-9']/div/div/div/div/h4

	public void phoneclick() {
		driver.findElement(phone).click();
	}

	public List<String> phoneitems() {

		List<WebElement> phonelist = driver.findElements(By.xpath("//*[@class='col-lg-9']/div/div/div/div/h4"));

		List<String> newlist = new ArrayList<>();
		for (int i = 0; i < phonelist.size(); i++) {

			String phonename = phonelist.get(i).getText();
			// System.out.println(phonename);

			newlist.add(phonename);

		}

		return newlist;
	}

}
