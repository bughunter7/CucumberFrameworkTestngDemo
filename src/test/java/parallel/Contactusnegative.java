package parallel;

import org.junit.Assert;

import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Then;

public class Contactusnegative {

	@Then("^a popup appears with text \"([^\"]*)\"$")
	public void a_popup_appears_with_text_something(String alertmessage) throws Throwable {

		String actual = DriverFactory.getDriver().switchTo().alert().getText();

		String expected = alertmessage;

		Assert.assertEquals(expected, actual);

	}

}
