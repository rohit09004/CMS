package com.csm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.csm.qa.base.CSMBase;

public class LoginPage extends CSMBase {
	
	//page Factory  or object repository
	@FindBy(id="UserId")
	WebElement UserID;
	
	@FindBy(id="Password")
	WebElement Password;
	
	@FindBy(xpath="//*[@type='submit']")
	WebElement login_Btn;
	
     @FindBy(xpath="//img[contains(@class,'profile-img-card')]")
     WebElement CMSLogo;
     
     @FindBy(id="btnClose")
     WebElement closePasswordPoup;
     
    //Initialize Page object  
     public LoginPage(WebDriver driver)
     {
    	 PageFactory.initElements(driver,this);
     }
     
     public HomePage login(String uid, String pwd) throws InterruptedException
     {
    	 UserID.sendKeys(uid);
    	 Password.sendKeys(pwd);
    	 login_Btn.click(); 
    	 Thread.sleep(3000);
    	 closePasswordPoup.click();
    	 return new HomePage();
    		
     }

}
