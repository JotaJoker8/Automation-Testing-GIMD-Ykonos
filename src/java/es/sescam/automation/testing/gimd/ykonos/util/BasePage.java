package es.sescam.automation.testing.gimd.ykonos.util;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.configuration2.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import es.sescam.automation.testing.gimd.ykonos.constant.ConstantClass;
import es.sescam.automation.testing.gimd.ykonos.exceptions.ElementNotFoundException;
import es.sescam.automation.testing.gimd.ykonos.exceptions.IncorrectConfigurationException;

public class BasePage {
    
	private BasePage() {}
	
	private static WebDriver driver;
	private static WebDriverWait wait;
	private static WebElement element;
	private static Configuration config;
	
	// Method that starts the application
	public static void initializeBrowser() throws IncorrectConfigurationException {
    	
		try {
			config = TestDataUtil.loadTestsData(ConstantClass.TEST_DATA_PATH);
			System.setProperty(config.getString("general-data.chrome-driver"), config.getString("general-data.chrome-driver-route"));
	        ChromeOptions chromeOptions = new ChromeOptions();
	        driver = new ChromeDriver(chromeOptions);
	        wait = new WebDriverWait(driver, config.getInt("general-data.explicit-wait"));
	        startTest();
		} catch (Exception e) {
			throw new IncorrectConfigurationException();
		}
		
    }
	
	// Method to close the browser
	public static void closeBrowser() {
        driver.quit();
    }

	// Method that returns true if the navigation is correct
    public static boolean navigateCorrect(String pathUrl) {
    	return getProperty(pathUrl).equals(driver.getCurrentUrl());
    }
    
    // Method that returns the element´s value
    public static String getProperty(String keyProperty) {
    	return config.getString(keyProperty);
    }
    
    // Method that returns the element´s requested in an interval less than the explicit time
    public static WebElement find(String locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }            
    
    // Method that returns true if the element is found and cancels the exception throw
    public static boolean existsElement(String pathElement) {
    	
    	try {
    		return find(getProperty(pathElement)).isDisplayed();
		} catch (Exception e) {
			return false;
		}
   
    }
    
    // Method that returns true if the element contains the class indicated
    public static boolean elementContainClass(String pathElement, String className) {
    	
    	element = find(getProperty(pathElement));
    	String[] elementClass = element.getAttribute("class").split(" ");
    	
    	return Arrays.asList(elementClass).contains(getProperty(className));
    	
    }
    
    // Method that returns true if the element contains the text indicated 
    public static boolean elementContainText(String pathElement, String text) {
    	
    	element = find(getProperty(pathElement));
    	
    	return element.getText().toLowerCase().contains(text);
    	
    }
    
    // Method that indicates the implicit wait seconds that we want to keep the app stopped at a certain point
    public static void pause() throws InterruptedException {
        TimeUnit.SECONDS.sleep(config.getInt("general-data.implicitly-wait"));
    }
    
    // Method that returns true if it finds the patient´s data in the table
 	public static boolean checkDataTable(String pathTable, int numberColumnTable, String pathNameSearchedValue) {
 		
 		int rows = driver.findElements(By.xpath(getProperty(pathTable))).size();
 		
 		for (int i = 1; i <= rows; i++) {
 			String textColumn = find(getProperty(pathTable)+"["+i+"]/td["+numberColumnTable+"]").getText().toLowerCase();
 			if (!textColumn.contains(pathNameSearchedValue)) {
 				return false;
 			}
 		}

 		return true;
 		
    }
 	
 	// Method that clicks on the first position of an element
  	public static void getAndClickFirstElementPosition(String pathElement) {
  		
  		element = find(getProperty(pathElement)+"[1]");
  		element.click();

  	}
 	
  	// Method that clicks on the last position of an element
 	public static void getAndClickLastElementPosition(String pathElement) {
 		
 		int rows = driver.findElements(By.xpath(getProperty(pathElement))).size();
 		
 		element = find(getProperty(pathElement)+"["+rows+"]");
 		element.click();

 	}
 	
 	// Method to get an element´s random number, between 1 and its number of rows
 	public static int getRandomNumber(String pathElement) {
 		
 		int rows = driver.findElements(By.xpath(getProperty(pathElement))).size();
 		
 		return ThreadLocalRandom.current().nextInt(1, rows);
 		
 	}
 	
 	// Method that randomly clicks on an element´s member
 	public static void getAndClickRandomNumberElement(String pathElement) {
 		
 		int randomNumber = getRandomNumber(pathElement);

 		element = find(getProperty(pathElement)+"["+randomNumber+"]");
 		element.click();

 	}
 	
 	// Method that returns true if the returned number of rows is bigger than the compared number
 	public static boolean hasMoreRows(int rows, String path) {
 		
 		int rowsFound = driver.findElements(By.xpath(getProperty(path))).size();

 		return rowsFound > rows;
 		
 	}
 	
 	// Method that returns true if the returned number of rows is bigger or equal than to the compared number
 	public static boolean hasMinimumRows(int rows, String path) {
		
 		int rowsFound = driver.findElements(By.xpath(getProperty(path))).size();

		return rowsFound >= rows;
		
	}
 	
 	// Method that returns true if the returned number of rows is equal to the requested number
 	public static boolean hasSameRows(int rows, String path) {
 		
 		int rowsFound = driver.findElements(By.xpath(getProperty(path))).size();

 		return rowsFound == rows;
 		
 	}

 	// Method to click on an element
    public static boolean clickElement(String pathElement) throws ElementNotFoundException {
    	
    	element = find(getProperty(pathElement));
    	
    	if (!element.isDisplayed()) {
    		throw new ElementNotFoundException();
    	}
    	else {
        	element.click();
        	return true;
    	}
    	
    }
    
    // Method to double click on an element
    public static void doubleClick(String path) throws ElementNotFoundException {
    	
    	Actions action = new Actions(driver);
    	element = find(getProperty(path));
    	
    	if (!element.isDisplayed()) {
    		throw new ElementNotFoundException();
    	}
    	else {
    		action.doubleClick(element).perform();
    	}

    }
    
    // Method to write to an element
    public static void writeText(String path, String text) throws ElementNotFoundException {
    	
    	element = find(getProperty(path));
    	
    	if (!element.isDisplayed()) {
    		throw new ElementNotFoundException();
    	}
    	else {
    		element.clear();
            element.sendKeys(text);
    	}
    	
    }

    // Method that starts the test
 	private static void startTest() throws ElementNotFoundException {

 		maximizeBrowser();
 		navigateTo("general-data.login-url");
 		clickElement("general-data.details-button");
 		clickElement("general-data.link-url");
 		accessButtonIsEnabled("general-data.access-button");
 		
 	}
 	
 	// Method that returns true if the button is enabled
  	private static boolean accessButtonIsEnabled(String path) {
         return find(config.getString(path)).isEnabled();
    }
 	
  	// Method to navigate to a certain url
    private static void navigateTo(String url) {
        driver.get(config.getString(url));
    }
 	
    // Method to maximize the window´s browser 
 	private static void maximizeBrowser() {
 		driver.manage().window().maximize();
 	}

}
