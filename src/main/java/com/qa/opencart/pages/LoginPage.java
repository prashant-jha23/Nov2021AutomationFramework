package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.utills.Constaints;
import com.qa.opencart.utills.ElementUtils;

public class LoginPage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@type='submit']");
	private By forgotPWDlink = By.linkText("Forgotten Password");
	private By registerlink=By.linkText("Register");
	
	//2. page constructor
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
	}

//3.public page actions/methods:
	public String getLoginPageTitle() {
		return elementUtils.doGetPageTitlesIs(Constaints.LOGIN_PAGE_TITLE, Constaints.DEFAULT_TIME_OUT);
	}
	public String getLoginpageURL() {
		return elementUtils.waitForUrlContains(Constaints.LOGIN_PAGE_URL_FRACTION, Constaints.DEFAULT_TIME_OUT);
	}
	public boolean isForgotPwdLinkExists() {
		return elementUtils.doIsDisplayed(forgotPWDlink);
	}
	public AccountsPage doLogin(String userName, String pwd) {
		elementUtils.doSendKeys(emailId, userName);
		elementUtils.doSendKeys(password, pwd);
		elementUtils.doClick(loginBtn);
		return new AccountsPage(driver);	
	}
	public RegisterPage gotoRegisterPage() {
		elementUtils.doClick(registerlink);
		return new RegisterPage(driver);
	}
	
}
