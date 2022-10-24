package es.sescam.automation.testing.gimd.ykonos.page;

import es.sescam.automation.testing.gimd.ykonos.exceptions.ElementNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.NotPatientStudiesException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientStudiesIncorrectOrderException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientStudiesNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.TotalNumberPatientStudiesNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;

public class HistoryStudiesPatientPage {
	
	private HistoryStudiesPatientPage() {}
	
	// Method that checks that the patient's studies list exists and has more than the requested number of associated studies
    public static void patientSearchMoreNumberStudies(int patientNumberStudies) throws PatientStudiesNotFoundException, NotPatientStudiesException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.list")) {
			throw new PatientStudiesNotFoundException();
		}
		
		if (!BasePage.hasMoreRows(patientNumberStudies, "general-data.search-patient-history.tr-patient-studies-table")) {
			throw new NotPatientStudiesException();
		}
    	
    }
    
    // Method that checks and loads the detail of the first patient´s history
    public static void loadPatientHistoryPage() throws PatientStudiesNotFoundException, InterruptedException, ElementNotFoundException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.first-line-selected")) {
    		throw new PatientStudiesNotFoundException();
		}
    	else {
			BasePage.clickElement("general-data.search-patient-history.first-line-selected");
			BasePage.pause();
			BasePage.clickElement("general-data.search-patient-history.first-line-selected");
			BasePage.pause();
		}
    	
    }
    
    // Method that checks if the patient has studies and if the number of records requested appears on the list
    public static void showRegistersNumber(String pathRegistersNumber, int registersNumber) throws PatientStudiesNotFoundException, InterruptedException, TotalNumberPatientStudiesNotFoundException, ElementNotFoundException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.dropdown.paginator")) {
			throw new PatientStudiesNotFoundException();
		}
    	else {
			BasePage.pause();
			BasePage.clickElement("general-data.search-patient-history.dropdown.paginator");
			BasePage.clickElement(pathRegistersNumber);
			BasePage.pause();
			if (!BasePage.hasSameRows(registersNumber, "general-data.search-patient-history.tr-patient-studies-table")) {
				throw new TotalNumberPatientStudiesNotFoundException();
			}	
		}
    	
    }
    
    // Method that clicks on the patient's history list button
    public static void clickReloadPatientHistoryListButton() throws PatientStudiesNotFoundException, ElementNotFoundException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.reload-button")) {
    		throw new PatientStudiesNotFoundException();
    	}
    	else {
    		BasePage.clickElement("general-data.search-patient-history.reload-button");
    	}
    	
    }
    
    // Method that checks that the total of the patient's studies are shown
    public static void checkTotalPatientStudies() throws PatientStudiesNotFoundException, InterruptedException, TotalNumberPatientStudiesNotFoundException {
    	
    	BasePage.pause();
		
		if (!BasePage.existsElement("general-data.search-patient-history.total-studies-found")) {
			throw new PatientStudiesNotFoundException();
		}
		
    	if (!BasePage.elementContainText("general-data.search-patient-history.total-studies-found",
    			BasePage.getProperty("general-data.search-patient-history.total-studies-text"))) {
    		throw new TotalNumberPatientStudiesNotFoundException();
    	}
    	
    }
    
    // Method that checks that the order of the patient's history is displayed in descending order
    public static void checkPatientHistoryDownOrder() throws PatientStudiesNotFoundException, PatientStudiesIncorrectOrderException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.order-down-date-studies-icon")) {
    		throw new PatientStudiesNotFoundException();
    	}
    	
    	if (!BasePage.elementContainClass("general-data.search-patient-history.order-down-date-studies-icon",
    			"general-data.search-patient-history.order-down-date-studies-icon-class")) {
			throw new PatientStudiesIncorrectOrderException();
		}
    	
    }
    
    // Method that checks that the dropdown appears and the user clicks on it
    public static void clickInDropdown(String pathDropdownPosition) throws ElementNotFoundException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.dropdown.paginator")) {
			throw new ElementNotFoundException();
		}
    	else {
			BasePage.clickElement(pathDropdownPosition);
		}
    	
    }
    
    // Method to click on an element
    public static boolean clickInDropdownRandomNumber(String pathElement) throws ElementNotFoundException {
    	
    	if (!BasePage.existsElement("general-data.search-patient-history.dropdown.paginator")) {
    		throw new ElementNotFoundException();
		}
    	else {
			BasePage.getAndClickRandomNumberElement(pathElement);
			return true;
		}
    	
    }
    
}
