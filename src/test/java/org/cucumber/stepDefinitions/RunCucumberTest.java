package org.cucumber.stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.runner.RunWith;
import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;

//@Suite
//@IncludeEngines("cucumber")
//@SelectClasspathResource("org/cucumber")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = {"org/cucumber/stepDefinitions"})
public class RunCucumberTest {
}
