package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/features/test.feature"},
		glue = {"stepDef"},
		plugin = {"html:target/cucumber-html-report", "json:target/cucumber.json",
				 "pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", 
		"junit:target/cucumber-results.xml"}
		)
	
public class testrunner extends AbstractTestNGCucumberTests{
	
	private TestNGCucumberRunner testNGCucumberRunner;


    @BeforeClass( alwaysRun = true )
    public void setUpClass()  {
        testNGCucumberRunner = new TestNGCucumberRunner( this.getClass() );
    }

    @Test( groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features" )
    public void feature( PickleWrapper pickleWrapper,FeatureWrapper cucumberFeature ) {
        testNGCucumberRunner.runScenario( pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] features() {
        return testNGCucumberRunner.provideScenarios();
    }

    @AfterClass( alwaysRun = true )
    public void tearDownClass()  {
        testNGCucumberRunner.finish();
    }
}
