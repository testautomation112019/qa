package com.jsystems.qa.qagui.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "classpath:com.jsystems.qa.qagui.cucumber",
        plugin = { "pretty", "html:target/cucumber", "json:target/cucumber.json",
                "junit:target/cucumber.xml",
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
