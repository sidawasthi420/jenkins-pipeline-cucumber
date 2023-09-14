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

	@test
	public void m1()
	{
		System.out.println("Hello World");
        }
