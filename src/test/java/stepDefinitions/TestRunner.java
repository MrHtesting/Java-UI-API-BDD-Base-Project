package stepDefinitions;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)

@CucumberOptions(
        features = {"src/test/resources/features/"},
        plugin = {"pretty", "json:target/cucumber.json", "html:target/site/cucumber-pretty"},
        strict = true,
        glue = {"stepDefinitions"},


        // dryRun= true4
        tags = {"@test"}) // ~@test
public class TestRunner {
}
//format = { "pretty","json:target/cucumber.json" },
//html:target/cucumber-html-report