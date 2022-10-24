package es.sescam.automation.testing.gimd.ykonos.page;

import es.sescam.automation.testing.gimd.ykonos.exceptions.PatientsNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;

public class HistoryPatientPage {
	
	private HistoryPatientPage() {}
	
	// Method that verifies that the patient´s name and surname searched are found in the table
    public static void checkSearchPatientDataCriteria(int numberColumnName, int numberColumnSurname) throws PatientsNotFoundException {
    	
    	if ((!BasePage.checkDataTable("general-data.search-patients.tr-patients-table", numberColumnName,
    			BasePage.find(BasePage.getProperty("general-data.search-patients.name-searched")).getAttribute("value"))
    			|| (!BasePage.checkDataTable("general-data.search-patients.tr-patients-table", numberColumnSurname, 
    			BasePage.find(BasePage.getProperty("general-data.search-patients.surname-searched")).getAttribute("value")
    			)))) {
			throw new PatientsNotFoundException();
		}
    	
    }
	
}
