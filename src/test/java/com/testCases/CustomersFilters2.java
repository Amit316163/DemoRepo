package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CustomersFilters2 extends BaseTest{
	/*Filters test cases
	 * only with Email id- contains or equals or start with or End with
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
		
		
		//Select dropdown value for filters with starts with
		selectDropdownvalue("EmailFilter_xpath", "username_contains");
		enterText("EmailFilter_id", "test");
		click(prop.getProperty("FilterButton_name"));
		
		//Validation point
		
		String user=driver.findElement(By.xpath("//*[@id='user_102']/td[4]")).getText();
		if(user.contains("test")) {
			System.out.println("Successfullly filters applied");
		}else {
			System.out.println("Unsuccessful response");
		}}
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
		
}
