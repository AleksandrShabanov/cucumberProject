package org.cucumber.stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.runner.RunWith;

import static io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME;


@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty")
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"org/cucumber/stepDefinitions"},
        plugin = {"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        tags = "@smoketest")
public class SmokeTest {
}

//    mvn test -DCucumber.Options="--tags @smoketest"

//for multiple,
//        mvn test -DCucumber.Options="--tags @ISEAdmin-View/Modify,@ISEAdmin-ReadOnly"