package com.jsystems.qa.qagui.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:com.jsystems.qa.qagui.cucumber",
        plugin = { "pretty", "html:report", "json:reports.json",
                "rerun:target/rerun.txt"},
        tags = {
//                "@wordpress",
//                "@BDD"
//                "@login",
//                "@userprofile"
                }
)
public class RunTest {
}
