package swaglabs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private WebDriver driver;
	private static By erroMessage = By.cssSelector("[data-test='error']");
	private static By loginButton = By.id("login-button");
	private static By login = By.id("user-name");
	private static By password = By.id("password");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUsername(String username) {
		WebElement usernameField = driver.findElement(login);
		usernameField.clear();
		usernameField.sendKeys(username);
	}

	public boolean verifyLandingPage() {
		return driver.findElement(login).isDisplayed();

	}

	public void typePassword(String value) {
		WebElement passwordField = driver.findElement(password);
		passwordField.clear();
		passwordField.sendKeys(value);
	}

	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

	public String getErroMessage() {
		return driver.findElement(erroMessage).getText().trim();
	}

}
