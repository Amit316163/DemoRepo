package com.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.base.BaseTest;

public class CreateAccount2 extends BaseTest{
	
	public String TestCaseName="CreateInValidCustomerIDTC1";
	
	/*Validate Invalid test cases
	 * Blank username and Pass the password and email id 
	 * Click on submit button and validate
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
		
		//Create new user id with invalid details
	
		click(prop.getProperty("Users_xpath"));
		click(prop.getProperty("NewUser_xpath"));
		enterText("Username_id", "Username_blank");//Empty username
		enterText("Password_id", "Password_value");
		enterText("Email_id", "Email_value");
		click(prop.getProperty("CreateUser_name"));
		
		//Validation point 
		String username= driver.findElement(By.xpath("PageTitle_id")).getText();
		if(username.equalsIgnoreCase("Amit0777")) {
			System.out.println("New user ID created successfully");
		}else {
			System.out.println("User ID creation failed");
		}
		//Store the error and print on console		
		String error=driver.findElement(By.xpath("//p[@class='inline-errors']")).getText();
		System.out.println(error);
		
		System.out.println("running"+TestCaseName);
	}
	@AfterMethod
	public void close() {
		driver.quit();
	}
		
	

}
