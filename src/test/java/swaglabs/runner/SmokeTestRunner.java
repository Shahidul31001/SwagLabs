package swaglabs.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "json:build/cucumber-report.json",
		"de.monochromata.cucumber.report.PrettyReports:report/cucumber" }, 
		features = "src/test/resources", glue = {"swaglabs" }, tags = { "@smoke" })
public class SmokeTestRunner {

}
