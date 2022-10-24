package es.sescam.automation.testing.gimd.ykonos.steps;

import org.apache.commons.configuration2.ex.ConfigurationException;

import cucumber.api.java.en.*;
import es.sescam.automation.testing.gimd.ykonos.exceptions.ElementNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.IncorrectSearchException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientsNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.page.HistoryPatientPage;
import es.sescam.automation.testing.gimd.ykonos.page.TestLinkPage;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;
import testlink.api.java.client.TestLinkAPIException;

public class SearchPatientNameSurnameSteps {
	
	@Given("^que escribimos un Nombre válido de un paciente en el campo de búsqueda Nombre$")
    public void enterValidName() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
		
		if (!BasePage.existsElement("general-data.history-link")) {
			TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.search-patients-name-surname");
			throw new ElementNotFoundException();
		}
		else {
			BasePage.clickElement("general-data.history-link");		
			if (!BasePage.elementContainClass("general-data.history-link", "general-data.history-class")) {
				TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
	    				BasePage.getProperty("general-data.authentication.credentials.password"),
	    				"test-cases.search-patients-name-surname");
				throw new ElementNotFoundException();  
			}
			else {
				if (!BasePage.existsElement("general-data.search-patients.name-searched")) {
					TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
		    				BasePage.getProperty("general-data.authentication.credentials.password"),
		    				"test-cases.search-patients-name-surname");
					throw new ElementNotFoundException();
				}
				else {
					BasePage.writeText("general-data.search-patients.name-searched",
							BasePage.getProperty("general-data.authentication.credentials.patient-name"));
				}
				
			}
			
		}
		
	}
    
    @And("^escribimos un apellido válido de un paciente en el campo de búsqueda Primer Apellido$")
    public void enterValidSurname() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.surname-searched")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.search-patients-name-surname");
    		throw new ElementNotFoundException();
		}
    	else {
			BasePage.writeText("general-data.search-patients.surname-searched",
					BasePage.getProperty("general-data.authentication.credentials.patient-surname"));
		}
    	
    }
    
    @When("^se da al botón 'Buscar'$")
    public void clickButtonSearch() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.button")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.search-patients-name-surname");
    		throw new ElementNotFoundException();
    	}
    	else {
    		BasePage.clickElement("general-data.search-patients.button");
    	}
    	
    }
    
    @Then("^se realiza la petición de los demográficos del paciente en el WS de MXXI por Nombre y Primer Apellido$")
    public void makeRequest() throws ElementNotFoundException, PatientsNotFoundException, InterruptedException, TestLinkAPIException, ConfigurationException {
    	
    	BasePage.pause();
    	BasePage.pause();
    	
    	if (!BasePage.existsElement("general-data.search-patients.patients-list")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.search-patients-name-surname");
    		throw new ElementNotFoundException();
    	}
    	else {
    		HistoryPatientPage.checkSearchPatientDataCriteria(3,4);
    	}
    	
    }
    
    @And("^se muestra en pantalla el resultado de la búsqueda$")
    public void showSearchResult() throws PatientsNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.search-result")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.search-patients-name-surname");
    		throw new PatientsNotFoundException();
    	}
    	
    }

    @And("^se lista en el apartado Listado Pacientes los pacientes que cumplen dichos criterios$")
    public void showPatientsCriteria() throws IncorrectSearchException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.patients-list")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.search-patients-name-surname");
			throw new IncorrectSearchException();
		}
    	else {
			TestLinkPage.testLinkPatientSearchPassed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.search-patients-name-surname");
		}
    	
    }
	
}
