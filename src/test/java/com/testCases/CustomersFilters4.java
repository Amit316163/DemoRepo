package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CustomersFilters4 extends BaseTest{
	/*Filters test cases
	 * Filters with username- ends with
	 * Filters with email id- starts with
	 *  Filters with Date- From and To
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
		
		
		//Apply all filters 
		
		selectDropdownvalue("EmailFilter_xpath", "username_contains");
		enterText("UsernameFilter_id", "test");
		enterText("EmailFilter_id", "test");
		enterText("FromDate_name", "2018-05-05");
		enterText("ToDate_name", "2019-02-02");
		click(prop.getProperty("FilterButton_name"));
		
		//Validation point		
		String username=driver.findElement(By.xpath("//td[@class='col col-username']")).getText();
		if(username.contains("test")) {
		System.out.println("Successfullly filters applied");
		}else {
		System.out.println("Unsuccessful response");
		}
		
		}
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
		
}
