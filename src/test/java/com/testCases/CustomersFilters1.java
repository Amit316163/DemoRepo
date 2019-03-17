package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CustomersFilters1 extends BaseTest{
	/*Filters test cases
	 * only with Username- contains or equals or start with or End with
	 * Click on Filter button 
	 * Note:-We can also performed view,edit and delete action on links
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
		
		
		//Select dropdown value for filters with contain
		selectDropdownvalue("UsernameFilter_xpath", "username_contains");
		enterText("UsernameFilter_id", "test");
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
