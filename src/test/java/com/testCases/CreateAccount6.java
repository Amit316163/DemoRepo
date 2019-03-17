package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CreateAccount6 extends BaseTest{
	
	public String TestCaseName="CreateValidCustomerIDTC6";
	/*Validate Invalid test cases
	 * Click on Cancel button after passing username,password and email
	 * Validate the condition
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
		
		//Click on cancel button
		click(prop.getProperty("Users_xpath"));
		click(prop.getProperty("NewUser_xpath"));
		enterText("Username_id", "Username_value");
		enterText("Password_id", "Password_value");
		enterText("Email_id", "Email_value");
		click(prop.getProperty("CancelButton_xapth"));
		
		//Validation point
		String username= driver.findElement(By.xpath("PageTitle_id")).getText();
		if(username.equalsIgnoreCase("Amit0777")) {
			System.out.println("New user ID created successfully");
		}else {
			System.out.println("User ID creation failed");
		}
		
		
		
		System.out.println("running"+TestCaseName);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}

}
