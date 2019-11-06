package com.framework.utility;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ConfigDataProvider {

	public Properties pro;

	public ConfigDataProvider() {

		File src = new File("./Config/Config.properties");

		try {
			FileInputStream fis = new FileInputStream(src);

			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println(" Properties file not able load " + e.getMessage());
		}

	}

	public String getConfigData(String searchkey) {
		return pro.getProperty(searchkey);
	}

	public String getConfigBrowser() {
		return pro.getProperty("BrowserName");
	}

	public String getConfigUrl() {
		return pro.getProperty("URL");
	}
}
