package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="/home/altius/eclipse-workspace/teleasyProject/src/test/java/FeatureFiles",
glue={"stepDefinitionFiles"},
plugin= {"pretty"},
//junit:target/cucumber-reports/report.xml
//json:target/cucumber-reports/report.json
//html:target/cucumber-reports/report.html
monochrome=true,
publish=true
)
public class TestRunner {

	
}
