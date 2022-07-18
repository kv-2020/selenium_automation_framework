
package com.inetbanking.testcases;
import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;



public class LoginTest extends BaseClass {
	@Test
	public void logintest() throws IOException, InterruptedException  {
		
		logger.info("url is opened");
		LoginPage lp=new LoginPage(driver);
		lp.setusername(username);
		logger.info("entered username");
		lp.setpassword(password);
		logger.info("entered password");
		
		
		lp.clickSubmit();
		
		captureScreen(driver,"logintest");
		
		
	
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("login test passed");
		}
		else {
			
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("login test failed");
		}
	}

}
