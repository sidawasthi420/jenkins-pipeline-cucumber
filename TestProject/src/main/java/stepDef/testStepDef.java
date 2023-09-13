package stepDef;

import java.io.IOException;

import io.cucumber.java.en.Given;
import pageObjects.Batch;

public class testStepDef {

	private Batch batch;
	
	public testStepDef()
	{
		batch = new Batch();
	}
	
	@Given("^Store response to a file$")
	public void store_response_to_a_file() throws IOException {
	    String file = "test123.properties";
	    String fileLocation = System.getProperty("user.dir")+"/src/test/resources/JobsData/";
	    System.out.println(fileLocation);
	    batch.createAndClearProperties(file, fileLocation);
	    batch.updateProperitesOfFile(file, fileLocation);
	}
}
