package com.cmaestri.androidbddcucumberjunit

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/acceptanceTest/resources/features/"],
    glue = ["com/cmaestri/androidbddcucumberjunit/stepdefinitions/"],
    plugin = ["pretty", "html:build/report/cucumber"]
)
class CucumberRunner