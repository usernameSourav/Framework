package com.framework.testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import com.framework.pages.LoginPage;


public class LoginToApp extends BaseClass {

	@Test
	public void login() {
		
		logger=report.createTest("Log in to OrangeHrm");
		
		LoginPage loginp = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Start App");
		loginp.login(excel.getStringData("CredentialsAdmin", 0, 0),excel.getStringData("CredentialsAdmin", 0,1) );
		
		logger.pass("login done successful ");
	}
}
