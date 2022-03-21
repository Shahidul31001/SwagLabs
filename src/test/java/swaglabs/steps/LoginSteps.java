package swaglabs.steps;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import swaglabs.base.BaseTest;
import swaglabs.pageobjects.LoginPage;

public class LoginSteps {

	@Given("I am on the Sauce Demo Login Page")
	public void i_am_on_the_Sauce_Demo_Login_Page() {
		boolean verifyLandingPage = new LoginPage(BaseTest.getDriver()).verifyLandingPage();
		Assert.assertTrue("Landing page did not appear", verifyLandingPage);
	}

	@When("I fill the account information for account StandardUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_StandardUser_into_the_Username_field_and_the_Password_field() {
		LoginPage loginPage = new LoginPage(BaseTest.getDriver());
		loginPage.typeUsername("standard_user");
		loginPage.typePassword("secret_sauce");
	}

	@When("I click the Login Button")
	public void i_click_the_Login_Button() {
		new LoginPage(BaseTest.getDriver()).clickLoginButton();
	}

	@When("I fill the account information for account LockedOutUser into the Username field and the Password field")
	public void i_fill_the_account_information_for_account_LockedOutUser_into_the_Username_field_and_the_Password_field() {
		LoginPage loginPage = new LoginPage(BaseTest.getDriver());
		loginPage.typeUsername("locked_out_user");
		loginPage.typePassword("secret_sauce");
		loginPage.clickLoginButton();
	}

	@Then("I verify the Error Message contains the text {string}")
	public void i_verify_the_Error_Message_contains_the_text(String string) {
		String erroMessage = new LoginPage(BaseTest.getDriver()).getErroMessage();
		Assert.assertTrue("Expected error message did not appear. Actual message was: " + erroMessage,
				erroMessage.contains(string));
	}

}
