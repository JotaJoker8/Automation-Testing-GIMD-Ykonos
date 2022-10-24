package es.sescam.automation.testing.gimd.ykonos.page;

import org.apache.commons.configuration2.ex.ConfigurationException;

import es.sescam.automation.testing.gimd.ykonos.testlink.TestLinkIntegration;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

// Class that is responsible for sending the test큦 results to TestLink
public class TestLinkPage {
	
	private TestLinkPage() {}
	
	// Method that confirms that a test has passed and sends the user큦 name and password information to TestLink
    public static void testLinkLoginPassed(String user, String password, String pathTest) throws TestLinkAPIException, ConfigurationException {
    	
    	TestLinkIntegration.updateResults(BasePage.getProperty(pathTest), "Usuario " + user 
        		+ " Password " + password, TestLinkAPIResults.TEST_PASSED);
    	
    }
    
    // Method that confirms that a test has not passed and sends the user큦 name and password information to TestLink
    public static void testLinkLoginFailed(String user, String password, String pathTest) throws TestLinkAPIException, ConfigurationException {
    	
    	TestLinkIntegration.updateResults(BasePage.getProperty(pathTest), "Usuario " + user 
        		+ " Password " + password, TestLinkAPIResults.TEST_FAILED);
    	
    }
    
    // Method that confirms that a test has passed and sends the user큦 name and surname information searched to TestLink
    public static void testLinkPatientSearchPassed(String patientName, String patientSurname, String pathTest) throws TestLinkAPIException, ConfigurationException {
    	
    	TestLinkIntegration.updateResults(BasePage.getProperty(pathTest), "Nombre " + patientName 
        		+ " Apellido " + patientSurname, TestLinkAPIResults.TEST_PASSED);
    	
    }
    
    // Method that confirms the error to search a patient큦 name and surname and sends the information to TestLink
    public static void testLinkPatientSearchFailed(String patientName, String patientSurname, String pathTest) throws TestLinkAPIException, ConfigurationException {
    	
    	TestLinkIntegration.updateResults(BasePage.getProperty(pathTest), "Nombre " + patientName 
        		+ " Apellido " + patientSurname, TestLinkAPIResults.TEST_FAILED);
    	
    }
    
}
