 package com.Runner;

import org.junit.runner.RunWith;

import com.hooks.Hooks;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/Features/c2ta.feature", glue = {"com.Steps","com.hooks"},dryRun = false
,
      plugin = "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class Runner extends Hooks{

}
