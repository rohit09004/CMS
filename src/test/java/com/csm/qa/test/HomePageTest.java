package com.csm.qa.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.csm.qa.base.CSMBase;
import com.csm.qa.pages.HomePage;
import com.csm.qa.pages.LoginPage;


public class HomePageTest extends CSMBase {
		HomePage homePage;
		LoginPage loginPage;
	
		
	@BeforeMethod
	public void setup() throws InterruptedException
	{
		initialize();
		loginPage= new LoginPage(driver);
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));	
	}

	@Test(priority=2)
	public void clickOnCMSModule() throws InterruptedException
	{
	
		
 		homePage.clickOnCMSModuleMenu();
		System.out.println("Test 2 passed");
		Thread.sleep(1000);
	
	}
	
	@Test(priority=3)
	public void clickonIDC() throws InterruptedException
	{
	
		
		clickOnCMSModule();
		System.out.println("Test 3 passed ");
	    Thread.sleep(1000);
	    driver.quit();
	    
	
	}
}
