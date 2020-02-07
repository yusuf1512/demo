package runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.testng.Reporter;
import io.cucumber.testng.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class) 
@CucumberOptions(
features = "src/test/javaFeatures"
,glue= {"seleniumgluecode"},
plugin = { "com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}, 
monochrome = true

)

public class testrunner {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File("config/report.xml"));
	}
}