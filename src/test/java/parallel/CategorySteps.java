package parallel;

import java.util.List;

import org.junit.Assert;

import com.pages.CategoryPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class CategorySteps {

	CategoryPage cap = new CategoryPage(DriverFactory.getDriver());

	@Then("^all products having phone are loaded$")
	public void all_products_having_phone_are_loaded(DataTable data) throws Throwable {
		Thread.sleep(3000);
		cap.phoneitems();
		List<String> products = data.asList();

		System.out.println("Expected products : " + products);

		Assert.assertTrue(products.containsAll(cap.phoneitems()));

	}

	@And("^clicks on phone from sidemenu of category$")
	public void clicks_on_phone_from_sidemenu_of_category() throws Throwable {
		Thread.sleep(3000);
		cap.phoneclick();
	}
}
