package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {//constructor
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="uid")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	//@FindBy(type="password")
	//WebElement password;
	
	@FindBy(name="btnLogin")
	WebElement login;
	
	//@FindBy(xpath="/html/body/div[3]/div/ul/li[15]/a")
	//WebElement lnklogout; 
	
	@FindBy(xpath="//a[text()='Log out']")
	WebElement lnklogout; 
	
	//username.sendkeys("abc")
	public void setusername(String uname) {
		username.sendKeys(uname);
	}
	public void setpassword(String pword) {
		password.sendKeys(pword);
	}
	public void clickSubmit() {
		login.click();
	}
	public void clicklogout() {
		lnklogout.click();
	}
	 
	

}
