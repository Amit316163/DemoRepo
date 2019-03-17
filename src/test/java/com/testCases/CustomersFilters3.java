package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CustomersFilters3 extends BaseTest{
	/*Filters test cases
	 * only with Date from and To
	 * Click on Filter button 
	 */
	
	@Test
	public void CreateAccountTC() {
		//Read value from your config properties file
		
		loadConfig();
		
		launchbrowser(prop.getProperty("Browser"));
		navigate(prop.getProperty("URL"));
		waits(prop.getProperty("Users_xpath"));
		
		//Verify the condition
		boolean b=driver.findElement(By.xpath("//*[@id='users']/a")).isDisplayed();
		Assert.assertTrue(b, "User");
		
		
		//Pass the date filter
		enterText("FromDate_name", "2018-05-05");
		enterText("ToDate_name", "2019-02-02");
		click(prop.getProperty("FilterButton_name"));
		
		}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
		
}
