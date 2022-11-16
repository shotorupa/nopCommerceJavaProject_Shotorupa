package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//Features/",
		glue = "stepDefinations", 
		plugin =  {"pretty","json:target/cucumber.json","html:target/test-output"},
		dryRun = true,
		monochrome = true,
        tags= "@sanity,@regression"
			)
public class TestRun extends AbstractTestNGCucumberTests  {

}