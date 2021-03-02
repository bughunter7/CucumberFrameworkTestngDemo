package parallel;

import java.util.List;

import org.junit.Assert;

import com.pages.CheckoutPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CheckoutSteps {

	CheckoutPage cop = new CheckoutPage(DriverFactory.getDriver());

	List<List<String>> orderdetails;

	@Then("^a popup shows the thankyou message with order details$")
	public void a_popup_shows_the_thankyou_message_with_order_details() throws Throwable {
		String ty = "Thank you for your purchase!";

		Assert.assertEquals(ty, cop.thankyou());
	}

	@And("^I enter following details in placeorder popup$")
	public void i_enter_following_details_in_placeorder_popup(DataTable data) throws Throwable {
		Thread.sleep(5000);
		orderdetails = data.asLists();
		cop.sendname().sendKeys(orderdetails.get(1).get(0));
		cop.sendcountry().sendKeys(orderdetails.get(1).get(1));
		cop.sendcity().sendKeys(orderdetails.get(1).get(2));
		cop.sendcard().sendKeys(orderdetails.get(1).get(3));
		cop.sendmonth().sendKeys(orderdetails.get(1).get(4));
		cop.sendyear().sendKeys(orderdetails.get(1).get(5));

	}

	@And("^click on purchase button$")
	public void click_on_purchase_button() throws Throwable {
		cop.purchasebutton();
		Thread.sleep(3000);
	}

	@And("^I enter details from the given sheetname \"([^\"]*)\" and rownumber (.+)$")
	public void i_enter_details_from_the_given_sheetname_something_and_rownumber(String sheetname, String rownumber,
			String strArg1) throws Throwable {

	}

}
