package es.sescam.automation.testing.gimd.ykonos.steps;

import org.apache.commons.configuration2.ex.ConfigurationException;

import cucumber.api.java.en.*;
import es.sescam.automation.testing.gimd.ykonos.exceptions.ElementNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.IncorrectSearchException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PageNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientsNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.page.HistoryPatientPage;
import es.sescam.automation.testing.gimd.ykonos.page.TestLinkPage;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;
import testlink.api.java.client.TestLinkAPIException;

public class PatientsListSelectPatientDoubleClickSteps {
	
	@Given("^que tenemos pacientes en el listado de pacientes$")
    public void thereArePatients() throws IncorrectSearchException, TestLinkAPIException, ConfigurationException  {
		
		if (!BasePage.existsElement("general-data.search-patients.patients-list")) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.select-patient-double-click");
			throw new IncorrectSearchException();
		}
		
	}
	
	@And("^cumplen los criterios de búsqueda$")
	public void searchCriteria() throws PatientsNotFoundException, TestLinkAPIException, ConfigurationException  {
		
		if (!BasePage.existsElement("general-data.search-patients.patients-list")){
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.select-patient-double-click");
    		throw new PatientsNotFoundException();
    	}
		
		try {
			HistoryPatientPage.checkSearchPatientDataCriteria(3,4);
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.select-patient-double-click");
			throw new PatientsNotFoundException();
		}
	
	}
    
    @When("^se selecciona un paciente$")
    public void selectPatient() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	try {
    		BasePage.clickElement("general-data.search-patients.first-line-selected");
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.select-patient-double-click");
			throw new ElementNotFoundException();
		}
    	
    }

    @Then("^se hace doble clic en el listado de pacientes$")
    public void clickPatientsList() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	try {
    		BasePage.doubleClick("general-data.search-patients.first-line-selected");
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.select-patient-double-click");
			throw new ElementNotFoundException();
		}
    	
    }

    @And("^se accede a la pantalla del historial del paciente$")
    public void accessPatientHistory() throws PageNotFoundException, InterruptedException, TestLinkAPIException, ConfigurationException {
    	
    	BasePage.pause();
    	 
    	if (!BasePage.navigateCorrect("general-data.search-patient-history.url")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.select-patient-double-click");
    		throw new PageNotFoundException();
    	}
    	
    	TestLinkPage.testLinkPatientSearchPassed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
				"test-cases.patients-list.select-patient-double-click");

    }

}
