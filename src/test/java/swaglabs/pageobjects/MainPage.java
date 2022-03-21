package swaglabs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
	private WebDriver driver;
	private By logo = By.className("app_logo");

	public MainPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean verifyLogo() {
		return driver.findElement(logo).isDisplayed();
	}

}
