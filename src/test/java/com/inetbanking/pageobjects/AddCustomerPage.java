package com.inetbanking.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	WebDriver driver;
	public AddCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="/html/body/div[3]/div/ul/li[2]/a")
	WebElement lnkAddNewCustomer;

	@FindBy(name = "name")
	WebElement txtCustomerName;

	@FindBy(name= "rad1")
	WebElement rdGender;

	
	@FindBy(id= "dob")
	WebElement txtdob;

	
	@FindBy(name= "addr")
	WebElement txtaddress;

	
	@FindBy(name = "city")
	WebElement txtcity;

	
	@FindBy(name = "state")
	WebElement txtstate;

	
	@FindBy(name = "pinno")
	WebElement txtpinno;

	
	@FindBy(name= "telephoneno")
	WebElement txttelephoneno;

	
	@FindBy(name= "emailid")
	WebElement txtemailid;

	
	@FindBy(name= "password")
	WebElement txtpassword;

	
	@FindBy(name = "sub")
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
			
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
		
	}

	public void custgender(String cgender) {
		rdGender.click();
	}

	public void custdob(String mm,String dd,String yy) {
		
		txtdob.sendKeys(mm);
		
		txtdob.sendKeys(dd);
	
		txtdob.sendKeys(yy);
	
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	
	

}
