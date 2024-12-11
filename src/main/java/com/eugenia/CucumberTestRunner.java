package com.eugenia;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/java/com/eugenia/features",
        glue = "com.eugenia.step_definitions",
        tags = "@runNow"
)

public class CucumberTestRunner {
}
