package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/BookFlight.feature", glue = { "stepdefinitions",
        "hook" }, plugin = {
                "pretty", // Pretty console output
                "html:target/cucumber-report.html", // HTML report
                "json:target/cucumber-report.json", // JSON report
                "junit:target/cucumber-report.xml" // JUnit XML report
        })
public class RunnerBookFlight extends AbstractTestNGCucumberTests {

}
