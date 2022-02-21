package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utills.Constaints;

public class LoginPageTest extends BaseTest{
	
	@Test(priority=1)
	public void loginPageTitleTest() {
	String title=loginpage.getLoginPageTitle();
	System.out.println("Login page title "+ title);
	Assert.assertEquals(title, Constaints.LOGIN_PAGE_TITLE);
		
	}
	
	@Test(priority=2)
	public void loginPageURLTest() {
	String url=loginpage.getLoginpageURL();
	System.out.println("Login page url "+ url);
	Assert.assertTrue((url.contains(Constaints.LOGIN_PAGE_URL_FRACTION)));	
	}
	
	@Test(priority=3)
	public void ForgotPwdLinkTest() {
	Assert.assertTrue(loginpage.isForgotPwdLinkExists());
		
	}
	
	@Test(priority=4)
	public void loginTest() {
	acountpage	=loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password"));
	Assert.assertTrue(acountpage.isLogoutLinkExist());
	}

}
