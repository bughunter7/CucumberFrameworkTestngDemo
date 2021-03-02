package parallel;

import org.junit.Assert;

import com.pages.ContactusPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class ContactusSteps {

	ContactusPage cup = new ContactusPage(DriverFactory.getDriver());

	@Then("^a popup appears with title \"([^\"]*)\"$")
	public void a_popup_appears_with_title_something(String contactpoptitle) throws Throwable {
		String popup = contactpoptitle;

		Assert.assertTrue(popup.contains(cup.contactpopup()));
	}

	@And("^I click on contact link$")
	public void i_click_on_contact_link() throws Throwable {
		Thread.sleep(5000);
		cup.clickcontact();
	}

	@And("^I enter details which includes (.+) and (.+) and (.+)$")
	public void i_enter_details_which_includes_and_and(String email, String name, String message) throws Throwable {
		Thread.sleep(5000);

		cup.email().sendKeys(email);
		cup.name().sendKeys(name);
		cup.message().sendKeys(message);
	}

	@And("^I click send message button$")
	public void i_click_send_message_button() throws Throwable {
		cup.sendmessagebutton();
	}

}
