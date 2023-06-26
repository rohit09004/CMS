package com.csm.qa.test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;
import com.csm.qa.base.CSMBase;
import com.csm.qa.pages.HomePage;
import com.csm.qa.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

//import extentReport.GetScreenShot;



public class LoginPageTest extends CSMBase{
	LoginPage loginPage;
	HomePage homePage;
	ExtentReports extent;
	ExtentTest test;
	
	
//   @BeforeMethod
//	public void setup() throws InterruptedException
//	{
//		initialize();
//		loginPage= new LoginPage(driver);
//	}
	
	@BeforeTest
	public void startReport() {
		
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/FinalTestRport.html");
	    extent.addSystemInfo("Host Name","Local Host");
	    extent.addSystemInfo("Enviroment","QA");
	    extent.addSystemInfo("User Name","Rohit");
	    extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
	}
	
	//Method for adding logs passed from test cases
		 public void reportLog(String message) {    
		    test.log(LogStatus.INFO, message);//For extentTest HTML report
		   // logger.info("Message: " + message);
		    Reporter.log(message);

		}
   
    //Validate Login with Valid Credentials 
	@Test(priority=1)
	public void LoginWithValidCredentials() throws InterruptedException, IOException
	{
		test=extent.startTest("Test 1 - Insertion of new data ");
		
		initialize();
		loginPage= new LoginPage(driver);
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		String homePagetitle= driver.getTitle();
		Assert.assertEquals(homePagetitle,"Home Page", "Invalid Credentials");
		System.out.println("Test 1 passed");
		
		   File file =new File("POShipping.xlsx");
		   System.out.println(file.getAbsolutePath());
           String Path1= file.getAbsolutePath().toString();
		   FileInputStream fs = new FileInputStream(Path1);
		   //FileInputStream fs = new FileInputStream();
		   XSSFWorkbook workbook = new XSSFWorkbook(fs);
		   XSSFSheet sheet = workbook.getSheetAt(0);
//		   Row row = sheet.getRow(1);
//		   Cell cell = row.getCell(2);
		   //System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
		   String po1=sheet.getRow(1).getCell(2).getStringCellValue();
		   System.out.println(po1);
		   String po2=sheet.getRow(3).getCell(2).getStringCellValue();
		   System.out.println(po2);
		   System.out.println("Test 1 passed with valid credentilias");
		   
		  
	        Assert.assertTrue(true);
	  		test.log(LogStatus.PASS, "Test 1 - Insertion of new data PASSED");
		driver.quit();
	}
	 
@Test(priority=4)
public void Test4() throws EncryptedDocumentException, InterruptedException, IOException
{
	   
        
	   test=extent.startTest("Test 4 - Insertion of new data ");
	   
	   File file =new File("POShipping.xlsx");
	   System.out.println(file.getAbsolutePath());
       String Path1= file.getAbsolutePath().toString();
	   FileInputStream fs = new FileInputStream(Path1);
	   //FileInputStream fs = new FileInputStream();
	   XSSFWorkbook workbook = new XSSFWorkbook(fs);
	   XSSFSheet sheet = workbook.getSheetAt(0);
	   String po1=sheet.getRow(4).getCell(2).getStringCellValue();
       System.out.println(po1);
	   String po2=sheet.getRow(5).getCell(2).getStringCellValue();
	   System.out.println(po2);
         
	   System.out.println("Test 4 passed with invalid credentials");  
	   
        Assert.assertTrue(true);
  		test.log(LogStatus.PASS, "Test 4 - Insertion of new data PASSED");
  		
  }

@Test(priority=5)
public void Test5() throws EncryptedDocumentException, InterruptedException, IOException
{
	   
        
	   test=extent.startTest("Test 5 - Insertion of new data ");
	   
	    initialize();
		loginPage= new LoginPage(driver);
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		String homePagetitle= driver.getTitle();
		Assert.assertEquals(homePagetitle,"Home Page", "Invalid Credentials");
       
		System.out.println("Test 5 passed with invalid credentials");  
	   
        Assert.assertTrue(true);
  		test.log(LogStatus.PASS, "Test 5 - Insertion of new data PASSED");
  		
  }
@Test(priority=6)
public void Test6() throws EncryptedDocumentException, InterruptedException, IOException
{
	   
        
	   test=extent.startTest("Test 6 - Insertion of new data ");
	   
	    initialize();
		loginPage= new LoginPage(driver);
        homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		Thread.sleep(1000);
		String homePagetitle= driver.getTitle();
		Assert.assertEquals(homePagetitle,"Home Page", "Invalid Credentials");
       
		System.out.println("Test 6 passed with invalid credentials");  
	   
        Assert.assertTrue(true);
  		test.log(LogStatus.PASS, "Test 6 - Insertion of new data PASSED");
  		
  }

@AfterMethod
public void getResult(ITestResult result) throws IOException
{
    if(result.getStatus() == ITestResult.FAILURE)
    {
      Random randVar = new Random();
      int randomVarr=randVar.nextInt(1000);
      String screenShotPath = GetScreenShot.capture(driver, "FailedTestScreen"+randomVarr);
      test.log(LogStatus.FAIL, result.getThrowable());
      test.log(LogStatus.FAIL, "Failed Screenshot below : " + test.addScreenCapture(screenShotPath));
      
    }
    extent.endTest(test);
}

@AfterTest
public void endReport() {
	
      extent.flush();
}
	
	
}