package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/test.feature"},
		glue = {"stepDef"},
		plugin = {"html:target/cucumber.html"}
		)
public class testrunner {

}
