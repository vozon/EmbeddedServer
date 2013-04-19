/**
 * 
 */
package com.mdmp.server.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MDMPAPIConfiguration {
	/** The properties config. */
	private Properties propertiesConfig = new Properties();
	private static final Logger LOG = LoggerFactory
			.getLogger(MDMPAPIConfiguration.class);

	public MDMPAPIConfiguration(String url) {
		parseConfig(url);
	}

	// we should include not change and change - two parts in one configuration
	private void parseConfig(String url) {
		if (url != null) {

			InputStream in = this.getClass().getClassLoader()
					.getResourceAsStream(url); // parasoft-suppress
												// BD.SECURITY.TDFNAMES
												// "not an issue"
			try {
				// it is an absolute URL, then we goes into file
				if (in == null) {
					File f = new File(url);
					in = new FileInputStream(f);
				}
				if (in != null) {
					propertiesConfig.clear();
					propertiesConfig.load(in);
				}
			} catch (IOException e) {
				LOG.error(e.getMessage());
			} finally {
				try {
					if (in != null)
						in.close();
				} catch (IOException e) {
					// ignore
				}
			}
		}
	}

	public String getValue(String configName) {
		return getValue(configName, null);
	}

	public String getValue(String configName, String defaultValue) {
		if (null == configName) {
			return defaultValue;
		}
		return propertiesConfig.getProperty(configName, defaultValue);
	}

	public Properties getProperties() {
		return propertiesConfig;
	}
}
