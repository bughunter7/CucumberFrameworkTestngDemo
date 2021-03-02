package parallel;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;

public class NegativeLogin {

	@Then("^a popup appers with text \"([^\"]*)\"$")
	public void a_popup_appers_with_text_something(String popup) throws Throwable {

		Thread.sleep(3000);

		String expected = popup;

		String actual = DriverFactory.getDriver().switchTo().alert().getText();

		Assert.assertEquals(expected, actual);
	}

}
