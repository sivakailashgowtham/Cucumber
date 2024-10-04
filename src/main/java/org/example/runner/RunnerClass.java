package org.example.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/resources/featureFiles",
glue = "org.example.stepDefinition",
monochrome = true)
public class RunnerClass {
}
