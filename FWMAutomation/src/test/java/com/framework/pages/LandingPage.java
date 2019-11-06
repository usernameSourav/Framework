package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver ldriver) {
		this.driver=ldriver;
		
	}
	@FindBy(css="a.login")
	WebElement name;
	
	public void clickOnLogin() {
		name.click();
	}
	
}
