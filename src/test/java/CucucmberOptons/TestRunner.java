package CucucmberOptons;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Master
@RunWith(Cucumber.class)
@CucumberOptions(
       features = {"src/test/java/features/SignAccount.feature"}, 
       plugin = {"json:target/jsonReports/cucumber-report.json",
		         "rerun:target/failedrerun.txt"}, 
       glue = { "stepDefinations" }
      )
 //FailedtestCases execution test runner class
@RunWith(Cucumber.class)
@CucumberOptions(
		features = { "@target/failedrerun.txt" }, 
        plugin = { "json:target/jsonReports/cucumber-report.json",
		"rerun:target/failedrerun.txt" }, 
        glue = { "stepDefinations" })

 
public class TestRunner {

}
