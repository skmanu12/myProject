package QAs;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/java/features/Registered_User_End_To_End_New_Reservations_For_Microsites.feature",""},
		plugin={"json:target/jsonReports/cucumber-report.json", "rerun:target/failedrerun.txt"},
		glue="stepDefinations")

public class ReRunFailedScenariosIInCucumber {

}
