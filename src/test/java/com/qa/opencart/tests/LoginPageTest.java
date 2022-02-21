package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.utills.Constaints;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void loginPageTitleTest() {
	String title=loginpage.getLoginPageTitle();
	System.out.println("Login page title "+ title);
	Assert.assertEquals(title, Constaints.LOGIN_PAGE_TITLE);
		
	}
	
	@Test
	public void loginPageURLTest() {
	String url=loginpage.getLoginpageURL();
	System.out.println("Login page url "+ url);
	Assert.assertTrue((url.contains(Constaints.LOGIN_PAGE_URL_FRACTION)));	
	}
	
	@Test
	public void ForgotPwdLinkTest() {
	Assert.assertTrue(loginpage.isForgotPwdLinkExists());
		
	}
	
	@Test
	public void loginTest() {
	acountpage	=loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password"));
	Assert.assertTrue(acountpage.isLogoutLinkExist());
	}

}
