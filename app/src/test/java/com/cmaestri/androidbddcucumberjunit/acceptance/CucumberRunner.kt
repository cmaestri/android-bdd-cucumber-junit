package com.cmaestri.androidbddcucumberjunit.acceptance

import cucumber.api.CucumberOptions
import cucumber.api.junit.Cucumber
import org.junit.runner.RunWith

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/features"],
    glue = ["/"],
    plugin = ["pretty", "html:build/report/cucumber"]
)
class CucumberRunner