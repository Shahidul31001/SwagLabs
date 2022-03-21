package swaglabs.base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.Status;
import io.cucumber.messages.internal.com.google.common.net.MediaType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	private static WebDriver driver;

	public static WebDriver createDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.navigate().to("https://www.saucedemo.com");

		driver.manage().window().maximize();
		return driver;
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = createDriver();
		}
		return driver;
	}

	@Before
	public void setup() {
		createDriver();
	}

	@After
	public void teardown(Scenario scenario) {
		// if (scenario.getStatus() != Status.PASSED) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.embed(screenshot, String.valueOf(MediaType.PNG), scenario.getName());
		// }
		if (null != driver) {
			driver.quit();
		}

	}
}
