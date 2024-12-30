package stepDefinations;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features",glue="stepDefinations",plugin="html:target/htmlreport.html")
public class TestRunnerLog extends AbstractTestNGCucumberTests {

}
