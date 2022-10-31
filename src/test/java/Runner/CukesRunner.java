package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={""},
        features={"src/test/resources/Features"},
        glue = {"src/test/java/step_Def"},
        dryRun = false,
        tags = "@wip"

)

public class CukesRunner {
}
