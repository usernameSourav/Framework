package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;
	public LoginPage(WebDriver ldriver) {
		
		this.driver=ldriver;
		
	}
	
	@FindBy(id="txtUsername")
	WebElement userid;
	@FindBy(id="txtPassword")
	WebElement userpwd;
	@FindBy(id="btnLogin")
	WebElement submit;
	
	public void login(String username,String password)  {
		userid.sendKeys(username);
		userpwd.sendKeys(password);
		submit.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
