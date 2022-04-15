package cucumberTest;

//import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class ActivitiesRunner {

	@RunWith(Cucumber.class)
	@CucumberOptions
	(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@activity2_5"
	)
	    //empty
}
