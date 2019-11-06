package com.framework.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	
	public static WebDriver openApplication(WebDriver driver,String browserName,String appURL) {
		
		if(browserName.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else  if(browserName.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		
		else  if(browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "./Driver/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}
		else {
			System.out.println("Browser not supported");
			
		}
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public static void tearDown(WebDriver driver) {
		driver.quit();
	}
}
