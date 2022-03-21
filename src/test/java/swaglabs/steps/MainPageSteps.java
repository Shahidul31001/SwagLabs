package swaglabs.steps;

import org.junit.Assert;

import io.cucumber.java.en.Then;
import swaglabs.base.BaseTest;
import swaglabs.pageobjects.MainPage;

public class MainPageSteps {
	@Then("I am redirected to the Sauce Demo Main Page")
	public void i_am_redirected_to_the_Sauce_Demo_Main_Page() {
		boolean verifyLogo = new MainPage(BaseTest.getDriver()).verifyLogo();
		Assert.assertTrue("Logo is not displayed as expected", verifyLogo);
	}

	@Then("I verify the App Logo exists")
	public void i_verify_the_App_Logo_exists() {
		boolean verifyLogo = new MainPage(BaseTest.getDriver()).verifyLogo();
		Assert.assertTrue("Logo is not displayed as expected", verifyLogo);
	}
}
