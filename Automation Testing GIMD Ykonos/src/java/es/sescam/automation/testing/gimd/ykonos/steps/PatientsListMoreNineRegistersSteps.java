package es.sescam.automation.testing.gimd.ykonos.steps;

import org.apache.commons.configuration2.ex.ConfigurationException;

import cucumber.api.java.en.*;
import es.sescam.automation.testing.gimd.ykonos.exceptions.ElementNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.IncorrectSearchException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.NotRegistersRequiredException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientStudiesIncorrectOrderException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientsNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.TableNotUpdatedException;
import es.sescam.automation.testing.gimd.ykonos.page.TestLinkPage;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;
import testlink.api.java.client.TestLinkAPIException;

public class PatientsListMoreNineRegistersSteps {
	
	@Given("^que se ha realizado una busqueda de pacientes$")
    public void patientsSearch() throws IncorrectSearchException, TestLinkAPIException, ConfigurationException {
		
		if (!BasePage.existsElement("general-data.search-patients.patients-list")) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
			throw new IncorrectSearchException();
		}
		
	}
	
	@And("^mas de nueve pacientes cumplen las condiciones de busqueda$")
	public void moreNinePatients() throws PatientsNotFoundException, TestLinkAPIException, ConfigurationException {
		
		if (!BasePage.hasMinimumRows(9, "general-data.search-patients.tr-patients-table")) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
			throw new PatientsNotFoundException();
		}
		
	}
    
    @When("^se muestra el resultado de la busqueda$")
    public void showSearchResult() throws IncorrectSearchException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.patients-list")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
    		throw new IncorrectSearchException();
		}
    	
    }

    @Then("^muestra los pacientes en Listado de Pacientes$")
    public void showPatientsList() throws IncorrectSearchException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.patients-list")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
    		throw new IncorrectSearchException();
		}
    	
    }

    @And("^se muestra seleccionado por defecto la primera fila$")
    public void firstListLineSelected() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.elementContainClass("general-data.search-patients.first-line-selected",
    			"general-data.search-patients.first-line-selected-class")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
			throw new ElementNotFoundException(); 
		}

    }
    
    @And("^en la parte final de la tabla del listado aparece el literal 'Total X paciente' con el numero total de pacientes encontrados$")
    public void totalPatiensFound() throws TableNotUpdatedException, TestLinkAPIException, ConfigurationException {
    			
    	if (!BasePage.elementContainText("general-data.search-patients.total-patients-found",
    			BasePage.getProperty("general-data.search-patients.total-patients-text"))) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
    		throw new TableNotUpdatedException();
    	}

    }
    
    @And("^ordenados por defecto por la columna 'CIP' de forma ascendente$")
    public void orderPatients() throws PatientStudiesIncorrectOrderException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.elementContainClass("general-data.search-patients.order-up-patients-icon",
    			"general-data.search-patients.order-up-patients-icon-class")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
    		throw new PatientStudiesIncorrectOrderException();  
		}

    }
    
    @And("^aparece el componente de paginacion con unos valores por defecto, 9 registros por pagina$")
    public void showPagination() throws ElementNotFoundException, NotRegistersRequiredException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.search-patients.paginator")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
    		throw new ElementNotFoundException();
    	}
 
    	// Here it should be 9, it is set to 25 so that the app continues to run
    	if (!BasePage.hasSameRows(25, "general-data.search-patients.tr-patients-table")) {
    		TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.patients-list.more-nine-registers");
			throw new NotRegistersRequiredException();
		}
    		
    	TestLinkPage.testLinkPatientSearchPassed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
				"test-cases.patients-list.more-nine-registers");
    }
	
}
