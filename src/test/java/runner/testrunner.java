package runner;

import org.junit.runner.RunWith;
 
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/test.feature"},
		glue = {"stepDef"},
		plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",
 			"pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", 
			"junit:target/cucumber-results.xml"},
       	        dryRun = false,
        	strict = true,
        	monochrome = true,
        	snippets=SnippetType.CAMELCASE
	)
	
public class testrunner extends AbstractTestNGCucumberTests{
}
