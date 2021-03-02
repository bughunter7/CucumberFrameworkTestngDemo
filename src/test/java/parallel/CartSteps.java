package parallel;

import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.pages.CartPage;
import com.pages.CheckoutPage;
import com.pages.HomePage;
import com.pages.ProductdetailsPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CartSteps {

	private HomePage hp = new HomePage(DriverFactory.getDriver());

	private ProductdetailsPage pp = new ProductdetailsPage(DriverFactory.getDriver());

	private CheckoutPage cop = new CheckoutPage(DriverFactory.getDriver());

	private CartPage cp = new CartPage(DriverFactory.getDriver());

	WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 10);

	String productname;
	String productprice;

	@Then("^I click on \"([^\"]*)\" with price of \"([^\"]*)\"$")
	public void i_click_on_something_with_price_of_something(String product, String price) throws Throwable {
		Thread.sleep(5000);

		productname = product;

		Assert.assertTrue(productname.contains(hp.getproductname()));
		productprice = price;
		Assert.assertTrue(productprice.contains(hp.getproductprice()));
		hp.productclick();
	}

	@Then("^popup appears with text product added$")
	public void popup_appears_with_text_product_added() throws Throwable {

		Thread.sleep(3000);
		String popuptext = "Product added.";

		String actual = DriverFactory.getDriver().switchTo().alert().getText();

		Assert.assertEquals(popuptext, actual);

		DriverFactory.getDriver().switchTo().alert().accept();

	}

	@Then("^I see same product is added with same price$")
	public void i_see_same_product_is_added_with_same_price() throws Throwable {
		Thread.sleep(3000);
		Assert.assertEquals(productname, cp.cartname());
		System.out.println(productname);
		Assert.assertEquals("360", cp.cartprice());
		System.out.println(productprice);
	}

	@And("^redirects to product details page$")
	public void redirects_to_product_details_page() throws Throwable {
		Assert.assertEquals("https://www.demoblaze.com/prod.html?idp_=1", hp.redirectpdp());
	}

	@And("^price of the product should be same as homepage$")
	public void price_of_the_product_should_be_same_as_homepage() throws Throwable {
		Thread.sleep(3000);
		System.out.println(productprice);
		// Assert.assertEquals(productprice,hp.getpdpprice());

		Assert.assertEquals(productprice, hp.getpdpprice());
	}

	@And("^I click on add to cart$")
	public void i_click_on_add_to_cart() throws Throwable {

		pp.addtocart();

	}

	@And("^I click on cart link$")
	public void i_click_on_cart_link() throws Throwable {
		cp.clickcart();

	}

	@And("^I click on place order after verifying price above$")
	public void i_click_on_place_order_after_verifying_price_above() throws Throwable {
		Assert.assertEquals(cp.cartprice(), cop.cartprice());
		cop.clickplacrorder();
	}

}
