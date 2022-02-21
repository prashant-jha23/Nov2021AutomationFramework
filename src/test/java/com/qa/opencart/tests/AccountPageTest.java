package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.utills.Constaints;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void accPageSetUp()
	{
		acountpage=loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	@Test
	public void accPageTitleTest() {
	String actTitle=acountpage.getAccountPageTitle();	
	System.out.println("Acc pagetitle: "+actTitle);
	Assert.assertEquals(actTitle, Constaints.ACCOUNT_PAGE_TITLE);
	}

	@Test
	public void accPageUrlTest() {
	String actUrl=acountpage.getAccountPageURL();	
	System.out.println("Acc page url: "+actUrl);
	Assert.assertTrue(actUrl.contains(Constaints.ACCOUNT_PAGE_URL_FRACTION));
	}
	
	@Test
	public void accPageHeaderTest() {
		String header=acountpage.getAccPageHeader();
		System.out.println("Accout page header "+header);
		Assert.assertEquals(header, Constaints.ACCOUNT_PAGE_HEADER);
	}
    @Test
    public void logoutLinkTest() {
    	Assert.assertTrue(acountpage.isLogoutLinkExist());
    }
    @Test
    public void accPageSectionsTest() {
    	List<String>accSectionsList=acountpage.getAccPageSections();
    	Assert.assertEquals(accSectionsList,Constaints.ACCOUNT_PAGE_SECTIONS_LIST);
    }
    
}
