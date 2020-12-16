package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

import pageBeans.ViewPersonalDetails;

public class PersonalDetailsTest {
	WebDriver driver;
	private ViewPersonalDetails objelppf;
	public int testCount;
	
	@BeforeMethod
	public void setUp() throws Throwable {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\abc\\Downloads\\Programs\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		objelppf = new ViewPersonalDetails(driver);
		objelppf.setUname("Admin");
		objelppf.setPwd("admin123");
		objelppf.setLogin();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		objelppf.setPimLink();
		Thread.sleep(1000);
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromExcel();
		return testData.iterator();
	}
	
	@Test(dataProvider = "getTestData")
	public void personalDetailsPageTest(String en, String eID, String sn) throws Throwable {
		testCount++;
		Thread.sleep(1000);
		objelppf.getPfename().clear();
		objelppf.setEmpName(en);
		objelppf.getPfeid().clear();
		objelppf.setEmpID(eID);
		objelppf.getPfsname().clear();
		objelppf.setSupName(sn);
		Thread.sleep(1000);
		System.out.println("TEST CASE: " + testCount);
		System.out.println("Employee name: " + en);
		System.out.println("Employee ID: " + eID);
		System.out.println("Supervisor name: " + sn);
		
	    String data = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr/td")).getText();
	    if(data.contentEquals("No Records Found")) {
	    	System.out.println("Status: **********PASSED");
	    }
	    else {
	    	System.out.println("Status: **********FAILED");
	    }
	    driver.close();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
