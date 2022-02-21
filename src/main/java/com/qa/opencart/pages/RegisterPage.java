package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.internal.BaseTestMethod;

import com.qa.opencart.utills.Constaints;
import com.qa.opencart.utills.ElementUtils;

public class RegisterPage {
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	private By fristName=By.id("input-firstname");
	private By lastName=By.id("input-lastname");
	private By email=By.id("input-email");
	private By telephone=By.id("input-telephone");
	private By password=By.id("input-password");
	private By passwordconfirm=By.id("input-confirm");
	private By subscribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
	private By subscribeNo=By.id("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
	private By agreecheckbox=By.xpath("//input[@type='checkbox']");

	private By continueButton=By.xpath("//input[@type='submit']");
	private By sucessMessg=By.cssSelector("div#content h1");
	private By logoutLink=By.linkText("Logout");
	private By registerLink=By.linkText("Register");
	
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
	}
	
	public Boolean accountRegistration(String firstName, String lastName,String email, String telephone, String password, String subscribe) throws InterruptedException {
		elementUtils.doSendKeys(this.fristName, firstName);
		elementUtils.doSendKeys(this.lastName, lastName);
		elementUtils.doSendKeys(this.email, email);
		elementUtils.doSendKeys(this.telephone, telephone);
		elementUtils.doSendKeys(this.password, password);
		elementUtils.doSendKeys(this.passwordconfirm, password);
		
		if(subscribe.equalsIgnoreCase("yes")) {
			elementUtils.doClick(subscribeYes);
		}
		else {
			elementUtils.doClick(subscribeYes);
		}
		elementUtils.doClick(agreecheckbox);
		Thread.sleep(3000);
		elementUtils.doClick(continueButton);
		String successMesg=elementUtils.doGetText(sucessMessg);
		System.out.println(successMesg);
		if (successMesg.contains(Constaints.REGISTER_SUCCESS_MESSG)) {
			elementUtils.doClick(logoutLink);
			elementUtils.doClick(registerLink);
			return true;
		}
		return false;
	    }
	
	
}
