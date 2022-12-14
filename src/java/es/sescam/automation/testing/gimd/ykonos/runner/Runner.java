package es.sescam.automation.testing.gimd.ykonos.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import es.sescam.automation.testing.gimd.ykonos.exceptions.IncorrectConfigurationException;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = {"src/resources/features"},
    glue = {"es.sescam.automation.testing.gimd.ykonos.steps"},  
    plugin = {"pretty", "junit:target/cucumber-reports/cucumber.xml"}, 
    tags = {"@Test"}
)

public class Runner {
	
	private Runner() {}
	
	@BeforeClass
	public static void initializeDriver() throws IncorrectConfigurationException {
		BasePage.initializeBrowser();
	}
	
    @AfterClass
    public static void clearDriver() {
        BasePage.closeBrowser();
    }
    
}
