package com.inetbanking.testcases;

import java.io.File;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
	String baseurl=readconfig.getApplicationURL();
	String username=readconfig.getUsername();
	String password=readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser) {
		if(browser.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
		
		 driver=new ChromeDriver(dc);
		}
		else if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver=new FirefoxDriver();
		}
		else if(browser.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
			driver=new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseurl);
		driver.manage().window().maximize(); 
		
	  
		
		logger=Logger.getLogger("inetbanking");
		PropertyConfigurator.configure("Log4j.properties");
		
	}
	
	@AfterClass
	public void teardown() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		//System.out.println("before taking screenshot in "+tname);
		//TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
		
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + System.currentTimeMillis() + ".png");
		
		FileUtils.copyFile(source, target);
		
		System.out.println("Screenshot taken");
	}
	/* public  String randomString() {
	    	String generatedstring=RandomStringUtils.randomAlphabetic(5);
	    	return(generatedstring);
	    }
	    public static String randomnum() {
	    	String generatedString2=RandomStringUtils.randomNumeric(4);
	    	return generatedString2;
	    }
	    */

}
