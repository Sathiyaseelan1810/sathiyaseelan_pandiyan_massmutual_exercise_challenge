package mockupExercise.TestRunner;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
/*    -------------------------------------------------------------
 * 		AUTHOR: Sathiyaseelan Pandiyan
 * 		AUTHOR EMAIL: seelan.pandiyan@gmail.com* 
 * 
     ------------------------------------------------------------- */

@RunWith(Cucumber.class)
@CucumberOptions(
				features = {"src/test/java/mockupExercise/CucumberFeatures/validateValues.feature"},
				glue = {"classpath:mockupExercise/StepDefinitions"},
				plugin = {"pretty",
						"com.cucumber.listener.ExtentCucumberFormatter:CucumberReports/ExtentReporter_MockupExercise.html",
						"json:CucumberReports/ExtentReporter_MockupExercise.json",
						"junit:CucumberReports/ExtentReporter_MockupExercise.xml"}, dryRun = false, strict = false, monochrome = true)

public class TestRunnerMock 
{
	@AfterClass
	public static void report()
	{
		Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
		Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone").toUpperCase());
		Reporter.setSystemInfo("Operating System", System.getProperty("os.name").toUpperCase());
		Reporter.setSystemInfo("Java Version", System.getProperty("java.version").toUpperCase());
	}
	

}
