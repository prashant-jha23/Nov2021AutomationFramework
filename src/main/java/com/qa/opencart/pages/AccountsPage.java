package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utills.Constaints;
import com.qa.opencart.utills.ElementUtils;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	private By header =By.xpath("//div[@id='logo']");
	private By sections=By.xpath("//div[@id='content']//h2");
	private By logoutLink=By.linkText("Logout");
	private By search =By.name("search");
	private By searchIcon=By.xpath("//span[@class='input-group-btn']");
	
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
		
	}
    public String getAccountPageTitle() {
    	return elementUtils.doGetPageTitlesIs(Constaints.ACCOUNT_PAGE_TITLE, Constaints.DEFAULT_TIME_OUT);
    }
    public String getAccountPageURL() {
    	return elementUtils.waitForUrlContains(Constaints.ACCOUNT_PAGE_URL_FRACTION, Constaints.DEFAULT_TIME_OUT);
    }
    public String getAccPageHeader() {
    	return elementUtils.doGetText(header);
    }
    
    public boolean isLogoutLinkExist() {
    	return elementUtils.doIsDisplayed(logoutLink);
    }
    public boolean logout() {
    	if(isLogoutLinkExist()) {
    		return true;
    	}
    	return false;
}
    public List<String> getAccPageSections() {
    	List<WebElement>sectionsList=elementUtils.waitForElementsVisible(sections, 10);
    	List<String> secValueList=new ArrayList<String>();
    	for(WebElement e:sectionsList)
    	{
    		String val=e.getText();
    		secValueList.add(val);
    	}
    	return secValueList;
    }
    
    public boolean searchExist() {
    	return elementUtils.doIsDisplayed(search);
    }
    public void doSearch(String productName) {
    	if(searchExist()) {
    		elementUtils.doSendKeys(search, productName);
    		elementUtils.doClick(searchIcon);
    	}
    }
}