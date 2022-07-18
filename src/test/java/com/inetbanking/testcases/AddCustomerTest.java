package com.inetbanking.testcases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.AddCustomerPage;
import com.inetbanking.pageobjects.LoginPage;

import junit.framework.Assert;

public class AddCustomerTest extends BaseClass {
	
    @Test
	public void addnewcustomer() throws InterruptedException, IOException {
    	LoginPage lp=new LoginPage(driver);
    	lp.setusername(username);
    	logger.info("username is provided");
    	lp.setpassword(password);
    	logger.info("password is provided");
    	lp.clickSubmit();
    	Thread.sleep(3000);
    	
    	AddCustomerPage addcust=new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		logger.info("providing customer details");
		
		addcust.custName("ram");
		addcust.custgender("male");
		addcust.custdob("10", "15", "1985");
		Thread.sleep(3000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("999999999");
		
		String email=randomString()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("abcdef");
		addcust.custsubmit();
		
		Thread.sleep(3000);
		logger.info("validation started");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true) {
			Assert.assertTrue(true);
			logger.info("test case is passed");
		}
		else {
			captureScreen(driver,"addnewcustomer");
			Assert.assertTrue(false) ;
			logger.info("test case is failed");
		}
	}
    //to generate email dynamacially we create a user defined function
    
    public  String randomString() {
    	String generatedstring=RandomStringUtils.randomAlphabetic(5);
    	return(generatedstring);
    }
   /* public static String randomnum() {
    	String generatedString2=RandomStringUtils.randomNumeric(4);
    	return generatedString2;
    }
    */
    
    
    
    
    
    
    
    
    
    
}
