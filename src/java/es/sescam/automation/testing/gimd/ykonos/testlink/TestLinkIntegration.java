package es.sescam.automation.testing.gimd.ykonos.testlink;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.ex.ConfigurationException;

import es.sescam.automation.testing.gimd.ykonos.constant.ConstantClass;
import es.sescam.automation.testing.gimd.ykonos.util.TestDataUtil;
import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	
	private TestLinkIntegration() {
		throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
	}
	
	public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException, ConfigurationException {
		
		Configuration config = TestDataUtil.loadTestsData(ConstantClass.TEST_DATA_LINK_PATH);
		
		TestLinkAPIClient testlink = new TestLinkAPIClient(config.getString("config-data.key"),
				config.getString("config-data.url"));
		
		testlink.reportTestCaseResult(config.getString("config-data.project-name"),
				config.getString("config-data.plan-name"), testCaseName,
				config.getString("config-data.build-name"), exception, results);
		
	}
	
}
