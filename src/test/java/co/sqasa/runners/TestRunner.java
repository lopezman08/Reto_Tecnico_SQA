package co.sqasa.runners;


import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "classpath:feature-files",
        glue = "co.sqasa.stepdefs",
        snippets = SnippetType.CAMELCASE,
        plugin = {"pretty"}
        //,tags = "@test"
)

public class TestRunner {
}
