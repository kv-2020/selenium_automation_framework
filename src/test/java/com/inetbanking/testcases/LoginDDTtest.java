 package com.inetbanking.testcases;

import java.io.IOException;


import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageobjects.LoginPage;
import com.inetbanking.utilities.XLUtils;



public class LoginDDTtest extends BaseClass{
	@Test(dataProvider="logindata")
	public void loginddt(String user,String pwd) throws InterruptedException {
		LoginPage lp=new LoginPage(driver);
		lp.setusername(user);
		logger.info("username provided");
		lp.setpassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		logger.info("Is Alert present"+isAlertPresent());
		if(isAlertPresent()==true) {
			
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);//failure case
			logger.warn("login failed");
			
		}
		
		else {
			Assert.assertTrue(true);
			logger.info("login passed"); 
	
			lp.clicklogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close the logout alert
			driver.switchTo().defaultContent();
		}
		
	}
	//userdefined method created to check if alert is present or not so no annotation
	public boolean isAlertPresent() {
		try {
			
			driver.switchTo().alert();
			
			return true;
		}
		catch(NoAlertPresentException e) {
			
			return false;
		}
	}
	
	
	
	@DataProvider(name="logindata")
	String [][]getdata() throws IOException{
		String path="C:\\Users\\kittu\\wblframework\\inetbanking\\src\\test\\java\\com\\inetbanking\\testdata\\LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][]=new String[rownum][colcount]; 
		//0 is for header..column is 0
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colcount;j++ ) {
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1  0
			}
		}
		return logindata;
	}
	

}
