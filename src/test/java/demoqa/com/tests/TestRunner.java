package demoqa.com.tests;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"demoqa.com.tests.steps"},
        plugin = {"pretty"}
)
public class TestRunner {

}
