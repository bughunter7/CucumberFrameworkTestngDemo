package parallel;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;
import com.qa.util.Webwait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	private static String username;

	private LoginPage lp = new LoginPage(DriverFactory.getDriver());

	@Given("^user is on landing page$")
	public void user_is_on_landing_page() throws Throwable {

		DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Webwait.pageload, TimeUnit.SECONDS);
		DriverFactory.getDriver().manage().timeouts().pageLoadTimeout(Webwait.pageload, TimeUnit.SECONDS);

		DriverFactory.getDriver().get("https://www.demoblaze.com/index.html");

		String title = lp.landingpagetitle();
		System.out.println("Page Title is :" + title);
		Assert.assertEquals(title, "STORE");
	}

	@When("^clicks on login link$")
	public void clicks_on_login_link() throws Throwable {
		lp.hitloginlink();

	}

	@Then("^a popup appears with title Log in$")
	public void a_popup_appears_with_title_log_in() throws Throwable {

		Assert.assertTrue(lp.popupverifier());
	}

	@And("^user enters username \"([^\"]*)\"$")
	public void user_enters_username_something(String uname) throws Throwable {

		lp.enterusername(uname);
		username = uname;

	}

	@And("^user enters password \"([^\"]*)\"$")
	public void user_enters_password_something(String pword) throws Throwable {
		lp.enterpassword(pword);
	}

	@Then("^header appears with welcome text followed by \"([^\"]*)\"$")
	public void header_appears_with_welcome_text_followed_by_something(String expectedusername) throws Throwable {

		Assert.assertTrue(username.contains(expectedusername));
	}

	@Then("^user click on loginbutton$")
	public void user_click_on_loginbutton() throws Throwable {
		lp.loginbutton();
	}
}
