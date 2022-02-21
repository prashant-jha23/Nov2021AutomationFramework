package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest{
	
	@BeforeClass
	public void regSetUp() {
		regPage=loginpage.gotoRegisterPage();
	}
    @Test
    public void userRegistrationTest() throws InterruptedException {
    	regPage.accountRegistration("Ram", "vaada", "ramvaada@gmail.com", "909090909", "ram@123", "yes"); 
    //	Assert.assertTrue(regPage.accountRegistration("Ram", "vaada", "ramvaada1@gmail.com", "91909090", "ram@123", "yes"));
    }
}
