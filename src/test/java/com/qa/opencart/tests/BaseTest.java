package com.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.RegisterPage;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	LoginPage loginpage;
	Properties prop;
	RegisterPage regPage;
	
	AccountsPage acountpage;
	
	@BeforeTest
	public void setup() {
		df=new DriverFactory();
		prop=df.init_prop();
		driver=df.init_driver(prop);
		loginpage=new LoginPage(driver);
	}
		
		
	@AfterTest
	public void tearDown() {
		driver.quit();
		
	}

}
