package es.sescam.automation.testing.gimd.ykonos.util;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.BasicConfigurationBuilder;
import org.apache.commons.configuration2.builder.ConfigurationBuilder;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.commons.configuration2.io.FileHandler;

public class TestDataUtil {
	
	private TestDataUtil() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}

	public static Configuration loadTestsData(String path) throws ConfigurationException {

		ConfigurationBuilder<XMLConfiguration> testsDataConfigurationBuilder = new BasicConfigurationBuilder<>(XMLConfiguration.class);

		XMLConfiguration testsDataConfiguration = testsDataConfigurationBuilder.getConfiguration();

		FileHandler testsDataFileHandler = new FileHandler(testsDataConfiguration);
		testsDataFileHandler.load(TestDataUtil.class.getResourceAsStream(path));
		
		return testsDataConfiguration;

	}
	
}
