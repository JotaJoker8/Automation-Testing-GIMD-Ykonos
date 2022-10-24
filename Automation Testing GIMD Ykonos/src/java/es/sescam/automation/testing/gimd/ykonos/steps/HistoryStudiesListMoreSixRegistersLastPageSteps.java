package es.sescam.automation.testing.gimd.ykonos.steps;

import org.apache.commons.configuration2.ex.ConfigurationException;

import cucumber.api.java.en.*;
import es.sescam.automation.testing.gimd.ykonos.exceptions.NotPatientStudiesException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PaginatorValueNotClickedException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PaginatorValueNotModifiedException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientDataNotLoadedException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientStudiesIncorrectOrderException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientStudiesNumberNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.TableNotUpdatedException;
import es.sescam.automation.testing.gimd.ykonos.page.HistoryStudiesPatientPage;
import es.sescam.automation.testing.gimd.ykonos.page.TestLinkPage;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;
import testlink.api.java.client.TestLinkAPIException;

public class HistoryStudiesListMoreSixRegistersLastPageSteps {
	
	@Given("^que se ha realizado una búsqueda de un paciente con mas de 6 estudios asociados$")
    public void patientMoreSixStudies() throws  NotPatientStudiesException, TestLinkAPIException, ConfigurationException {
		
		try {
			HistoryStudiesPatientPage.patientSearchMoreNumberStudies(6);
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new NotPatientStudiesException();
		}
		
	}
	
	@And("^se carga la pantalla de detalle de los datos del historial del paciente.$")
	public void navigateToPatientHistory() throws PatientDataNotLoadedException, TestLinkAPIException, ConfigurationException {
		
		try {
			HistoryStudiesPatientPage.loadPatientHistoryPage();
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new PatientDataNotLoadedException();
		}
		
	}
    
    @When("^se modifica el componente de paginación para acceder a la última pagina del listado.$")
    public void modifyNumberStudies() throws PaginatorValueNotClickedException, PaginatorValueNotModifiedException, TestLinkAPIException, ConfigurationException {
    	
    	try {
    		HistoryStudiesPatientPage.clickInDropdown("general-data.search-patient-history.dropdown.paginator");
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new PaginatorValueNotModifiedException();
		}
    	
    	try {
    		BasePage.getAndClickLastElementPosition("general-data.search-patient-history.dropdown.list");
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new PaginatorValueNotClickedException();
		}

    }

    @Then("^se recarga la tabla de Historial de Paciente para mostrar la última página.$")
    public void reloadHistoryPatientTable() throws TableNotUpdatedException, TestLinkAPIException, ConfigurationException {
    	
    	try {
    		HistoryStudiesPatientPage.clickReloadPatientHistoryListButton();
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new TableNotUpdatedException();
		}
    	
    }

    @And("^al final de la lista, se indica el numero de estudios encontrados 'El paciente tiene un total de X estudios asociados'$")
    public void totalStudies() throws PatientStudiesNumberNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	try {
    		HistoryStudiesPatientPage.checkTotalPatientStudies();
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new PatientStudiesNumberNotFoundException();
		}
    	
    }
    
    @And("^por defecto, los estudios aparecen ordenados en orden descendente por la fecha del estudio$")
    public void orderStudies() throws PatientStudiesIncorrectOrderException, TestLinkAPIException, ConfigurationException {
    	
    	try {
        	HistoryStudiesPatientPage.checkPatientHistoryDownOrder();
		} catch (Exception e) {
			TestLinkPage.testLinkPatientSearchFailed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
    				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
    				"test-cases.history-studies-list-more-six-register-paginator.last-page");
			throw new PatientStudiesIncorrectOrderException();
		}
    	
    	TestLinkPage.testLinkPatientSearchPassed(BasePage.getProperty("general-data.authentication.credentials.patient-name"),
				BasePage.getProperty("general-data.authentication.credentials.patient-surname"),
				"test-cases.history-studies-list-more-six-register-paginator.last-page");
    	
    }
	
}
