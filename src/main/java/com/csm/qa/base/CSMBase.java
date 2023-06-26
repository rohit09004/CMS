package com.csm.qa.base;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.csm.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CSMBase {
	
	public static WebDriver driver;
	public static  Properties prop;
	ExtentReports extent;
	ExtentTest test;
	public static Sheet sh;
	
	public CSMBase()
	{
		try
		{
		   prop = new Properties();
           File file =new File("configg.txt");
		 // System.out.println(file.getAbsolutePath());
           String Path1= file.getAbsolutePath().toString();
		   FileInputStream fs = new FileInputStream(Path1);
		   prop.load(fs);
        }catch(FileNotFoundException e)
		{
	    	e.printStackTrace();
		
		}catch(IOException e) {
		
			e.printStackTrace();
		}	
	}
	// read the property
	public static void initialize() throws InterruptedException
	{
	 
        WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.pageload_wait));
		 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicit_wait));
		 driver.get(prop.getProperty("url"));//url is launched 
    }
	
	
}