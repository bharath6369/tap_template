package com.project.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/com/project/features",
				 glue={"com/project/stepdefinitions","com/project/hook"},
				 publish=true,
				 plugin={"pretty","html:target/CucumberReports/CucumberReport.html"})
public class TestRunner {
	
	

}
