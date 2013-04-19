/**
 * 
 */
package com.mdmp.server.common;

import java.util.HashMap;
import java.util.Map;

public class ConfigurationManager {
	private static final String DEFAULT_PROPERTY_URL = "default.properties";
	private static Map<String, MDMPAPIConfiguration> cache = new HashMap<String, MDMPAPIConfiguration>();

	public static MDMPAPIConfiguration getDefaultConfig() {
		return getConfigFrom(DEFAULT_PROPERTY_URL);
	}

	public static MDMPAPIConfiguration getConfigFrom(String path) {
		if (cache.containsKey(path)) {
			return cache.get(path);
		}
		synchronized (cache) {
			if (cache.containsKey(path)) {
				return cache.get(path);
			}
			final MDMPAPIConfiguration conf = new MDMPAPIConfiguration(path);
			cache.put(path, conf);
			return cache.get(path);
		}
	}
}
