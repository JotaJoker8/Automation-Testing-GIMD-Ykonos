package es.sescam.automation.testing.gimd.ykonos.steps;

import org.apache.commons.configuration2.ex.ConfigurationException;

import cucumber.api.java.en.*;
import es.sescam.automation.testing.gimd.ykonos.exceptions.ElementNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.IncorrectUserException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.PageNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.UserNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.page.TestLinkPage;
import es.sescam.automation.testing.gimd.ykonos.util.BasePage;
import testlink.api.java.client.TestLinkAPIException;

public class SomeCentersUserAuthenticationSteps {
	
	@Given("^tenemos un usuario LDAP con categoria medico$")
    public void medicalUser() {}
    
    @And("^el usuario tiene definido DG$")
    public void userHasDG() {}
    
    @And("^el usuario tiene definido CMBD$")
    public void userHasCMBD() {}
    
    @And("^el usuario existe en GIMD Ykonos con varios centros asociados$")
    public void userExists() {}
    
    @When("^se indica el usuario correctamente$")
    public void enterUser() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {

    	if (!BasePage.existsElement("general-data.authentication.credentials.user-position")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new ElementNotFoundException();
    	}
    	else {
    		BasePage.writeText("general-data.authentication.credentials.user-position",
        			BasePage.getProperty("general-data.authentication.credentials.user"));
    	}
    	
    }

    @And("^se indica la contraseña correctamente$")
    public void enterPassword() throws ElementNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.authentication.credentials.password-position")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new ElementNotFoundException();
    	}
    	else {
        	BasePage.writeText("general-data.authentication.credentials.password-position",
        			BasePage.getProperty("general-data.authentication.credentials.password"));
    	}
    	
    }
    
    @And("^se da al botón 'Acceder'$")
    public void clickAccess() throws ElementNotFoundException, IncorrectUserException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.access-button")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new ElementNotFoundException();
    	}
    	else {
    		BasePage.clickElement("general-data.access-button"); 
    	}	
    	
		if (BasePage.existsElement("general-data.authentication.error-messages.position")) {
			TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new IncorrectUserException();
    	}

    }

    @Then("^se accede a la pantalla para seleccionar el centro$")
    public void accessWelcomePage() throws ElementNotFoundException, InterruptedException, PageNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.navigateCorrect("general-data.welcome-url")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new PageNotFoundException();
    	}
    	else {
    		if (!BasePage.existsElement("general-data.access-center-button")) {
    			TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
        				BasePage.getProperty("general-data.authentication.credentials.password"),
        				"test-cases.authentication-users-some-centers");
    			throw new ElementNotFoundException();
    		}
    		else {
            	BasePage.clickElement("general-data.access-center-button");
            	BasePage.pause();
            	if (!BasePage.navigateCorrect("general-data.search-patients.url")) {
            		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
            				BasePage.getProperty("general-data.authentication.credentials.password"),
            				"test-cases.authentication-users-some-centers");
            		throw new PageNotFoundException();
            	}	
    		}
    	}
    
    }

    @And("^se indica el nombre del usuario$")
    public void showUserName() throws UserNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.user-name")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new UserNotFoundException();
    	}
    	
    }
    
    @And("^se muestra el rol del usuario$")
    public void showUserRol() throws UserNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.user-rol")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new UserNotFoundException();
    	}
    	
    }
    
    @And("^se muestra la especialidad CMBD del usuario$")
    public void showUserSepeciality() throws UserNotFoundException, TestLinkAPIException, ConfigurationException  {
    	
    	if (!BasePage.existsElement("general-data.user-specialty")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new UserNotFoundException();
    	}
    	
    }
    
    @And("^se muestra un combo desplegable para los centros asociados al paciente$")
    public void showCentersUser() throws UserNotFoundException, TestLinkAPIException, ConfigurationException {
    	
    	if (!BasePage.existsElement("general-data.user-center")) {
    		TestLinkPage.testLinkLoginFailed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    		throw new UserNotFoundException();
    	}
    	else {
    		TestLinkPage.testLinkLoginPassed(BasePage.getProperty("general-data.authentication.credentials.user"),
    				BasePage.getProperty("general-data.authentication.credentials.password"),
    				"test-cases.authentication-users-some-centers");
    	}    
    	
    }
    
}
